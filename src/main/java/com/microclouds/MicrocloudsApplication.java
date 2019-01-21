package com.microclouds;

import com.microclouds.common.util.SystemPath;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.File;

/**
 * @author : https://github.com/Fanqie22
 * @date : 2018年12月19日10:55:08
 * @SpringBootApplication 开启组件扫描和自动配置,
 * 相当于Spring原先的@Cnfiguration + @ComponentScan + Spring Boot的@EnableAutoConfiguration
 */
@SpringBootApplication
@EnableScheduling
public class MicrocloudsApplication {

    public static void main(String[] args) {

        /**
         * 启动整个项目的时候创建本系统的根目录
         */
        File rootPath = new File(SystemPath.getSystemPath());
        if (!rootPath.exists()) {
            rootPath.mkdirs();
        }
        /**
         * 负责启动引导应用程序
         */
        SpringApplication.run(MicrocloudsApplication.class, args);
    }

}

