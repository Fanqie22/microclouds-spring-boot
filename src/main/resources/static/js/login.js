/**
 * @author : https://github.com/Fanqie22
 * @date : 2018年12月23日22:51:15
 * @description :用户登录
 */
$(function () {
    alert("ddddddddddd");
    // $('#loginForm').bootstrapValidator({
    //     message: '用户数据校验不通过 !',
    //     fields: {
    //         account: {
    //             message: '帐号验证不通过',
    //             validators: {
    //                 notEmpty: {
    //                     message: '帐号不能为空'
    //                 },
    //                 regexp: {
    //                     regexp: /^1[3|4|5|6|7|8|9][0-9]\d{8}$|^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(.[a-zA-Z0-9_-]+)+$/,
    //                     message: '帐号必须是手机或邮箱'
    //                 },
    //             }
    //         },
    //         password: {
    //             message: '密码验证不通过',
    //             validators: {
    //                 notEmpty: {
    //                     message: '密码不能为空'
    //                 },
    //                 stringLength: {
    //                     min: 6,
    //                     message: '密码长度至少6位'
    //                 }
    //             }
    //         },
    //     }
    // }).on('success.form.bv', function (e) {
    //     // 阻止表单提交
    //     e.preventDefault();
    //     // 获取form表单实例
    //     var $form = $(e.target);
    //     // 获取validator
    //     var bv = $form.data('bootstrapValidator');
    //
    //     // 异步提交数据
    //     $.post($form.attr('action'), $form.serialize(), function (result) {
    //         if (result.code == '00000') {
    //             // 登陆成功
    //             if (result.data) {
    //                 location.href = result.data;
    //
    //                 return;
    //             }
    //
    //             location.href = contextPath + '/workbench/index';
    //         } else {
    //             // 登陆失败，显示错误信息
    //             $('#dvErrorMsg').text(result.message).css("color", "red");
    //         }
    //     }, 'json');
    // });
});