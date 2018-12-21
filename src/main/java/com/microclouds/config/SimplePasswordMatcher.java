package com.microclouds.config;

import com.microclouds.common.uitl.SecurityUtil;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

public class SimplePasswordMatcher extends SimpleCredentialsMatcher {
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        Object encPwd = SecurityUtil.encryptByMD5(new String(upToken.getPassword()));
        Object orgPwd = info.getCredentials();
        return this.equals(encPwd, orgPwd);
    }
}
