package com.microclouds.common.task;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executors;

@Configuration
public class SpringTaskConfig implements SchedulingConfigurer {

    /**
     * 线程池线程数
     */
    private Integer corePoolSize = 1;

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(Executors.newScheduledThreadPool(corePoolSize));
    }
}