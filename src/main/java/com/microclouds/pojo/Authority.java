package com.microclouds.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table authority
 *
 * @mbg.generated do_not_delete_during_merge Sat Dec 22 15:48:24 CST 2018
 */
public class Authority implements Serializable {
    /**
     * Database Column Remarks:
     *   自增id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column authority.id
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    private Integer id;

    /**
     * Database Column Remarks:
     *   权限名字
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column authority.authority_name
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    private String authorityName;

    /**
     * Database Column Remarks:
     *   备注
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column authority.remark
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    private String remark;

    /**
     * Database Column Remarks:
     *   对应的角色
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column authority.role_id
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    private Integer roleId;

    /**
     * Database Column Remarks:
     *   时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column authority.create_time
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    private Date createTime;

    /**
     * Database Column Remarks:
     *   状态
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column authority.del_flag
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    private Short delFlag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table authority
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column authority.id
     *
     * @return the value of authority.id
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column authority.id
     *
     * @param id the value for authority.id
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column authority.authority_name
     *
     * @return the value of authority.authority_name
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public String getAuthorityName() {
        return authorityName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column authority.authority_name
     *
     * @param authorityName the value for authority.authority_name
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column authority.remark
     *
     * @return the value of authority.remark
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column authority.remark
     *
     * @param remark the value for authority.remark
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column authority.role_id
     *
     * @return the value of authority.role_id
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column authority.role_id
     *
     * @param roleId the value for authority.role_id
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column authority.create_time
     *
     * @return the value of authority.create_time
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column authority.create_time
     *
     * @param createTime the value for authority.create_time
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column authority.del_flag
     *
     * @return the value of authority.del_flag
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public Short getDelFlag() {
        return delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column authority.del_flag
     *
     * @param delFlag the value for authority.del_flag
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public void setDelFlag(Short delFlag) {
        this.delFlag = delFlag;
    }
}