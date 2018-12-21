package com.microclouds.entity;

/**
 * @author : https://github.com/Fanqie22
 * @date : 2018年12月19日11:37:34
 * @description: User用户登录信息表, 简表
 */
public class User {

    /**
     * 自增id
     */
    private Long id;

    /**
     * 用户的登录名,可以是邮箱或者手机号
     */
    private String userName;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 用户类型
     */
    private Integer userType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", userType=" + userType +
                '}';
    }
}
