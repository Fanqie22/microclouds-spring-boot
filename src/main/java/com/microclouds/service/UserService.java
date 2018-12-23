package com.microclouds.service;

import com.microclouds.pojo.User;

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

    /**
     * @param id
     * @return
     * @description : 根据id查找角色名字
     */
//    String getUserRoleById(Integer id);
}
