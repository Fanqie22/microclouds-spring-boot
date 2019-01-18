package com.microclouds.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.microclouds.entity.Message;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * Mapper接口
 * </p>
 *
 * @author https://github.com/Fanqie22
 * @since 2019-01-17
 */
@Mapper
public interface MessageMapper extends BaseMapper<Message> {

}