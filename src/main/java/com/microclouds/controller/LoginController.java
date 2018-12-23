package com.microclouds.controller;

import com.microclouds.common.PropertyUtil;
import com.microclouds.common.util.ResponseValue;
import com.microclouds.entity.UserVo;
import com.microclouds.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : https://github.com/Fanqie22
 * @date : 2018年12月19日14:32:10
 * @description: User用控制器
 */
@Controller
@EnableAutoConfiguration
@RequestMapping(value = "/microclouds")
public class LoginController {

    /**
     * 登录页面请求, GET
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model, HttpServletResponse response) {
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ResponseValue login(@Validated UserVo userVo, BindingResult bindingResult) {
        ResponseValue responseValue = new ResponseValue();

        // 后端数据校验结果,启用框架校验
        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            List<String> list = new ArrayList<String>();
            for (ObjectError objectError : allErrors) {
                try {
                    list.add(new String(objectError.getDefaultMessage().getBytes("ISO-8859-1"), "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            responseValue.setCode(PropertyUtil.paramErrorCode);
            responseValue.setMessage("参数错误");
            responseValue.setData(list);
            return responseValue;
        }

        //使用Shiro框架验证用户
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken
                = new UsernamePasswordToken(userVo.getUserMail(), userVo.getPassword());
        try {
            subject.login(usernamePasswordToken);
        } catch (AuthenticationException e) {
            responseValue.setCode(PropertyUtil.failureCode);
            responseValue.setMessage("用户名或密码错误 ! ");
        }

        responseValue.setCode(PropertyUtil.successCode);
        responseValue.setMessage("登陆成功 ! ");
        responseValue.setData(userVo);

        return responseValue;
    }
}
