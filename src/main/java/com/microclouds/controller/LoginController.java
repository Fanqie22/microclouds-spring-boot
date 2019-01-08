package com.microclouds.controller;

import com.alibaba.druid.stat.DruidStatManagerFacade;
import com.microclouds.common.util.PropertyUtil;
import com.microclouds.common.util.ResponseValue;
import com.microclouds.common.util.SecurityUtil;
import com.microclouds.entity.RestPasswordDto;
import com.microclouds.entity.UserVo;
import com.microclouds.pojo.User;
import com.microclouds.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
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
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private Environment environment;

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
    @RequestMapping(value = "/registers", method = RequestMethod.POST)
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
        user.setRoleName("user");
        user.setUserName(vo.getUserName());
        user.setCreateTime(new Date());
        user.setDelFlag(false);

        // 使用MD5加密密码
        user.setPassword(SecurityUtil.encryptByMD5(vo.getPassword()));

        boolean registerBool = userService.userRegister(user);

        if (registerBool) {
            responseValue.setCode(PropertyUtil.successCode);
            responseValue.setMessage("注册成功 ! ");
            return responseValue;
        }

        responseValue.setCode(PropertyUtil.failureCode);
        responseValue.setMessage("注册失败,请重试 ! ");
        return responseValue;
    }

    /**
     * 忘记密码请求, get
     */
    @RequestMapping(value = "/forgetpassword", method = RequestMethod.GET)
    public String forgetPasswordPage() {
        return "forgetPassword";
    }


    /**
     * 重置密码 ,提供需要重置的邮箱账号 ,post
     */
    @RequestMapping(value = "/restpassword", method = RequestMethod.POST)
    public String passwordRest(Model model, HttpServletRequest request) {
        // 检查邮箱安全,是否具备修改密码条件
        String userMail = request.getParameter("userMail");
        if (userMail == null || userMail.length() < 2) {
            return "paramError";//TODO
        }

        model.addAttribute("userMail", request.getParameter("userMail"));

        return "restPassword";
    }

    /**
     *
     */
    @RequestMapping(value = "/getmailcode", method = RequestMethod.POST)
    @ResponseBody
    public String getMailCode(String userMail) {
        if (userMail.length() < 2) {
            return null;
        }
        int codeNum = (int) ((Math.random() * 9 + 1) * 100000);
        //发送邮件
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(environment.getProperty("spring.mail.username"));
        mailMessage.setTo(userMail);
        mailMessage.setSubject("microcloudsecurity");
        mailMessage.setText("您正在进行重置密码操作,您的验证码是 : " + codeNum);
        mailSender.send(mailMessage);

        return codeNum + "";
    }

    /**
     * 重置密码请求, post
     */
    @RequestMapping(value = "/passwordrest", method = RequestMethod.POST)
    @ResponseBody
    public ResponseValue restPassword(RestPasswordDto passwordDto) {
        ResponseValue responseValue = new ResponseValue();

        String mailCode = passwordDto.getMailCode();
        String userMailCode = passwordDto.getGetMailCode();

        if (!mailCode.equals(userMailCode)) {
            responseValue.setCode(PropertyUtil.paramErrorCode);
            responseValue.setMessage("验证码错误");
            return responseValue;
        }

        //修改密码进数据库
        // 使用MD5加密密码
        String passwordMD5 = SecurityUtil.encryptByMD5(passwordDto.getPassword());
        boolean updateBool = userService.updatePasswordByMail(passwordDto.getUserMail(), passwordMD5);

        if (updateBool) {
            responseValue.setCode(PropertyUtil.successCode);
            responseValue.setMessage("修改密码成功 ! ");
            return responseValue;
        }

        responseValue.setCode(PropertyUtil.failureCode);
        responseValue.setMessage("系统错误,请重试 !");
        return responseValue;
    }


    /**
     * 邮箱校验
     *
     * @param userMail
     * @return
     */
    @RequestMapping(value = "/validateusermail")
    @ResponseBody
    public String validateEmail(String userMail) {
        boolean isExist = userService.isEmailExist(userMail);
        return "{\"valid\":" + !isExist + "}";
    }

    /**
     * 邮箱校验
     *
     * @param userMail
     * @return
     */
    @RequestMapping(value = "/validaterestmail")
    @ResponseBody
    public String validateRestMail(String userMail) {
        boolean isExist = userService.isEmailExist(userMail);
        return "{\"valid\":" + isExist + "}";
    }

}
