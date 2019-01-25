package com.starcor.util;

/**
 * @author chaozhong.leng <chaozhong.leng@starcor.com>
 * @Date 2018-02-28 18:18
 */
public class CustomException extends Exception {
    private static final long serialVersionUID = -7638041501183925225L;

    //异常信息
    public String message;



    private Integer code;

    public CustomException(Integer code,String message) {
        super(message);
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
