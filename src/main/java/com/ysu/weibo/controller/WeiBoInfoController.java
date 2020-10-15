package com.ysu.weibo.controller;

import com.ysu.weibo.entity.GuoLvResult;
import com.ysu.weibo.service.UserService;
import com.ysu.weibo.service.WeiBoUserService;
import com.ysu.weibo.vo.LangVO;
import com.ysu.weibo.vo.ZoneVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Qiantao-H
 * @version 1.0
 * @date 2020/10/12 15:20
 */

@Controller
public class WeiBoInfoController {

    @Autowired
    private WeiBoUserService weiBoUserService;
    @Autowired
    private UserService userService;

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

    @RequestMapping("/WeiBoLangScales")
    @ResponseBody
    public LangVO getWeiBoLangScales(){
        return weiBoUserService.findWeiBoLang();
    }

    @RequestMapping("/WeiBoZoneVO")
    @ResponseBody
    public List<ZoneVO> getWeiBoZoneVO() {return weiBoUserService.findWeiBoZone();}

    @RequestMapping("/deleteRepeat")
    @ResponseBody
    public GuoLvResult deleteRepeat(){
        System.out.println("@@@@");
        int count1 = 0;
        int count2 = 0;
        GuoLvResult guoLvResult = new GuoLvResult();
        try {
            /*
            * 去无用
            * */
            count1 = userService.findAll().size();
            weiBoUserService.deleteInvaildDate();
            count2 = userService.findAll().size();
            guoLvResult.setInvalidCount(count1-count2);
            /*
            * 去重复
            * */
            count1 = userService.findAll().size();
            weiBoUserService.deleteRepeat();
            count2 = userService.findAll().size();
            guoLvResult.setRepeatCount(count1-count2);

            guoLvResult.setSuccess(999);
        }catch (Exception e){
            System.out.println("删除失败");
            guoLvResult.setSuccess(777);
            return guoLvResult;
        }
        return guoLvResult;
    }
    }

