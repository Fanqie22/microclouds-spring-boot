$(document).ready(function () {
    $('#rest_password_form').bootstrapValidator({
        message: 'This value is not valid',
        fields: {
            mailCode: {
                message: '验证码不通过',
                validators: {
                    notEmpty: {
                        message: '验证码不能为空'
                    },
                }
            },
            password: {
                message: '密码验证不通过',
                validators: {
                    notEmpty: {
                        message: '密码不能为空'
                    },
                    identical: {
                        field: 'repassword',
                        message: '前后密码不一致'
                    },
                    stringLength: {
                        min: 6,
                        max: 18,
                        message: '密码长度6-18位'
                    }
                }
            },
            repassword: {
                message: '密码校验不通过',
                validators: {
                    notEmpty: {
                        message: '确定密码不能为空'
                    },
                    identical: {
                        field: 'password',
                        message: '前后密码不一致'
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
                // 成功
                alert(result.message);
                location.href = contextPath + '/microclouds/login';
            } else {
                // 登陆失败，显示错误信息
                $("#displayDiv").show();
                $('#dvErrorMsg').text(result.message).css("color", "red");
            }
        }, 'json');
    });
});
