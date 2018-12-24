//package com.microclouds.common.task;
//
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//@Component
//@EnableScheduling
//public class SpringTask {
//
//    /**
//     * @cron:表达式来配置任务执行时间
//     * @description: 员工表的定时更新任务服务, 每天00:00更新0 00 01 * * ?
//     */
//    @Scheduled(cron = "0/3 * * * * *")
//    public void empScheduled() {
//        System.out.println("empScheduled ! " + Thread.currentThread().getName());
//    }
//
//
//    /**
//     * @cron:表达式来配置任务执行时间
//     * @description: 其他表的定时更新任务服务, 每天01:00更新
//     */
//    @Scheduled(cron = "0/5 * * * * *")
//    public void scheduled() {
//        System.out.println("Scheduled !  " + Thread.currentThread().getName());
//    }
//}
