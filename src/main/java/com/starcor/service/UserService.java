package com.starcor.service;

import com.starcor.entity.User;
import com.starcor.model.UserModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chaozhong.leng <chaozhong.leng@starcor.com>
 * @Date 2018-02-08 18:15
 */
public interface UserService {

    User findByUserName(String userName);

    User findByUserId(int userId);

    //增加用户
    public void register(User user);

    void editUser(User user);

    Integer delUser(Integer userId);

    public String createToken();

    List<User> queryAllUser();
}
