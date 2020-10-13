package com.ysu.weibo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ysu.weibo.WeiboApplication;
import com.ysu.weibo.entity.DateRange;
import com.ysu.weibo.entity.Gender;
import com.ysu.weibo.entity.WeiBoAge;
import com.ysu.weibo.entity.WeiBoUser;
import com.ysu.weibo.mapper.WeiBoUserMapper;
import com.ysu.weibo.service.WeiBoUserService;
import com.ysu.weibo.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.krb5.internal.crypto.Aes128;

import java.sql.Wrapper;

import java.util.*;

/**
 * Created by 万恶de亚撒西 on 2020/10/10.
 */
@Service
public class WeiBoUserServiceImpl implements WeiBoUserService {




    @Autowired
    private WeiBoUserMapper weiBoUserMapper;

    @Override
    public DataVO<WeiBoUser> findData(Integer page, Integer limit) {
        DataVO dataVO = new DataVO();
        dataVO.setCode(0);
        dataVO.setMsg("");

        IPage<WeiBoUser> weiBoUserIPage = new Page<>(page, limit);
        IPage<WeiBoUser> result = weiBoUserMapper.selectPage(weiBoUserIPage, null);
        dataVO.setCount(result.getTotal());
        dataVO.setData(result.getRecords());


        return dataVO;
    }

    @Override
    public DataVO<ProvinceItemVO> getProvinceDataVO() {

        DataVO<ProvinceItemVO> dataVO = new DataVO<>();
        dataVO.setCode(0);
        dataVO.setMsg("");

        List<ProvinceVO> list = weiBoUserMapper.findAllProvinceDataVO();
        System.out.println("list.size()=======" + list.size());
        dataVO.setCount(Long.parseLong(String.valueOf(list.size())));
        System.out.println("list+++++++++" + list);
//        List<String> names = new ArrayList<>();
//        List<Integer> values = new ArrayList<>();
//        for(ProvinceVO provinceVO : list){
//            names.add(setProcinceMap().get(provinceVO.getName()));
//            values.add(provinceVO.getValue());
//        }
//        ProvinceBarVO provinceBarVO = new ProvinceBarVO();
//        provinceBarVO.setName(names);
//        provinceBarVO.setValue(values);
        List<ProvinceItemVO> data = new ArrayList<>();
        for(ProvinceVO provinceVO : list){
            ProvinceItemVO provinceItemVO = new ProvinceItemVO();
            provinceItemVO.setName(setProcinceMap().get(provinceVO.getProvince()));
            provinceItemVO.setValue(provinceVO.getCount());
            data.add(provinceItemVO);
        }
        dataVO.setData(data);
        return dataVO;
    }

    @Override
    public WeiBoAgeVO findWeiBoAge() {
        List<DateRange> list = setDateRange();
        List<String> peroids = new ArrayList<>();
        List<Integer> values = new ArrayList<>();
        WeiBoAgeVO weiBoAgeVO = new WeiBoAgeVO();
        for(DateRange range : list){
            //WeiBoAge weiBoAge = new WeiBoAge();
            /*weiBoAge.setName(range.getStartDate() + "—" + range.getEndDate() + "年");
            weiBoAge.setValue(weiBoUserMapper.findWeiBoAge(range));*/
            peroids.add(range.getStartDate() + "—" + range.getEndDate() + "年");
            values.add(weiBoUserMapper.findWeiBoAge(range));
        }
        weiBoAgeVO.setPeroids(peroids);
        weiBoAgeVO.setValues(values);
        return weiBoAgeVO;
    }

    @Override
    public DataVO<Gender> findWeiBoGender() {
        DataVO<Gender> dataVO = new DataVO<>();
        dataVO.setCode(0);
        dataVO.setMsg("");
        List<Gender> list = weiBoUserMapper.findWeiBoGender();
        dataVO.setCount(Long.parseLong(String.valueOf(list.size())));
        for(Gender gender : list){
            if(gender.getName().equals("m")){
                gender.setName("男");
            }else{
                gender.setName("女");
            }
        }
        dataVO.setData(list);
        return dataVO;
    }

    public List<DateRange> setDateRange(){
        List<DateRange> list = new ArrayList<>();
        list.add(new DateRange(0,1));
        list.add(new DateRange(1,3));
        list.add(new DateRange(3,6));
        list.add(new DateRange(6,10));
        list.add(new DateRange(10,30));
        return list;
    }
    public Map<Integer,String> setProcinceMap() {
        Map<Integer,String> provinceMap = new HashMap<>();
        provinceMap.put(11,"北京");provinceMap.put(34,"安徽");
        provinceMap.put(50,"重庆");provinceMap.put(35,"福建");
        provinceMap.put(62,"甘肃");provinceMap.put(44,"广东");
        provinceMap.put(45,"广西");provinceMap.put(52,"贵州");
        provinceMap.put(46,"海南");provinceMap.put(13,"河北");
        provinceMap.put(23,"黑龙江");provinceMap.put(41,"河南");
        provinceMap.put(42,"湖北");provinceMap.put(43,"湖南");
        provinceMap.put(15,"内蒙古");provinceMap.put(32,"江苏");
        provinceMap.put(36,"江西");provinceMap.put(22,"吉林");
        provinceMap.put(21,"辽宁");provinceMap.put(64,"宁夏");
        provinceMap.put(63,"青海");provinceMap.put(14,"山西");
        provinceMap.put(37,"山东");provinceMap.put(31,"上海");
        provinceMap.put(51,"四川");provinceMap.put(12,"天津");
        provinceMap.put(54,"西藏");provinceMap.put(65,"新疆");
        provinceMap.put(53,"云南");provinceMap.put(33,"云南");
        provinceMap.put(33,"浙江");provinceMap.put(61,"陕西");
        provinceMap.put(71,"台湾");provinceMap.put(81,"香港");
        provinceMap.put(82,"澳门");provinceMap.put(400,"海外");
        provinceMap.put(100,"其他");
        return provinceMap;
    }

    @Override
    public void deleteOne(String uid) {
        LambdaQueryWrapper<WeiBoUser> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(WeiBoUser::getUid,uid);
        weiBoUserMapper.delete(wrapper);
    }

}
