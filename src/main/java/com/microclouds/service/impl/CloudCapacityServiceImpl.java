package com.microclouds.service.impl;

import com.microclouds.dao.CloudCapacityMapper;
import com.microclouds.pojo.CloudCapacity;
import com.microclouds.pojo.CloudCapacityExample;
import com.microclouds.service.CloudCapacityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CloudCapacityServiceImpl implements CloudCapacityService {

    @Autowired
    private CloudCapacityMapper cloudCapacityMapper;

    @Override
    public Boolean addCloudCapacity(CloudCapacity cloudCapacity) {
        return null;
    }

    @Override
    public Boolean updateCloudCapacity(CloudCapacity cloudCapacity) {
        return null;
    }

    @Override
    public CloudCapacity selectCloudCapacity(Integer userId) {
        CloudCapacityExample example=new CloudCapacityExample();
        example.createCriteria().andUserIdEqualTo(userId);
        return null;
    }
}
