package com.microclouds.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.microclouds.entity.Email;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author https://github.com/Fanqie22
 * @since 2019-01-17
 */
public interface IEmailService extends IService<Email> {
    /**
     * 查询邮件列表,并分页
     *
     * @param page
     * @param state
     * @return
     */
    Page<Email> selectEmailPage(Page<Email> page, Integer state);

    /**
     * 删除邮件,逻辑删除
     *
     * @param id
     * @return
     */
    Boolean deleteEmail(Integer id);
}
