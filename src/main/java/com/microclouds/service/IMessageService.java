package com.microclouds.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.microclouds.entity.Message;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author https://github.com/Fanqie22
 * @since 2019-01-17
 */
public interface IMessageService extends IService<Message> {
    /**
     * 查询邮件列表,并分页
     *
     * @param page
     * @param state
     * @return
     */
    Page<Message> selectMessagePage(Page<Message> page, Integer state);

    /**
     * 删除邮件,逻辑删除
     *
     * @param id
     * @return
     */
    Boolean deleteMessage(Integer id);
}
