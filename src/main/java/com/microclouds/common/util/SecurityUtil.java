package com.microclouds.common.util;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @author: https://github.com/Fanqie22
 * @date : 2018年12月21日15:19:39
 * @description : 自定义安全工具类
 */
public class SecurityUtil {

    private static String salt = "microcloudsPasswordByMD5";
    /**
     * MD5加密
     * @param content
     * @return
     */
    public static String encryptByMD5(String content) {
        String encryptString = encryptByMD5(content, salt);
        return encryptString;
    }

    /**
     * MD5Hash加密
     *
     * @param content
     * @param salt
     * @return
     */
    public static String encryptByMD5(String content, String salt) {
        return (new Md5Hash(content, salt, 5)).toString();
    }

}
