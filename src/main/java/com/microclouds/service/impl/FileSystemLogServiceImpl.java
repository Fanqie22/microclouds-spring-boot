package com.microclouds.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.microclouds.dao.FileSystemLogMapper;
import com.microclouds.entity.FileSystemLog;
import com.microclouds.service.IFileSystemLogService;
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
public class FileSystemLogServiceImpl extends ServiceImpl<FileSystemLogMapper, FileSystemLog> implements IFileSystemLogService {


    @Override
    public Page<FileSystemLog> selectFileLogsPage(Page<FileSystemLog> page, Integer state) {
        // 不进行 count sql 优化，解决 MP 无法自动优化 SQL 问题
        // page.setOptimizeCountSql(false);
        // 不查询总记录数
        // page.setSearchCount(false);
        // 注意！！ 分页 total 是经过插件自动 回写 到传入 page 对象
        return page.setRecords(this.baseMapper.selectFileLogsList(page, state));
    }

    @Override
    public Boolean deleteFileLog(Integer id) {
        int count = this.baseMapper.deleteFileLogById(id);
        return count > 0;
    }
}
