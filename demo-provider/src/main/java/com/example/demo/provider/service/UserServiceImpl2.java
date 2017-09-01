package com.example.demo.provider.service;

import com.example.demo.common.model.TransMsg;
import com.example.demo.common.model.User;
import com.example.demo.provider.annotation.CacheMsg;
import com.example.demo.provider.dao.UserMapper;
import com.example.demo.provider.util.RedisCacheUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Service;

/**
 * Created by yexin on 2017/8/30.
 * 非注解形式的更新redis
 * 异步处理更新操作的redis和mysql的同步：只针对修改删除
 */

@Service(value = "userServiceImpl2")
@CacheConfig(cacheNames = "user")
public class UserServiceImpl2  implements UserService{

    @Autowired
    UserMapper userMapper;

    @Autowired
    RedisCacheUtil redisCacheUtil;

    private static Logger log = LoggerFactory.getLogger(UserSerivceImpl.class);

    @Autowired
    SendService sendService;
    /**
     * 查询 by id
     * @param userId
     * @return
     */
//    @Cacheable(key = "#root.targetClass + T(String).valueOf(#userId)",unless = "#result eq null")
    @Cacheable(key = "#root.targetClass + T(String).valueOf(#userId)",unless = "#result eq null")
    public User getUser(Long userId) {

        User user = userMapper.selectByPrimaryKey(userId);
        return user;
    }

    /**
     * query by name
     * @param name
     * @return
     */
    @Cacheable(key = "#root.targetClass + #name")
    public User getUserByName(String name) {


        return userMapper.getUserByName(name);
    }


    public static void main(String[] args) {
        System.out.println(UserServiceImpl2.class.getName());
    }


    /**
     * update user
     * @param user
     * @return
     */
    //@Caching(put = {@CachePut(key = "#root.targetClass + T(String).valueOf(#user.userId)")})
    public User updateUser(User user) {
        System.out.println("   impl2   active   ");
        String key = "class " +UserServiceImpl2.class.getName() + String.valueOf(user.getUserId());
        System.out.println("key:"+key);
        //是否存在key
        if(!redisCacheUtil.exists(key)){
         return  userMapper.updateByPrimaryKeySelective(user) == 1 ? user : null;
        }
        //更新key对应的value  更新队列
        Object object = redisCacheUtil.getValue(key);

        TransMsg msg = new TransMsg(key,object);
        sendService.sendMessage(msg);



        return user;
    }



    @Override
    public int insertUser(User user) {
        userMapper.insert(user);
        return 0;
    }

    /**
     * delete
     * @param userId
     * @return
     */
    @Override
    @Caching(evict = {@CacheEvict(key = "#root.targetClass + T(String).valueOf(#userId)" ),
            @CacheEvict(key = "#root.targetClass + #result.name" )})
    public User delete(Long userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        userMapper.deleteByPrimaryKey(userId);

        return user;
    }
}
