package com.microclouds.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.microclouds.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * Mapper接口
 * </p>
 *
 * @author https://github.com/Fanqie22
 * @since 2019-01-17
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据账户查找用户信息 ,用于登录验证
     *
     * @param user_mail
     * @return
     */
    User selectByAccount(@Param("user_mail") String user_mail);

    /**
     * 修改密码
     *
     * @param userMail
     * @param password
     * @return
     */
    Integer updatePasswordByMail(@Param("userMail") String userMail, @Param("password") String password);

    /**
     * 邮件校验
     *
     * @param userMail
     * @return
     */
    String isEmailExist(@Param("userMail") String userMail);
}