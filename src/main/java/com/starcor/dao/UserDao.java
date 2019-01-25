package com.starcor.dao;

import com.starcor.entity.User;

import java.util.List;

/**
 * @author chaozhong.leng <chaozhong.leng@starcor.com>
 * @Date 2018-02-09 10:25
 */
public interface UserDao {
    //根据用户名查询
    User findByUserName(String uname);

    User findByUserId(int userId);

    void editUser(User user);

    void addUser(User user);

    Integer delUser(Integer userId);

    List<User> queryAllUser();
}
