package com.microclouds.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table user_detail
 *
 * @mbg.generated do_not_delete_during_merge Sat Dec 22 15:48:24 CST 2018
 */
public class UserDetail implements Serializable {
    /**
     * Database Column Remarks:
     *   自增id,唯一标识详细用户信息表的记录
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_detail.id
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    private Integer id;

    /**
     * Database Column Remarks:
     *   user表的id,联结user表
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_detail.user_id
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    private Integer userId;

    /**
     * Database Column Remarks:
     *   用户的姓名
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_detail.user_name
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    private String userName;

    /**
     * Database Column Remarks:
     *   电话号码
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_detail.phone
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    private String phone;

    /**
     * Database Column Remarks:
     *   邮箱
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_detail.user_mail
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    private String userMail;

    /**
     * Database Column Remarks:
     *   用户的详细地址-省份
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_detail.province
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    private String province;

    /**
     * Database Column Remarks:
     *   用户的详细地址-城市
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_detail.city
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    private String city;

    /**
     * Database Column Remarks:
     *   用户的详细地址-区域
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_detail.area
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    private String area;

    /**
     * Database Column Remarks:
     *   生日,yyyy-mm-dd
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_detail.birthday
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    private Date birthday;

    /**
     * Database Column Remarks:
     *   学历,可填写具体大学,学校
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_detail.education
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    private String education;

    /**
     * Database Column Remarks:
     *   性别,0-女,1-男
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_detail.sex
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    private Boolean sex;

    /**
     * Database Column Remarks:
     *   个性签名
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_detail.signature
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    private String signature;

    /**
     * Database Column Remarks:
     *   社交账号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_detail.social_account
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    private String socialAccount;

    /**
     * Database Column Remarks:
     *   公司,工作的地方
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_detail.company
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    private String company;

    /**
     * Database Column Remarks:
     *   头像的地址
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_detail.icon
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    private String icon;

    /**
     * Database Column Remarks:
     *   创建时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_detail.create_time
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    private Date createTime;

    /**
     * Database Column Remarks:
     *   更新时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_detail.update_time
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    private Date updateTime;

    /**
     * Database Column Remarks:
     *   状态,0-正常,1-已被删除
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_detail.del_flag
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    private Short delFlag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user_detail
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_detail.id
     *
     * @return the value of user_detail.id
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_detail.id
     *
     * @param id the value for user_detail.id
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_detail.user_id
     *
     * @return the value of user_detail.user_id
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_detail.user_id
     *
     * @param userId the value for user_detail.user_id
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_detail.user_name
     *
     * @return the value of user_detail.user_name
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_detail.user_name
     *
     * @param userName the value for user_detail.user_name
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_detail.phone
     *
     * @return the value of user_detail.phone
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_detail.phone
     *
     * @param phone the value for user_detail.phone
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_detail.user_mail
     *
     * @return the value of user_detail.user_mail
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public String getUserMail() {
        return userMail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_detail.user_mail
     *
     * @param userMail the value for user_detail.user_mail
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_detail.province
     *
     * @return the value of user_detail.province
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public String getProvince() {
        return province;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_detail.province
     *
     * @param province the value for user_detail.province
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_detail.city
     *
     * @return the value of user_detail.city
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public String getCity() {
        return city;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_detail.city
     *
     * @param city the value for user_detail.city
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_detail.area
     *
     * @return the value of user_detail.area
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public String getArea() {
        return area;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_detail.area
     *
     * @param area the value for user_detail.area
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_detail.birthday
     *
     * @return the value of user_detail.birthday
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_detail.birthday
     *
     * @param birthday the value for user_detail.birthday
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_detail.education
     *
     * @return the value of user_detail.education
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public String getEducation() {
        return education;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_detail.education
     *
     * @param education the value for user_detail.education
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public void setEducation(String education) {
        this.education = education;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_detail.sex
     *
     * @return the value of user_detail.sex
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public Boolean getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_detail.sex
     *
     * @param sex the value for user_detail.sex
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_detail.signature
     *
     * @return the value of user_detail.signature
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public String getSignature() {
        return signature;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_detail.signature
     *
     * @param signature the value for user_detail.signature
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public void setSignature(String signature) {
        this.signature = signature;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_detail.social_account
     *
     * @return the value of user_detail.social_account
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public String getSocialAccount() {
        return socialAccount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_detail.social_account
     *
     * @param socialAccount the value for user_detail.social_account
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public void setSocialAccount(String socialAccount) {
        this.socialAccount = socialAccount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_detail.company
     *
     * @return the value of user_detail.company
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public String getCompany() {
        return company;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_detail.company
     *
     * @param company the value for user_detail.company
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_detail.icon
     *
     * @return the value of user_detail.icon
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public String getIcon() {
        return icon;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_detail.icon
     *
     * @param icon the value for user_detail.icon
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_detail.create_time
     *
     * @return the value of user_detail.create_time
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_detail.create_time
     *
     * @param createTime the value for user_detail.create_time
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_detail.update_time
     *
     * @return the value of user_detail.update_time
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_detail.update_time
     *
     * @param updateTime the value for user_detail.update_time
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_detail.del_flag
     *
     * @return the value of user_detail.del_flag
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public Short getDelFlag() {
        return delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_detail.del_flag
     *
     * @param delFlag the value for user_detail.del_flag
     *
     * @mbg.generated Sat Dec 22 15:48:24 CST 2018
     */
    public void setDelFlag(Short delFlag) {
        this.delFlag = delFlag;
    }
}