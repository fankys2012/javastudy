package com.starcor.controller;

import com.starcor.entity.User;
import com.starcor.service.UserService;
import com.starcor.util.JedisClient;
import com.starcor.util.MD5Util;
import com.starcor.util.RedisSingle;
import com.starcor.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author chaozhong.leng <chaozhong.leng@starcor.com>
 * @Date 2018-03-08 17:25
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UserService userService;

    @Autowired
    private JedisClient jedisClient;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Result login(User user) throws Exception {
        String pwd = user.getUpwd();
        String userName = user.getUname();

        if(userName == null || "".equals(userName) || pwd == null || "".equals(pwd)) {
            return new Result("1","参数错误");
        }


        User getUser = userService.findByUserName(userName);
        if(getUser == null) {
            return new Result("1","用户不存在");
        }
        pwd = MD5Util.md5Digest(pwd);
        if(pwd.equals(getUser.getUpwd()) == false) {
            return new Result("1","密码错误",getUser);
        }
        String token = userService.createToken();

        Map<String,String> map = null;
//        map.put("token",token);

        jedisClient.set(token,String.valueOf(getUser.getUid()));

        return new Result("0","success",token);
    }
}
