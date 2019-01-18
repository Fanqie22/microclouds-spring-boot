package com.microclouds.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author https://github.com/Fanqie22
 * @since 2019-01-17
 */
@TableName("file_system")
public class FileSystem implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 文件系统表的自增id
	 */
	@TableId(type = IdType.AUTO)
	private Integer id;

	/**
	 * 文件所属的用户
	 */
	@TableField(value="user_id")
	private Integer userId;

	/**
	 * 文件对应的父节点
	 */
	private Integer pid;

	/**
	 * 文件路径,只记录pid,以逗号相隔,不记录文字
	 */
	@TableField(value="pid_path")
	private String pidPath;

	/**
	 * 文件名
	 */
	@TableField(value="file_name")
	private String fileName;

	/**
	 * 文件的类型,文件夹为'folder'
	 */
	@TableField(value="file_type")
	private String fileType;

	/**
	 * 文件大小,以KB 为单位
	 */
	@TableField(value="file_size")
	private BigDecimal fileSize;

	/**
	 * 
	 */
	@TableField(value="file_md5")
	private String fileMd5;

	/**
	 * 创建时间,自动
	 */
	@TableField(value="create_time")
	private Date createTime;

	/**
	 * 更新时间
	 */
	@TableField(value="update_time")
	private Date updateTime;

	/**
	 * 文件类型对应的图标
	 */
	@TableField(value="file_icon")
	private String fileIcon;

	/**
	 * 状态,0-正常,1-已被删除
	 */
	@TableField(value="del_flag")
	private Integer delFlag;



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPidPath() {
		return pidPath;
	}

	public void setPidPath(String pidPath) {
		this.pidPath = pidPath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public BigDecimal getFileSize() {
		return fileSize;
	}

	public void setFileSize(BigDecimal fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileMd5() {
		return fileMd5;
	}

	public void setFileMd5(String fileMd5) {
		this.fileMd5 = fileMd5;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getFileIcon() {
		return fileIcon;
	}

	public void setFileIcon(String fileIcon) {
		this.fileIcon = fileIcon;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

}
