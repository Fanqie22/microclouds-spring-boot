package com.microclouds;

import com.microclouds.pojo.User;
import com.microclouds.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class loginTest {

    @Autowired
    private UserService userService;

    @Test
    public void run() {
        System.out.println("------start------ !");
        User userInfo = userService.getUserInfoByAccount("1393203396@qq.com");
        System.out.println("----- " + userInfo.getUserMail());
    }
}
