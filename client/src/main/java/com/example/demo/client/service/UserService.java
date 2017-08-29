package com.example.demo.client.service;

import com.example.demo.common.model.Result;
import com.example.demo.common.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Created by lanbo on 2017/8/28.
 */

@FeignClient(value = "demo-provider")
public interface UserService {


    @RequestMapping(value = "/user/{userId}",method = RequestMethod.GET)
    public Result getUserInfo(@PathVariable("userId") Long userId);

    @RequestMapping(value = "/user/update",method = RequestMethod.PUT)
    public Result updateUser(@RequestBody User user);
}
