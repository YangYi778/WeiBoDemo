package com.ysu.weibo.service;

import com.ysu.weibo.entity.User;
import com.ysu.weibo.entity.WeiBoUser;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by 万恶de亚撒西 on 2020/10/10.
 */

public interface UserService {
    public User findByUserName(String userName);

    public User findByUser(User user);

    public List<WeiBoUser> findAll();

    public void save(User user);
}
