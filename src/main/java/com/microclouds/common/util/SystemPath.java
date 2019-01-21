package com.microclouds.common.util;

import java.io.File;

/**
 * @author : https://github.com/Fanqie22
 * @date : 2019年1月12日16:20:32
 * @description : 获取当前系统的根目录经 ,分为linux 和windows
 */
public class SystemPath {

    public static String getSystemPath() {

        // linux下 ,否则windows
        if ("/".equals(File.separator)) {
            //TODO
            return null;
        } else {
            return "F:" + File.separator + "MicroCloudsFiles" + File.separator;//TODO
        }

    }
}
