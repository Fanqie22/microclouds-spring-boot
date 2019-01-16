package com.microclouds.service.impl;

import com.microclouds.dao.EmailMapper;
import com.microclouds.dao.MessageMapper;
import com.microclouds.dao.ext.EmailExtMapper;
import com.microclouds.dao.ext.MessageExtMapper;
import com.microclouds.pojo.Email;
import com.microclouds.pojo.Message;
import com.microclouds.service.MessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessagesServiceImpl implements MessagesService {

    @Autowired
    private EmailMapper emailMapper;
    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private EmailExtMapper emailExtMapper;
    @Autowired
    private MessageExtMapper messageExtMapper;

    @Override
    public Boolean sendEmail(Email email) {
        int count = emailMapper.insertSelective(email);
        return count > 0;
    }

    @Override
    public Boolean sendMessage(Message message) {
        int count = messageMapper.insertSelective(message);
        return count > 0;
    }

    @Override
    public Email readEmail(Integer userId) {
        return emailExtMapper.selectEmailByUserId(userId);
    }

    @Override
    public Message readMessage(Integer userId) {
        return messageExtMapper.selectMessageByUserId(userId);
    }
}
