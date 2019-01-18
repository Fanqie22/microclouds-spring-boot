package com.microclouds.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author https://github.com/Fanqie22
 * @since 2019-01-17
 */
@TableName("user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 自增id,唯一标识用户
	 */
	@TableId(type = IdType.AUTO)
	private Integer id;

	/**
	 * 用户的账户,邮箱或者手机号
	 */
	@TableField(value="user_mail")
	private String userMail;

	/**
	 * 用户的密码,使用MD5加密
	 */
	private String password;

	/**
	 * 
	 */
	@TableField(value="user_name")
	private String userName;

	/**
	 * 用户的角色
	 */
	@TableField(value="role_name")
	private String roleName;

	/**
	 * 创建时间
	 */
	@TableField(value="create_time")
	private Date createTime;

	/**
	 * 更新时间
	 */
	@TableField(value="update_time")
	private Date updateTime;

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

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
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

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", userMail='" + userMail + '\'' +
				", password='" + password + '\'' +
				", userName='" + userName + '\'' +
				", roleName='" + roleName + '\'' +
				", createTime=" + createTime +
				", updateTime=" + updateTime +
				", delFlag=" + delFlag +
				'}';
	}
}
