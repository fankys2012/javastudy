package com.starcor.controller;

import com.starcor.entity.User;
import com.starcor.service.UserService;
import com.starcor.util.MD5Util;
import com.starcor.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


/**
 * @author chaozhong.leng <chaozhong.leng@starcor.com>
 * @Date 2018-03-01 17:01
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    /**
     * 用户注册
     * @param user
     * @return
     */
    @RequestMapping(value = "",method = RequestMethod.POST)
    public Result register(User user) {
        String userName = user.getUname();
        if("".equals(userName) || userName == null) {
            return new Result("1","用户不能为空",null);
        }
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateTime = dateFormat.format(date);
        user.setCreateTime(dateTime);
        if(userService.findByUserName(userName) == null) {
            if(user.getUpwd() != null) {
                String pwd = MD5Util.md5Digest(user.getUpwd());
                user.setUpwd(pwd);
            }
            userService.register(user);
            System.out.println("register");
        }
        else
        {
            return new Result("1",userName+" exists ",null);
        }

        return new Result("0","register ok",user);
    }

    /**
     * 获取用户
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Result getUserById(@PathVariable(value = "id") Integer id){
        if (id == null || id ==0) {
            return  new Result("1","参数错误");
        }
        User user = userService.findByUserId(id);

        return  new Result("0","获取用户成功",user);
//        return new Result("0","get user by id 中文 " + id,null);
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Result delUser(@PathVariable(value = "id") Integer id) {
        if (id == null || id ==0) {
            return  new Result("1","参数错误");
        }
        User user = userService.findByUserId(id);
        if(user == null) {
            return  new Result("1","用户不存在");
        }
        Integer affectedRows = userService.delUser(id);
        if(affectedRows <1) {
            return  new Result("1","删除失败");
        }

        return  new Result("0","删除用户成功",user);
    }

    /**
     * 修改用户
     * @param user
     * @return
     */
    @RequestMapping(value = "",method = RequestMethod.PUT)
    public Result editUser(User user) {
        int userId = user.getUid();
        if(userService.findByUserId(userId) == null) {
            return  new Result("1","用户不存在",user);
        }
        else {
            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateTime = dateFormat.format(date);
            user.setCreateTime(dateTime);
            if(user.getUpwd() != null) {
                String pwd = MD5Util.md5Digest(user.getUpwd());
                user.setUpwd(pwd);
            }
            userService.editUser(user);
        }

        return  new Result("0","修改成功",user);
    }

    @RequestMapping(value = "/all")
    public Result getAll() {
        List<User> userList = userService.queryAllUser();
        for (Iterator userIterator = userList.iterator();userIterator.hasNext();) {
            System.out.println(userIterator.next());
        }
        return  new Result("0","修改成功");
    }

}
