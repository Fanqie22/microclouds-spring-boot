package com.microclouds.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.microclouds.entity.Email;
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
public interface EmailMapper extends BaseMapper<Email> {

    List<Email> selectEmailList(Pagination page, Integer state);

    int deleteEmailById(Integer id);
}