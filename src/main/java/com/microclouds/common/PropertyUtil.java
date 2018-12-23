package com.microclouds.common;


import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.logging.Logger;

public class PropertyUtil {

    private static Properties props;

    static {
        loadProps();
    }

    synchronized static private void loadProps() {
        props = new Properties();
        InputStreamReader in = null;

        try {
            in = new InputStreamReader(
                    PropertyUtil.class.getClassLoader().getResourceAsStream("resource.properties"), "UTF-8");
            props.load(in);
        } catch (FileNotFoundException e) {
            System.out.println("properties文件未找到");
        } catch (IOException e) {
            System.out.println("出现IOException");
        } finally {
            try {
                if (null != in) {
                    in.close();
                }
            } catch (IOException e) {
                System.out.println("properties文件流关闭出现异常");
            }
        }

        System.out.println("加载properties文件内容完成");
    }

    public static String getProperty(String key) {
        if (null == props) {
            loadProps();
        }

        return props.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        if (null == props) {
            loadProps();
        }

        return props.getProperty(key, defaultValue);
    }

    // 成功
    public static final String successCode = getProperty("response.code.success");
    // 参数错误
    public static final String paramErrorCode = getProperty("response.code.paramError");
    // 其他错误
    public static final String otherError = getProperty("response.code.otherError");
    // 失败
    public static final String failureCode = getProperty("response.code.failure");
    // 正常
    public static final String normalCode = getProperty("response.code.normal");
    // 无权限
    public static final String unAuthCode = getProperty("response.code.unAuth");
    // 登录超时
    public static final String timeOut = getProperty("response.code.timeOut");
}
