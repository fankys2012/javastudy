package com.starcor.service.impl;

import com.starcor.dao.UserDao;
import com.starcor.entity.User;
import com.starcor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author chaozhong.leng <chaozhong.leng@starcor.com>
 * @Date 2018-02-08 18:18
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    public User findByUserName(String userName){
        return userDao.findByUserName(userName);
    }

    public User findByUserId(int userId) {
        return userDao.findByUserId(userId);
    }


    public void register(User user) {
        this.userDao.addUser(user);
    }

    public void editUser(User user) {
        userDao.editUser(user);
    }

    public Integer delUser(Integer userId) {
        return userDao.delUser(userId);
    }

    public String createToken() {
        String token = UUID.randomUUID().toString().replace("-", "");
        return token;
    }

    public List<User> queryAllUser(){
        return userDao.queryAllUser();
    }


}
