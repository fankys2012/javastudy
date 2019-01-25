package com.starcor.exception;

public class AuthException extends Exception {

    private String message;

    private String code;

    public AuthException(String message) {
        this.message = message;
    }

    public AuthException(String message,String code) {
        super(message);
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }
}
