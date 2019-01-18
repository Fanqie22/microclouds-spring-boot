package com.microclouds.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.microclouds.dao.CityMapper;
import com.microclouds.entity.City;
import com.microclouds.service.ICityService;
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
public class CityServiceImpl extends ServiceImpl<CityMapper, City> implements ICityService {
	
}
