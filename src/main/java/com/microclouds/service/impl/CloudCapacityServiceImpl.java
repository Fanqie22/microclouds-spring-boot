package com.microclouds.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.microclouds.dao.CloudCapacityMapper;
import com.microclouds.entity.CloudCapacity;
import com.microclouds.service.ICloudCapacityService;
import org.springframework.stereotype.Service;

@Service
public class CloudCapacityServiceImpl extends ServiceImpl<CloudCapacityMapper, CloudCapacity> implements ICloudCapacityService {

}
