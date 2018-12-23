package com.microclouds.common.util;

/**
 * @author : https://github.com/Fanqie22
 * @date : 2018年12月21日15:02:03
 * @description: 后端返回的信息
 */
public class ResponseValue {
    /**
     * 返回响应的编码
     */
    private String code;

    /**
     * 返回响应信息
     */
    private String message;

    /**
     * 返回响应的数据
     */
    private Object data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseValue{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
