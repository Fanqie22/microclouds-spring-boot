function timer(time) {
    var btn = $("#codeButton");
    btn.attr("disabled", true);  //按钮禁止点击
    btn.val(time <= 0 ? "发送动态密码" : (" 重新发送验证码 ( " + (time) + "  s)"));
    var hander = setInterval(function () {
        if (time <= 0) {
            clearInterval(hander); //清除倒计时
            btn.val("重新发送验证码");
            btn.attr("disabled", false);
            return false;
        } else {
            btn.val("重新发送验证码  ( " + (time--) + "  s)");
        }
    }, 1000);
}

$(function () {
    $('#codeButton').on('click', function () {
        $("#codeDiv").show();
        $("#submitDiv").show();
        $("#sendCodeBtnDiv").hide();
        timer(10);
        var userMail = $("#userMail").val();
        $.ajax({
            type: 'POST',
            url: "/microclouds/getmailcode",
            data: {"userMail": userMail},
            dataType: 'text',
            success: function (data) {
                if (data == null) {
                    alert("服务器错误,请重新提供邮箱号 !")
                }
                $('#getMailCode').val(data)
            }
        })

    })
})