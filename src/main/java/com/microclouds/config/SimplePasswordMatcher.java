package com.microclouds.config;

import com.microclouds.common.util.SecurityUtil;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

/**
 * @author :https://github.com/Fanqie22
 * @description : 加密之后的密码比较
 * @date : 2018年12月23日15:47:52
 */
public class SimplePasswordMatcher extends SimpleCredentialsMatcher {
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        Object encPwd = SecurityUtil.encryptByMD5(new String(upToken.getPassword()));
        Object orgPwd = info.getCredentials();
        return this.equals(encPwd, orgPwd);
    }
}
