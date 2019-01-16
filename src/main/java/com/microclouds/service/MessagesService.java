package com.microclouds.service;

import com.microclouds.pojo.Email;
import com.microclouds.pojo.Message;

/**
 * @description :消息服务模块
 * @author: https://github.com/Fanqie22
 * @date : 2019年1月16日
 */
public interface MessagesService {

    /**
     * @param email
     * @return
     * @description : 发送邮件读物
     */
    Boolean sendEmail(Email email);

    /**
     * @param message
     * @return
     * @description : 发送短消息服务
     */
    Boolean sendMessage(Message message);

    /**
     * @param userId
     * @return Email
     * @description : 读取邮件读物
     */
    Email readEmail(Integer userId);

    /**
     * @param userId
     * @return Message
     * @description : 读取短消息服务
     */
    Message readMessage(Integer userId);
}
