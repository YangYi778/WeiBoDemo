package com.ysu.weibo.entity;

import lombok.Data;

/**
 * Created by 万恶de亚撒西 on 2020/10/10.
 */
@Data
public class WeiBoUser {
    private Integer id;             //用户id——数据库记录编号
    private String uid;             //用户uid
    private String screenName;      //昵称
    private Integer province;       //省级ID
    private Integer city;           //用户所在城市ID
    private String location;        //用户所在地
    private String description;     //用户个人描述
    private String profileImageUrl; //用户头像地址（中图），51×50像素
    private String gender;          //性别，m：男、f：女、n：未知
    private Integer statusesCount;  //微博数
    private String createdAt;       //用户创建（注册）时间
    private String lang;            //用户当前的语言版本，zh-cn：简体中文，zh-tw：繁体中文，en：英语
}
