package com.microclouds.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.microclouds.entity.FileSystemLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * Mapper接口
 * </p>
 *
 * @author https://github.com/Fanqie22
 * @since 2019-01-17
 */
@Mapper
public interface FileSystemLogMapper extends BaseMapper<FileSystemLog> {

    int deleteFileLogById(Integer id);

    List<FileSystemLog> selectFileLogsList(Pagination page, Integer state);

}