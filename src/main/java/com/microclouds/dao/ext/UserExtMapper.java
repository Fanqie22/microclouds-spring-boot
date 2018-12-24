package com.microclouds.dao.ext;

import com.microclouds.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @description : 用户的dao层接口, 自定义
 * @author: https://github.com/Fanqie22
 * @date : 2018年12月23日20:39:19
 */
@Mapper
public interface UserExtMapper {

    /**
     * 根据账户查找用户信息 ,用于登录验证
     *
     * @param account
     * @return
     */
    User selectByAccount(@Param("user_mail") String account);
}
