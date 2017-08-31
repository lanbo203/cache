package com.example.demo.provider.service;

import com.example.demo.common.model.User;
import com.example.demo.provider.dao.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by lanbo on 2017/8/28.
 */
@Service(value = "userSerivceImpl")
@CacheConfig(cacheNames = "user")
public class UserSerivceImpl implements UserService {

    private static Logger log = LoggerFactory.getLogger(UserSerivceImpl.class);
    @Autowired
    UserMapper userMapper;


    @Cacheable(key = "#root.targetClass + T(String).valueOf(#userId)",unless = "#result eq null")
    public User getUser(Long userId) {

        User user = userMapper.selectByPrimaryKey(userId);
        return user;
    }
    @Caching(put = {@CachePut(key = "#root.targetClass + T(String).valueOf(#user.userId)")})
    public User updateUser(User user) {


        return  userMapper.updateByPrimaryKeySelective(user) == 1 ? user : null;
    }

    @Cacheable(key = "#root.targetClass + #name")
    public User getUserByName(String name) {


        return userMapper.getUserByName(name);
    }


    @Override
    public int insertUser(User user) {
        userMapper.insert(user);
        return 0;
    }

    @Override
    @Caching(evict = {@CacheEvict(key = "#root.targetClass + T(String).valueOf(#userId)" ),
                      @CacheEvict(key = "#root.targetClass + #result.name" )})
    public User delete(Long userId) {
        User user = userMapper.selectByPrimaryKey(userId);
       userMapper.deleteByPrimaryKey(userId);

        return user;
    }



}
