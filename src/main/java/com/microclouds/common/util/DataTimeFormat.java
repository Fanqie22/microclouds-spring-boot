package com.microclouds.common.util;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author : https://github.com/Fanqie22
 * @date : 2018年12月23日16:05:21
 * @description: 时间格式工具类
 */
public class DataTimeFormat {

    /**
     * 字符串转换为 java.util.Date
     * 可将下列格式的字符串转成Date :
     * 1.yyyy.MM.dd G 'at' hh:mm:ss z ,如'2002-1-1 AD at 22:10:59 PSD'
     * 2.yy/MM/dd HH:mm:ss 如 '2018/12/23 17:55:00'
     * 3.yy/MM/dd HH:mm:ss pm 如 '2018/12/23 17:55:00 pm'
     * 4.yy-MM-dd HH:mm:ss 如 '2018-12-23 17:55:00'
     * 5.yy-MM-dd HH:mm:ss am 如 '2018-12-23 17:55:00 am'
     *
     * @return : Date ,默认格式为 'yyyy-MM-dd hh:mm:ss'
     */
    public static Date stringToDate(String time) {
        SimpleDateFormat formatter;
        int tempPos = time.indexOf("AD");
        time = time.trim();
        formatter = new SimpleDateFormat("yyyy.MM.dd G 'at' hh:mm:ss z");

        if (tempPos > -1) {
            time = time.substring(0, tempPos) + "公元" + time.substring(tempPos + "AD".length()); // china
            formatter = new SimpleDateFormat("yyyy.MM.dd G 'at' hh:mm:ss z");
        }
        tempPos = time.indexOf("-");

        if (tempPos > -1 && (time.indexOf(" ") < 0)) {
            formatter = new SimpleDateFormat("yyyyMMddHHmmssZ");
        } else if ((time.indexOf("/") > -1) && (time.indexOf(" ") > -1)) {
            formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        } else if ((time.indexOf("-") > -1) && (time.indexOf(" ") > -1)) {
            formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        } else if ((time.indexOf("/") > -1) && (time.indexOf("am") > -1) || (time.indexOf("pm") > -1)) {
            formatter = new SimpleDateFormat("yyyy-MM-dd KK:mm:ss a");
        } else if ((time.indexOf("-") > -1) && (time.indexOf("am") > -1) || (time.indexOf("pm") > -1)) {
            formatter = new SimpleDateFormat("yyyy-MM-dd KK:mm:ss a");
        }

        ParsePosition pos = new ParsePosition(0);
        Date ctime = formatter.parse(time, pos);

        return ctime;
    }

    /**
     * 按指定格式转换
     *
     * @param time
     * @param format
     * @return
     */

    /**
     * @param :time,字符串时间
     * @param :format,转成的时间的格式,如'yyyy-MM-dd'
     * @return date
     */
    public static Date stringToDate(String time, String format) {
        SimpleDateFormat formatter;
        formatter = new SimpleDateFormat(format);
        ParsePosition pos = new ParsePosition(0);
        Date ctime = formatter.parse(time, pos);

        return ctime;
    }


    /**
     * 将java.util.Date 格式转换为指定的字符串格式
     *
     * @param time
     * @param patten ,这里指定格式 ,如'yyyy-MM-dd hh:mm:ss '
     * @return
     */
    public static String dateToString(Date time, String patten) {
        SimpleDateFormat formatter;
        formatter = new SimpleDateFormat(patten);
        String ctime = formatter.format(time);

        return ctime;
    }


    /**
     * 将java.util.Date 格式转换为,默认字符串格式'yyyy-MM-dd HH:mm:ss'(24小时制)
     *
     * @param time
     * @return
     */
    public static String dateToString(Date time) {
        return dateToString(time, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 取系统当前时间:返回默认值为如下形式'yyyy-MM-dd HH:mm:ss'
     *
     * @return String
     */
    public static String getNowTimeToString() {
        return dateToString(new Date(), "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 取系统当前时间:返回指定格式
     *
     * @param patten ,指定格式
     * @return
     */
    public static String getNowTimeToString(String patten) {
        return dateToString(new Date(), patten);
    }

    /**
     * 获取n天后的时间，n为负数则获取n天前的时间
     *
     * @param date
     * @param n
     * @return date
     */
    public static Date addDays(Date date, int n) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        c.add(Calendar.DAY_OF_MONTH, n);

        return c.getTime();
    }

    /**
     * 这里设置一个默认时间：1970/01/01 0:00:00
     *
     * @return date
     */
    public static Date getDefaultDate() {
        return stringToDate("1970/01/01 0:00:00");
    }
}

