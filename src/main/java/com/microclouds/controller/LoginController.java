package com.microclouds.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;

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
}
