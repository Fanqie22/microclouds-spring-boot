package com.microclouds.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.microclouds.dao.FileSystemMapper;
import com.microclouds.entity.FileSystem;
import com.microclouds.service.IFileSystemService;
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
public class FileSystemServiceImpl extends ServiceImpl<FileSystemMapper, FileSystem> implements IFileSystemService {
	
}
