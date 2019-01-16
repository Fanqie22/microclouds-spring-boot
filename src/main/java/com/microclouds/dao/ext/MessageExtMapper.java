package com.microclouds.dao.ext;

import com.microclouds.pojo.Message;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MessageExtMapper {

    /**
     * @param userId
     * @return
     * @description : 读取消息
     */
    Message selectMessageByUserId(Integer userId);
}
