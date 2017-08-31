package com.example.demo.provider.service;

import com.example.demo.common.model.User;

/**
 * Created by lanbo on 2017/8/28.
 */
public interface UserService {
    User getUser(Long userId);

    User updateUser(User user);

    User getUserByName(String name);

    int insertUser(User user);

    User  delete (Long userId);
}
