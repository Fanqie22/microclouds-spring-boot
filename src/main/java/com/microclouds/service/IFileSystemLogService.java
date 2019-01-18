package com.microclouds.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.microclouds.entity.FileSystemLog;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author https://github.com/Fanqie22
 * @since 2019-01-17
 */
public interface IFileSystemLogService extends IService<FileSystemLog> {

    /**
     * 查询文件列表,并分页
     *
     * @param page
     * @param state
     * @return
     */
    Page<FileSystemLog> selectFileLogsPage(Page<FileSystemLog> page, Integer state);

    /**
     * 删除文件记录,逻辑删除
     *
     * @param id
     * @return
     */
    Boolean deleteFileLog(Integer id);
}
