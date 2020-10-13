package com.ysu.weibo.controller;

import com.ysu.weibo.service.WeiBoUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Qiantao-H
 * @version 1.0
 * @date 2020/10/12 15:20
 */

@Controller
public class WeiBoInfoController {

    @Autowired
    private WeiBoUserService weiBoUserService;

    @RequestMapping("/deleteOne")
    @ResponseBody
    public int deleteOne(String uid){
        System.out.println("@@@@"+uid+"@@@@");
        try {
            weiBoUserService.deleteOne(uid);
        }catch (Exception e){
            System.out.println("删除失败"+e.getMessage());
            return 777;
        }
        return 999;
    }
}
