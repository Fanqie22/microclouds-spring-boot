package com.microclouds.service.impl;

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
	
}
