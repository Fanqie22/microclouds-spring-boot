package com.microclouds.dao.ext;

import com.microclouds.pojo.Email;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmailExtMapper {

    /**
     * @description : 读取邮件
     * @param userId
     * @return
     */
    Email selectEmailByUserId(Integer userId);
}
