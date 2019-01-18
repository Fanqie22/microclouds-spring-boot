//package com.microclouds.service;
//
//
//import com.microclouds.entity.FileSystemLog;
//import com.microclouds.entity.UserLog;
//
///**
// * @description : 用户的日志系统接口 ,可以利用spring的AOP
// * @author: https://github.com/Fanqie22
// * @date : 2019年1月16日
// */
//public interface LogService {
//
//    /**
//     * @param userLog
//     * @return
//     * @description : 用户日志
//     */
//    Boolean userLog(UserLog userLog);
//
//    /**
//     * @param fileSystemLog
//     * @return
//     * @description : 文件日志
//     */
//    Boolean fileSystemLog(FileSystemLog fileSystemLog);
//
//    /**
//     * @param userId
//     * @return
//     * @description : 用户日志
//     */
//    UserLog readUserLog(Integer userId);
//
//    /**
//     * @param userId
//     * @return
//     * @description : 文件日志
//     */
//    FileSystemLog readFileSystemLog(Integer userId);
//}
