package com.microclouds.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table file_system
 *
 * @mbg.generated do_not_delete_during_merge Sat Dec 22 15:48:24 CST 2018
 */
public class FileSystem implements Serializable {
    /**
     * Database Column Remarks:
     *   文件系统表的自增id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column file_system.id
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    private Integer id;

    /**
     * Database Column Remarks:
     *   文件所属的用户
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column file_system.user_id
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    private Integer userId;

    /**
     * Database Column Remarks:
     *   文件对应的父节点
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column file_system.pid
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    private Integer pid;

    /**
     * Database Column Remarks:
     *   文件名
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column file_system.file_name
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    private String fileName;

    /**
     * Database Column Remarks:
     *   文件的类型,文件夹为'folder'
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column file_system.file_type
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    private String fileType;

    /**
     * Database Column Remarks:
     *   文件大小,以KB 为单位
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column file_system.file_size
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    private BigDecimal fileSize;

    /**
     * Database Column Remarks:
     *   创建时间,自动
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column file_system.create_time
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    private Date createTime;

    /**
     * Database Column Remarks:
     *   更新时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column file_system.update_time
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    private Date updateTime;

    /**
     * Database Column Remarks:
     *   文件类型对应的图标
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column file_system.file_icon
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    private Short fileIcon;

    /**
     * Database Column Remarks:
     *   状态,0-正常,1-已被删除
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column file_system.del_flag
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    private Short delFlag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table file_system
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column file_system.id
     *
     * @return the value of file_system.id
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column file_system.id
     *
     * @param id the value for file_system.id
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column file_system.user_id
     *
     * @return the value of file_system.user_id
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column file_system.user_id
     *
     * @param userId the value for file_system.user_id
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column file_system.pid
     *
     * @return the value of file_system.pid
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column file_system.pid
     *
     * @param pid the value for file_system.pid
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column file_system.file_name
     *
     * @return the value of file_system.file_name
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column file_system.file_name
     *
     * @param fileName the value for file_system.file_name
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column file_system.file_type
     *
     * @return the value of file_system.file_type
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public String getFileType() {
        return fileType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column file_system.file_type
     *
     * @param fileType the value for file_system.file_type
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column file_system.file_size
     *
     * @return the value of file_system.file_size
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public BigDecimal getFileSize() {
        return fileSize;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column file_system.file_size
     *
     * @param fileSize the value for file_system.file_size
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public void setFileSize(BigDecimal fileSize) {
        this.fileSize = fileSize;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column file_system.create_time
     *
     * @return the value of file_system.create_time
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column file_system.create_time
     *
     * @param createTime the value for file_system.create_time
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column file_system.update_time
     *
     * @return the value of file_system.update_time
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column file_system.update_time
     *
     * @param updateTime the value for file_system.update_time
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column file_system.file_icon
     *
     * @return the value of file_system.file_icon
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public Short getFileIcon() {
        return fileIcon;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column file_system.file_icon
     *
     * @param fileIcon the value for file_system.file_icon
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public void setFileIcon(Short fileIcon) {
        this.fileIcon = fileIcon;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column file_system.del_flag
     *
     * @return the value of file_system.del_flag
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public Short getDelFlag() {
        return delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column file_system.del_flag
     *
     * @param delFlag the value for file_system.del_flag
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public void setDelFlag(Short delFlag) {
        this.delFlag = delFlag;
    }
}