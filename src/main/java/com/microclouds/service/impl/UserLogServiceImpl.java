package com.microclouds.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.microclouds.dao.UserLogMapper;
import com.microclouds.entity.UserLog;
import com.microclouds.service.IUserLogService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *   服务实现类
 * </p>
 *
 * @author https://github.com/Fanqie22
 * @since 2019-01-17
 */
@Service
public class UserLogServiceImpl extends ServiceImpl<UserLogMapper, UserLog> implements IUserLogService {
	
}
