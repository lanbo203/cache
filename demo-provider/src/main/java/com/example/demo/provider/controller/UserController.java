package com.example.demo.provider.controller;

import com.example.demo.common.model.Result;
import com.example.demo.common.model.User;
import com.example.demo.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by lanbo on 2017/8/28.
 */
@RestController
//@RequestMapping("/user")
public class UserController {


    @Autowired
    public UserService userService;

    @RequestMapping(value = "/user/{userId}",method = RequestMethod.GET)
    public Result<User> getUser(@PathVariable("userId") Long userId){


        System.out.println("provider controller start -----------------");
        Result result = new Result();

        try {
            Long before = new Date().getTime();
            System.out.println(before);
            User user = userService.getUser(userId);
            System.out.println(new Date().getTime() - before);
            result.setData(user);
            result.setSuccess(true);


        } catch (Exception e) {
            e.printStackTrace();

            result.setSuccess(false);
            result.setError("查询失败");
        }
        return result;
    }

    @RequestMapping(value = "/user/update",method = RequestMethod.PUT)
    public Result updateUser(@RequestBody User user){

        Result result = new Result();

        try {
            userService.updateUser(user);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setError("udpate fail");
        }

        return result;

    }
}
