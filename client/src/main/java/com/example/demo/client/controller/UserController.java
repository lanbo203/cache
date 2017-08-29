package com.example.demo.client.controller;

import com.example.demo.client.service.UserService;
import com.example.demo.common.model.Result;
import com.example.demo.common.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by lanbo on 2017/8/28.
 */
@RestController
@RequestMapping("/user")
public class UserController {


    /**
     * 此处编译error可不予处理
     */
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public Result<User> getUserInfo(@PathVariable("userId") Long id){
        System.out.println("getuserinfo start --id:-->>>>>>>>>"+id);
        Result result = new Result();
        try {
            result = userService.getUserInfo(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public Result updateUser(@RequestBody User user){

        Result result = new Result();
        try{

           result =  userService.updateUser(user);
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }
}
