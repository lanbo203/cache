package com.example.demo.provider.service;

import com.example.demo.common.model.User;

/**
 * Created by lanbo on 2017/8/28.
 */
public interface UserService {
    public User getUser(Long userId);

    public int updateUser(User user);

    public int insertUser(User user);
}
