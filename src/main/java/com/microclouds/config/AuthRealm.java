package com.microclouds.config;

import com.microclouds.entity.User;
import com.microclouds.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description : Shiro 领域授权/认证配置类
 * @author: https://github.com/Fanqie22
 * @date : 2018年12月21日11:28:38
 */
public class AuthRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * @param principalCollection
     * @return User(实体类)
     * @description : Shiro 授权配置
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 获取用户权限角色模块 - 未完成
        User userInfo = (User) principalCollection.fromRealm(this.getName()).iterator().next();
        // 权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //这里的权限还没完善,应该传进一个List<String> ,权限类型还没录好
        simpleAuthorizationInfo.addStringPermission("admin");//TODO
        // 角色
        simpleAuthorizationInfo.addRole(userInfo.getUserType().toString());
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
        User userInfo = userService.getUserInfoByAccount(upToken.getUsername());
        if (userInfo != null) {
            AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userInfo, userInfo.getPassword(), this.getName());
            return authenticationInfo;
        }
        return null;
    }
}
