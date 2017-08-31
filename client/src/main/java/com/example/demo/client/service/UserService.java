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
    Result getUserInfo(@PathVariable("userId") Long userId);

    @RequestMapping(value = "/user/update",method = RequestMethod.PUT)
    Result updateUser(@RequestBody User user);


    @RequestMapping(value = "/user/{name}/name",method = RequestMethod.GET)
    Result getUserByName(@PathVariable("name") String name);

//    @RequestMapping(value = "/user/insert",method = RequestMethod.PUT)
//    public int insertUser(User user);

    @RequestMapping(value = "/user/{userId}/delete",method = RequestMethod.DELETE)
    Result  delete (@PathVariable("userId") Long userId);

}
