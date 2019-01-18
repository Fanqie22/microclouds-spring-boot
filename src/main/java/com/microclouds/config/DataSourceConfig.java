package com.microclouds.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @auth: https://github.com/Fanqie22
 * @date: 2018年12月26日09:07:41
 * @description :配置启用Druid连接池
 */
@Configuration
public class DataSourceConfig {

//    @Autowired
//    private Environment env;

    @Bean
    public DataSource getDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setUrl(env.getProperty("spring.datasource.url"));
//        dataSource.setUsername(env.getProperty("spring.datasource.username"));
//        dataSource.setPassword(env.getProperty("spring.datasource.password"));
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/microclouds?useUnicode=true&characterEncoding=UTF-8&useSSL=false&autoReconnect=true&failOverReadOnly=false&serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("microcloudsdatabase");
        return dataSource;
    }


}
