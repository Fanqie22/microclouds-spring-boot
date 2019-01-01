package com.microclouds.entity;

import javax.validation.constraints.NotEmpty;

public class RestPasswordDto {
    @NotEmpty(message = "userInfo.userMail isNull")
    private String userMail;

    @NotEmpty(message = "userInfo.password isNull")
    private String password;

    @NotEmpty(message = "mailCode isNull")
    private String mailCode;

    @NotEmpty(message = "getMailCode isNull")
    private String getMailCode;

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

    public String getMailCode() {
        return mailCode;
    }

    public void setMailCode(String mailCode) {
        this.mailCode = mailCode;
    }

    public String getGetMailCode() {
        return getMailCode;
    }

    public void setGetMailCode(String getMailCode) {
        this.getMailCode = getMailCode;
    }
}
