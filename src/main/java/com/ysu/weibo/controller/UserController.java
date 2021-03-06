package com.ysu.weibo.controller;

import com.ysu.weibo.entity.*;
import com.ysu.weibo.service.UserService;
import com.ysu.weibo.service.WeiBoUserService;
import com.ysu.weibo.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 万恶de亚撒西 on 2020/10/10.
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private WeiBoUserService weiBoUserService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }

    @RequestMapping("/{url}")
    public String redirect(@PathVariable("url")String url){
        return url;
    }

    @RequestMapping("/AjaxLogin")
    @ResponseBody
    public int AjaxLogin(@RequestBody User user){
        System.out.println(user);
        User result = userService.findByUser(user);
        if(result == null){
            return 777;     /*账户不存在或用户名密码错误*/
        }
        return 999;         /*登陆成功*/
    }

    @RequestMapping("/AjaxRegister")
    @ResponseBody
    public int AjaxRegister(@RequestBody User user){
        System.out.println(user);
        if((userService.findByUserName(user.getUserName())) != null){
            return 777;     /*用户名重复*/
        }
        userService.save(user);
        return 999;         /*注册成功*/
    }

    @ResponseBody
    @RequestMapping("/list")
    public DataVO<WeiBoUser> list(Integer page, Integer limit){
        return weiBoUserService.findData(page,limit);
    }

    @RequestMapping("/provinceDataVO")
    @ResponseBody
    public DataVO<ProvinceItemVO> getProvinceDataVO(){
        return weiBoUserService.getProvinceDataVO();
    }

    @ResponseBody
    @RequestMapping("/WeiBoAgeDataVO")
    public WeiBoAgeVO getWeiBoAgeDataVO(){
        return weiBoUserService.findWeiBoAge();
    }

    @ResponseBody
    @RequestMapping("/weiBoGenderDataVO")
    public DataVO<Gender> getWeiBoGenderDataVO(){
        return weiBoUserService.findWeiBoGender();
    }

    @ResponseBody
    @RequestMapping("/getWordCloudDataVO")
    public DataVO<WordCloudVO> getWordCloudDataVO(@RequestParam("event")String event){
        return weiBoUserService.findWordCloud(event);
    }

    @ResponseBody
    @RequestMapping("/getHotTopicDataVO")
    public HotTopicVO getHotTopicDataVO(@RequestParam("event")String event){
        System.out.println("event==="+event);
        return weiBoUserService.findHotTopic(event);
    }


}
