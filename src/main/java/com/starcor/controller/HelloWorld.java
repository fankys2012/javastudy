package com.starcor.controller;

import com.starcor.entity.User;
import com.starcor.util.CustomException;
import com.starcor.util.JedisClient;
import com.starcor.util.RedisCacheUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author chaozhong.leng <chaozhong.leng@starcor.com>
 * @Date 2018-02-08 17:35
 */
@Controller
@RequestMapping("/HelloWorld")
public class HelloWorld extends BaseController {



    @Autowired
    private RedisCacheUtil redisCacheUtil;

    @Autowired
    private JedisClient jedisClient;


    @RequestMapping("/say")
    @ResponseBody
    public String sayHello() throws Exception {
//        redisCacheUtil.set("name","lisi");
        boolean st = jedisClient.set("name","liis");

        if (st) {
//            throw new CustomException(0,"错误了");
            System.out.println("ss");
        }

        System.out.println("redis value:"+jedisClient.get("name"));
        return "xxxx";
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:application.xml");
        System.out.println("xxx");
    }

}
