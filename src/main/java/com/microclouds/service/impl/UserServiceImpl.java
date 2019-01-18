package com.microclouds.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.microclouds.dao.UserMapper;
import com.microclouds.entity.User;
import com.microclouds.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * @description : 用户的服务层
 * @author: https://github.com/Fanqie22
 * @date : 2018年12月21日11:28:38
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public User getUserInfoByAccount(String account) {
        return this.baseMapper.selectByAccount(account);
    }

    @Override
    public boolean userRegister(User user) {
        int count = this.baseMapper.insert(user);
        return count > 0;
    }

    @Override
    public boolean updatePasswordByMail(String userMail, String password) {
        int count = this.baseMapper.updatePasswordByMail(userMail, password);
        return count > 0;
    }

    @Override
    public boolean isEmailExist(String userMail) {
        String count = this.baseMapper.isEmailExist(userMail);
        return count != null && count.length() > 2;
    }
}
