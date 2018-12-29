package com.microclouds.entity;

import javax.validation.constraints.NotEmpty;

public class UserVo {

    private Integer id;

    private String userName;

    @NotEmpty(message = "{userInfo.userMail.isNull}")
    private String userMail;

    @NotEmpty(message = "{userInfo.password.isNull}")
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
}
