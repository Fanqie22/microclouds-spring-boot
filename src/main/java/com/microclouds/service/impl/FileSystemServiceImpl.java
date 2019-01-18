package com.microclouds.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.microclouds.dao.FileSystemMapper;
import com.microclouds.entity.FileSystem;
import com.microclouds.service.IFileSystemService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author https://github.com/Fanqie22
 * @since 2019-01-17
 */
@Service
public class FileSystemServiceImpl extends ServiceImpl<FileSystemMapper, FileSystem> implements IFileSystemService {

    @Override
    public Boolean checkFileExistByMd5(String fileMd5) {
        int count = this.baseMapper.selectMd5(fileMd5);
        return count > 0;
    }

    @Override
    public Page<FileSystem> selectFilesPage(Page<FileSystem> page, Integer state) {
        // 不进行 count sql 优化，解决 MP 无法自动优化 SQL 问题
        // page.setOptimizeCountSql(false);
        // 不查询总记录数
        // page.setSearchCount(false);
        // 注意！！ 分页 total 是经过插件自动 回写 到传入 page 对象
        return page.setRecords(this.baseMapper.selectFilesList(page, state));
    }

    @Override
    public Boolean deleteFile(Integer id) {
        int count = this.baseMapper.deleteFileById(id);
        return count > 0;
    }

    @Override
    public Page<FileSystem> selectFilesByTypePage(Page<FileSystem> page, Integer state, String fileType) {
        // 不进行 count sql 优化，解决 MP 无法自动优化 SQL 问题
        // page.setOptimizeCountSql(false);
        // 不查询总记录数
        // page.setSearchCount(false);
        // 注意！！ 分页 total 是经过插件自动 回写 到传入 page 对象
        return page.setRecords(this.baseMapper.selectFilesByTypePage(page, state, fileType));
    }
}
