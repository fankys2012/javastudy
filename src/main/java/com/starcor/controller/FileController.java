package com.starcor.controller;

import com.starcor.annotation.LoginRequired;
import com.starcor.util.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/file")
public class FileController {

    @LoginRequired
    @RequestMapping("/test")
    public Result file() {
        return new Result("1","参数错误");
    }

    @RequestMapping("/test2")
    public Result file2() {
        throw new RuntimeException("有问题 哦");
//        return new Result("0","未登陆访问");
    }
}
