package com.ysu.weibo.entity;

import lombok.Data;

/**
 * Created by 万恶de亚撒西 on 2020/10/10.
 */
@Data
public class User {
    private Integer id;
    private String userName;
    private String password;
    private String mail;
    private Integer auth;
    private Integer status;
}
