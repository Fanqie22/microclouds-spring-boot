package com.microclouds.config;

import com.microclouds.pojo.User;
import com.microclouds.service.UserService;
import com.microclouds.service.impl.UserServiceImpl;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;


/**
 * @description : Shiro 领域授权/认证配置类
 * @author: https://github.com/Fanqie22
 * @date : 2018年12月21日11:28:38
 */
public class AuthRealm extends AuthorizingRealm {

    /**
     * @param principalCollection
     * @return User(实体类)
     * @description : Shiro 授权配置
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 获取用户权限角色模块
        User userInfo = (User) principalCollection.fromRealm(this.getName()).iterator().next();
        // 权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //这里的权限类型比较简单,这里不启用权限,因为这不是后台管理,没必要,配置拦截器的时候放松就行 ,
        simpleAuthorizationInfo.addStringPermission("");
        // 角色
        simpleAuthorizationInfo.addRole(userInfo.getRoleName());
        return simpleAuthorizationInfo;
    }

    /**
     * @param authenticationToken
     * @return User(认证成功 - 返回认证类SimpleAuthenticationInfo, 认证失败 - 返回null)
     * @throws AuthenticationException
     * @descrip :Shiro 认证配置
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 获取token ,并转化成实体类参数所需要的格式 ,这里获取到的是用户的登录凭证,统称为userName ,可以是邮箱/手机号/账号等
        UsernamePasswordToken upToken = (UsernamePasswordToken) authenticationToken;
        // 从数据库里查询到用户数据
//        UserService userService = new UserServiceImpl();
//        User userInfo = userService.getUserInfoByAccount(upToken.getUsername());
//        if (userInfo != null) {
//            AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userInfo, userInfo.getPassword(), this.getName());
//            return authenticationInfo;
//        }
        return null;
    }
}
