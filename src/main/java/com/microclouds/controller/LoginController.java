package com.microclouds.controller;

import com.alibaba.druid.stat.DruidStatManagerFacade;
import com.microclouds.common.util.PropertyUtil;
import com.microclouds.common.util.ResponseValue;
import com.microclouds.entity.UserVo;
import com.microclouds.pojo.User;
import com.microclouds.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : https://github.com/Fanqie22
 * @date : 2018年12月19日14:32:10
 * @description: User控制器
 */
@Controller
@EnableAutoConfiguration
@RequestMapping(value = "/microclouds")
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/durid/stat")
    public Object druidStat() {
        /**
         * DruidStatManagerFacade#getDataSourceStatDataList 该方法可以获取所有数据源的监控数据
         * 除此之外 DruidStatManagerFacade 还提供了一些其他方法，你可以按需选择使用。
         */
        return DruidStatManagerFacade.getInstance().getDataSourceStatDataList();
    }

    /**
     * 登录页面请求, GET
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseValue login(@Validated UserVo userVo, BindingResult bindingResult) {
        ResponseValue responseValue = new ResponseValue();


        //使用Shiro框架验证用户是否登录
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken
                = new UsernamePasswordToken(userVo.getUserMail(), userVo.getPassword());
        try {
            // login方法将会验证用户的信息,如果验证不通过,抛出异常
            subject.login(usernamePasswordToken);
        } catch (AuthenticationException e) {
            responseValue.setCode(PropertyUtil.failureCode);
            responseValue.setMessage("用户名或密码错误 ! ");
            return responseValue;
        }

        responseValue.setCode(PropertyUtil.successCode);
        responseValue.setMessage("登陆成功 ! ");

        return responseValue;
    }

    /**
     * 注册请求, GET
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage() {
        return "register";
    }

    /**
     * 注册操作,POST
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public ResponseValue register(@Validated UserVo vo, BindingResult binding) {
        ResponseValue responseValue = new ResponseValue();

        // 后端数据校验结果,启用框架校验
        if (binding.hasErrors()) {
            List<ObjectError> allErrors = binding.getAllErrors();
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

        User user = new User();
        user.setUserMail(vo.getUserMail());
        user.setPassword(vo.getPassword());
        user.setRoleName("user");//TODO ,修改数据库字段

        boolean registerBool = userService.userRegister(user);

        if (registerBool) {
            responseValue.setCode(PropertyUtil.successCode);
            responseValue.setMessage("注册成功 ! ");
            return responseValue;
        }

        responseValue.setCode(PropertyUtil.failureCode);
        responseValue.setMessage("注册失败 ! ");
        return responseValue;
    }

    /**
     * 首页请求, GET
     */
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String mainPage() {
        return "main";
    }


    private Boolean Validated(BindingResult binding){
        return false;
    }
}
