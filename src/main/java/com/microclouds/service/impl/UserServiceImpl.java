package com.microclouds.service.impl;

import com.microclouds.dao.UserMapper;
import com.microclouds.dao.ext.UserExtMapper;
import com.microclouds.pojo.User;
import com.microclouds.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description : 用户的服务层
 * @author: https://github.com/Fanqie22
 * @date : 2018年12月21日11:28:38
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserExtMapper userExtMapper;

    @Override
    public User getUserInfoByAccount(String account) {
        return userExtMapper.selectByAccount(account);
    }

    @Override
    public boolean userRegister(User user) {
        int count = userMapper.insertSelective(user);
        return count > 0;
    }
}
