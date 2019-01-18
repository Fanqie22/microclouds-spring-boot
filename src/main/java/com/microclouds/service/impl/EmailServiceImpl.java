package com.microclouds.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.microclouds.dao.EmailMapper;
import com.microclouds.entity.Email;
import com.microclouds.service.IEmailService;
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
public class EmailServiceImpl extends ServiceImpl<EmailMapper, Email> implements IEmailService {
	
}
