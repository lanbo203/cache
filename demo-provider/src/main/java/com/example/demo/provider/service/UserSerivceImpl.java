package com.example.demo.provider.service;

import com.example.demo.common.model.User;
import com.example.demo.provider.dao.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by lanbo on 2017/8/28.
 */
@Service
public class UserSerivceImpl implements UserService {

    private static Logger log = LoggerFactory.getLogger(UserSerivceImpl.class);
    @Autowired
    UserMapper userMapper;

    @Override
    @Cacheable(value = "user", key = "#root.targetClass + T(String).valueOf(#userId)",unless = "#result eq null")
    public User getUser(Long userId) {



        log.info("-->>>>userid:"+userId);
        User user = userMapper.selectByPrimaryKey(userId);


        return user;
    }

    @Override
    @CacheEvict(value="user" ,key = "#root.targetClass + T(String).valueOf(#user.userId)")
    public int updateUser(User user) {


        return userMapper.updateByPrimaryKeySelective(user);
    }


    @Override
    public int insertUser(User user) {
        userMapper.insert(user);
        return 0;
    }
}
