$(document).ready(function () {
    var md5File;
//监听分块上传过程中的时间点
    WebUploader.Uploader.register({
        "before-send-file": "beforeSendFile",  // 整个文件上传前
        "before-send": "beforeSend",  // 每个分片上传前
        "after-send-file": "afterSendFile"  // 分片上传完毕
    }, {
        //时间点1：所有分块进行上传之前调用此函数 ，检查文件存不存在
        beforeSendFile: function (file) {
            var deferred = WebUploader.Deferred();
            md5File = hex_md5(file.name + file.size);//根据文件名称，大小确定文件唯一标记，这种方式不赞成使用
            $.ajax({
                type: "POST",
                url: "/microclouds/checkFile",
                data: {
                    md5File: md5File, //文件唯一标记
                },
                async: false,  // 同步
                dataType: "json",
                success: function (response) {
                    if (response) {  //文件存在，跳过 ，提示文件存在
                        $('#' + file.id).find('p.state').text("file exist");
                    } else {
                        deferred.resolve();  //文件不存在或不完整，发送该文件
                    }
                }
            }, function (jqXHR, textStatus, errorThrown) { //任何形式的验证失败，都触发重新上传
                deferred.resolve();
            });
            return deferred.promise();
        },
        //时间点2：如果有分块上传，则每个分块上传之前调用此函数  ，判断分块存不存在
        beforeSend: function (block) {
            var deferred = WebUploader.Deferred();
            $.ajax({
                type: "POST",
                url: "/microclouds/checkChunk",
                data: {
                    md5File: md5File,  //文件唯一标记
                    chunk: block.chunk,  //当前分块下标
                },
                dataType: "json",
                success: function (response) {
                    if (response) {
                        deferred.reject(); //分片存在，跳过
                    } else {
                        deferred.resolve();  //分块不存在或不完整，重新发送该分块内容
                    }
                }
            }, function (jqXHR, textStatus, errorThrown) { //任何形式的验证失败，都触发重新上传
                deferred.resolve();
            });
            return deferred.promise();
        },
        //时间点3：分片上传完成后，通知后台合成分片
        afterSendFile: function (file) {
            $('#' + file.id).find('p.state').text('上传完成,后台处理中 . . .');
            var chunksTotal = Math.ceil(file.size / (10 * 1024 * 1024));
            if (chunksTotal >= 1) {
                //合并请求
                var deferred = WebUploader.Deferred();
                $.ajax({
                    type: "POST",
                    url: "/microclouds/merge",
                    data: {
                        name: file.name,
                        md5File: md5File,
                        chunks: chunksTotal
                    },
                    cache: false,
                    async: false,  // 同步
                    dataType: "json",
                    success: function (response) {
                        $("#picker").show();//显示上传框
                        if (response) {
                            $('#' + file.id).find('p.state').text('上传成功');
                            $('#' + file.id).find('.progress').fadeOut();
                        } else {
                            $('#' + file.id).find('p.state').text('后台处理文件出错,请重试');
                            deferred.reject();
                        }
                    }
                })
                uploader.removeFile(file);
                return deferred.promise();
            }
        }
    });

    var uploader = WebUploader.create({

        duplicate: false,//去重
        prepareNextFile: true,//是否允许在文件传输时提前把下一个文件准备好
        disableGlobalDnd: true,
        fileNumLimit: 10,//选择文件最大数目
        auto: false,// 选完文件后，是否自动上传。
        swf: '../static/js/Uploader.swf',// swf文件路径
        server: '/microclouds/upload',// 文件接收服务端。
        pick: '#picker',// 选择文件的按钮。可选。
        chunked: true,//开启分片上传
        chunkSize: 10 * 1024 * 1024,//10M
        chunkRetry: 3,//错误重试次数
    });

//上传添加参数
    uploader.on('uploadBeforeSend', function (obj, data, headers) {
        data.md5File = md5File;
    });

// 当有文件被添加进队列的时候
    uploader.on('fileQueued', function (file) {
        // $("#picker").hide();//隐藏上传框
        var size = new Number(file.size / 1024).toFixed(0);
        var id = file.id;
        $("#thelist").append('<div id="' + file.id + '" class="item">' +
            '<h4 class="info" style="display: inline-block">' + file.name + ' &nbsp;  &nbsp;  &nbsp;  大小 :  ' + size + ' KB ' + '</h4>' +
            '<button id="removeFileBtn" class="btn btn-link" style="display: inline-block" onclick=\"removeFileBtn(' + id + ')\">' + '移除' + '</button>' +
            '<p class="state"></p>' +
            // '<p class="uploadProgressPercent" th:text="" ></p>' +
            '</div>');
    });
// 文件上传过程中创建进度条实时显示。
    uploader.on('uploadProgress', function (file, percentage) {
        var $li = $('#' + file.id),
            $percent = $li.find('.progress .progress-bar');

        // 避免重复创建
        if (!$percent.length) {
            $percent = $('<div class="progress progress-striped active">' +
                '<div class="progress-bar" role="progressbar" style="width: 0%"></div>' +
                '</div>').appendTo($li).find('.progress-bar');
        }
        $li.find('p.state').text('Uploading');

        // var percent = ${#numbers.formatDecimal(percentage * 100,2,1)}+'%';
        // $li.find('p.uploadProgressPercent').text(percent);
        $percent.css('width', percentage * 100 + '%');
    });

    //上传出错
    uploader.onError = function (code) {
        alert('上传出错! 请刷新页面之后重试 ');
    };

    // 所有文件上传成功后调用
    uploader.on('uploadFinished', function () {
        //清空队列
        uploader.reset();
    });

// ----- 扩展功能  -----
    // 移除
    // $("#removeFileBtn").click(function () {
    //     alert(" is  remove");
    //     // uploader.remove(true);
    // });

    // 开始上传
    $("#ctlBtn").click(function () {
        alert('开始上传');
        uploader.upload();//上传
    });
    //取消
    $("#cancelBtn").click(function (file) {
        alert('文件已取消上传');
        uploader.cancelFile(file);
    });

    // 暂停
    $("#uploaderStopBtn").click(function () {
        alert('stop');
        console.log($('#StopBtn').attr("status"));
        var status = $('#StopBtn').attr("status");
        if (status == "stop") {
            $("#StopBtn").html("继续上传");
            $("#StopBtn").attr("status", "continuous");
            uploader.stop(true);
            console.log(uploader.getFiles("interrupt"));
        } else {
            $("#StopBtn").html("暂停上传");
            $("#StopBtn").attr("status", "stop");
            console.log(uploader.getFiles("interrupt"));
            uploader.upload(uploader.getFiles("interrupt"));
        }
    });
});

function removeFileBtn(id) {
    // $(id).remove();
    id = id.getAttribute("id");
    console.log(id);
    $("#" + id).remove();
    alert('2')
    uploader.removeFile(id, true);
    alert(uploader.getFiles());
    // id.style.display="none";
}