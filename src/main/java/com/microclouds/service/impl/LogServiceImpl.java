package com.microclouds.service.impl;

import com.microclouds.dao.FileSystemLogMapper;
import com.microclouds.dao.UserLogMapper;
import com.microclouds.dao.ext.FileSystemLogExtMapper;
import com.microclouds.dao.ext.UserLogExtMapper;
import com.microclouds.pojo.FileSystemLog;
import com.microclouds.pojo.UserLog;
import com.microclouds.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description : 日志的服务层
 * @author: https://github.com/Fanqie22
 * @date : 2019年1月16日
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private UserLogMapper userLogMapper;
    @Autowired
    private FileSystemLogMapper fileSystemLogMapper;
    @Autowired
    private UserLogExtMapper userLogExtMapper;
    @Autowired
    private FileSystemLogExtMapper fileSystemLogExtMapper;


    @Override
    public Boolean userLog(UserLog userLog) {
        int count = userLogMapper.insertSelective(userLog);
        return count > 0;
    }

    @Override
    public Boolean fileSystemLog(FileSystemLog fileSystemLog) {
        int count = fileSystemLogMapper.insertSelective(fileSystemLog);
        return count > 0;
    }

    @Override
    public UserLog readUserLog(Integer userId) {
        return userLogExtMapper.selectUserLogByUserId(userId);
    }

    @Override
    public FileSystemLog readFileSystemLog(Integer userId) {
        return fileSystemLogExtMapper.selectFileSysLogByUserId(userId);
    }
}
