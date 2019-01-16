package com.microclouds.dao.ext;

import com.microclouds.pojo.FileSystemLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileSystemLogExtMapper {

    /**
     * @param userId
     * @return
     * @description : 读取文件日志
     */
    FileSystemLog selectFileSysLogByUserId(Integer userId);
}
