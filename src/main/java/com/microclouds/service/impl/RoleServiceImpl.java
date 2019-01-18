package com.microclouds.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.microclouds.dao.RoleMapper;
import com.microclouds.entity.Role;
import com.microclouds.service.IRoleService;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {
	
}
