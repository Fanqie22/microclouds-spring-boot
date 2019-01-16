package com.microclouds.dao.ext;

import com.microclouds.pojo.UserLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserLogExtMapper {

    /**
     * @description : 读取用户日志
     * @param userId
     * @return
     */
    UserLog selectUserLogByUserId(Integer userId);
}
