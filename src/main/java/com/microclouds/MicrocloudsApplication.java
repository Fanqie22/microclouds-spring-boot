package com.microclouds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author : https://github.com/Fanqie22
 * @date : 2018年12月19日10:55:08
 * @SpringBootApplication 开启组件扫描和自动配置,
 * 相当于Spring原先的@Cnfiguration + @ComponentScan + Spring Boot的@EnableAutoConfiguration
 */
//指定扫描包路径
@SpringBootApplication
//@ComponentScan(basePackages = { "com" })
public class MicrocloudsApplication {

    public static void main(String[] args) {
        /**
         * 负责启动引导应用程序
         */
        SpringApplication.run(MicrocloudsApplication.class, args);
    }

}

