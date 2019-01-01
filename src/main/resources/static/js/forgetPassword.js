$(document).ready(function () {
    // 获取路径
    var contextPath = getBaseUrl();
    $('#forgot_password_form').bootstrapValidator({
        message: 'This value is not valid',
        fields: {
            userMail: {
                message: '邮箱验证不通过',
                validators: {
                    notEmpty: {
                        message: '邮箱不能为空'
                    },
                    regexp: {
                        regexp: /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/,
                        message: '这不是一个合法的邮箱地址 '
                    },
                    remote: {
                        url: contextPath + '/microclouds/validaterestmail',
                        message: ' 此邮箱尚未注册'
                    }
                }
            }

        }

    })
});