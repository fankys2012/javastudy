package com.starcor.model;

/**
 * @author chaozhong.leng <chaozhong.leng@starcor.com>
 * @Date 2018-02-11 17:01
 */
public class UserModel {

    private int userId;

    private String token;

    public UserModel(int userId,String token) {
        this.userId = userId;
        this.token = token;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "userId=" + userId +
                ", token='" + token + '\'' +
                '}';
    }
}
