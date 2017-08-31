package com.example.demo.provider.service;

import com.example.demo.common.model.User;
import com.example.demo.provider.dao.UserMapper;
import com.example.demo.provider.util.RedisCacheUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.interceptor.KeyGenerator;

/**
 * Created by yexin on 2017/8/30.
 */
//@Service(value = "userServiceImpl2")
public class UserServiceImpl2 {

    @Autowired
    UserMapper userMapper;

    @Autowired
    RedisCacheUtil redisCacheUtil;

    @Autowired
    KeyGenerator keyGenerator;


    public User getUser(Long userId) {
        //String cachekey = UserServiceImpl2.class.getName() +
//        keyGenerator.

        return null;
    }

    public User updateUser(User user) {
        return null;
    }

    public User getUserByName(String name) {
        return null;
    }

    public int insertUser(User user) {
        return 0;
    }

    public void delete(Long userId) {

    }
}
