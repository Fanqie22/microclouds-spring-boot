package com.microclouds.service;

import com.microclouds.pojo.CloudCapacity;

public interface CloudCapacityService {

    /**
     * @param cloudCapacity
     * @return
     * @description : 添加云盘容量记录
     */
    Boolean addCloudCapacity(CloudCapacity cloudCapacity);

    /**
     * @param cloudCapacity
     * @return
     * @description : 更新
     */
    Boolean updateCloudCapacity(CloudCapacity cloudCapacity);

    /**
     * @param userId
     * @return
     * @description : 读取容量
     */
    CloudCapacity selectCloudCapacity(Integer userId);
}
