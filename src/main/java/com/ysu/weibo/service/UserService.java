package com.ysu.weibo.service;

import com.ysu.weibo.entity.User;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by 万恶de亚撒西 on 2020/10/10.
 */

public interface UserService {
    public User findByUserName(String userName);

    public User findByUser(User user);

    public List<User> findAll();

    public void save(User user);
}
