package com.starcor.util;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;


/**
 * @author chaozhong.leng <chaozhong.leng@starcor.com>
 * @Date 2018-03-01 14:57
 */
public class OutputJson<T> implements Serializable{

    private Integer code;

    private String message;

    private T data;

    public OutputJson(Integer code, String message,T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
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

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        if(this.data ==null) {
            this.setData((T) new Object());
        }
        return JSON.toJSONString(this);
    }
}
