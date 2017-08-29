package com.example.demo.provider;

import com.example.demo.common.model.User;
import com.example.demo.provider.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by yexin on 2017/8/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoProviderApplication.class)
public class SpringredisTest {


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private UserService userService;
    @Test
    public void str(){


        System.out.println("---start----");
        String key = "aaa";
        String value = "111";
        stringRedisTemplate.opsForValue().set(key,value);
        String out = stringRedisTemplate.opsForValue().get(key);
        System.out.println("out:"+out);
    }




    @Test
    public void insert(){

        String name = "test";
        int age = 18;
        String sex = "f";

        for(Long id=1100L;id<31000L;id++){
            User user = new User();
            user.setUserId(id);
            user.setName(name+id);
            user.setAge(age);
            user.setSex(sex);
            userService.insertUser(user);
        }

    }

}
