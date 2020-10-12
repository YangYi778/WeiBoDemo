package com.ysu.weibo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ysu.weibo.entity.User;

import java.util.List;

/**
 * Created by 万恶de亚撒西 on 2020/10/10.
 */
public interface UserMapper {

    public User findByUserName(String userName);

    public User findByUser(User user);

    public List<User> findAll();

}
