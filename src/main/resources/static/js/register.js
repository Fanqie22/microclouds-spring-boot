$(document).ready(function () {
    $('#RegisterForm').bootstrapValidator({
        message: 'This value is not valid',
        fields: {
            userName: {
                message: '姓名验证不通过',
                validators: {
                    notEmpty: {
                        message: '姓名不能为空'
                    },
                    stringLength: {
                        min: 1,
                        max: 18,
                        message: '姓名长度1-18位'
                    }
                }
            },
            userMail: {
                message: '帐号验证不通过',
                validators: {
                    notEmpty: {
                        message: '帐号不能为空'
                    },
                    regexp: {
                        regexp: /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/,
                        message: '这不是一个合法的邮箱地址'
                    },
                }
            },
            password: {
                message: '密码验证不通过',
                validators: {
                    notEmpty: {
                        message: '密码不能为空'
                    },
                    stringLength: {
                        min: 6,
                        max: 18,
                        message: '密码长度6-18位'
                    }
                }
            },
        }

    }).on('success.form.bv', function (e) {
        // Prevent form submission
        e.preventDefault();

        // Get the form instance
        var $form = $(e.target);

        // Get the BootstrapValidator instance
        var bv = $form.data('bootstrapValidator');

        // 获取路径
        var contextPath = getBaseUrl();

        // Use Ajax to submit form data
        $.post($form.attr('action'), $form.serialize(), function (result) {
            if (result.code == '00200') {
                // 登陆成功
                if (result.data) {
                    location.href = result.data;
                    return;
                }
                location.href = contextPath + '/microclouds/main';
            } else {
                // 登陆失败，显示错误信息
                $("#displayDiv").show();
                $('#dvErrorMsg').text(result.message).css("color", "red");
            }
        }, 'json');
    });
});