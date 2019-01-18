package com.microclouds.service;

import com.baomidou.mybatisplus.service.IService;
import com.microclouds.entity.User;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author https://github.com/Fanqie22
 * @since 2019-01-17
 */
public interface IUserService extends IService<User> {
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

    /**
     * @param user
     * @return
     * @description:用户注册
     */
    boolean userRegister(User user);

    /**
     * 修改密码
     *
     * @param userMail
     * @return
     */
    boolean updatePasswordByMail(String userMail, String password);

    /**
     * 邮箱校验
     * @param userMail
     * @return
     */
    boolean isEmailExist(String userMail);
}
