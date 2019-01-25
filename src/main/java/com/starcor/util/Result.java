package com.starcor.util;

import java.io.Serializable;

/**
 * @author chaozhong.leng <chaozhong.leng@starcor.com>
 * @Date 2018-03-02 9:53
 */
public class Result implements Serializable {
    private static final long serialVersionUID = 2325990218522018084L;
    private String code;
    private String message;
    private Object data;

    public Result() {
        this.code = "0";
        this.message = "success";
    }

    public Result(String code ,String message ,Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(String code ,String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
