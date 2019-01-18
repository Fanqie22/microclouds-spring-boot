package com.microclouds.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.microclouds.entity.FileSystem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
public interface FileSystemMapper extends BaseMapper<FileSystem> {

    int selectMd5(@Param("fileMd5") String fileMd5);

    List<FileSystem> selectFilesList(Pagination page, Integer state);

    int deleteFileById(Integer id);

    List<FileSystem> selectFilesByTypePage(Pagination page, Integer state, String fileType);
}