package com.microclouds.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.microclouds.dao.AuthorityMapper;
import com.microclouds.entity.Authority;
import com.microclouds.service.IAuthorityService;
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
public class AuthorityServiceImpl extends ServiceImpl<AuthorityMapper, Authority> implements IAuthorityService {
	
}
