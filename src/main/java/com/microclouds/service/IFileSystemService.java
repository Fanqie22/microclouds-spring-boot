package com.microclouds.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.microclouds.entity.FileSystem;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author https://github.com/Fanqie22
 * @since 2019-01-17
 */
public interface IFileSystemService extends IService<FileSystem> {
    /**
     * 查询该文件的md5是否已经存在于数据库,如果是,表明该文件已存在
     *
     * @param fileMd5
     * @return
     */
    Boolean checkFileExistByMd5(String fileMd5);

    /**
     * 查询文件列表,并分页
     *
     * @param page
     * @param state
     * @return
     */
    Page<FileSystem> selectFilesPage(Page<FileSystem> page, Integer state);

    /**
     * 删除文件,逻辑删除
     *
     * @param id
     * @return
     */
    Boolean deleteFile(Integer id);

    /**
     * 按类别查询文件列表,并分页
     *
     * @param page
     * @param state
     * @param fileType
     * @return
     */
    Page<FileSystem> selectFilesByTypePage(Page<FileSystem> page, Integer state, String fileType);
}
