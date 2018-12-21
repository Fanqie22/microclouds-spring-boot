package com.microclouds.service;

import com.microclouds.entity.User;

/**
 * @description : 用户的服务层接口
 * @author: https://github.com/Fanqie22
 * @date : 2018年12月21日11:28:38
 */
public interface UserService {

    /**
     * @param account
     * @return User
     * @description : 根据账号获取用户信息,用户登录认证
     */
    User getUserInfoByAccount(String account);
}
