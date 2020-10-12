package com.ysu.weibo.service.impl;

import com.ysu.weibo.entity.User;
import com.ysu.weibo.mapper.UserMapper;
import com.ysu.weibo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 万恶de亚撒西 on 2020/10/10.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUserName(String userName) {
        return userMapper.findByUserName(userName);
    }

    @Override
    public User findByUser(User user) {
        return userMapper.findByUser(user);
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }
}
