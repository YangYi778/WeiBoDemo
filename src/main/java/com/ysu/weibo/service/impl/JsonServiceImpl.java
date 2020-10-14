package com.ysu.weibo.service.impl;

import com.ysu.weibo.entity.Hot3D;
import com.ysu.weibo.entity.HotYun3D;
import com.ysu.weibo.mapper.JsonMapper;
import com.ysu.weibo.service.JsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Qiantao-H
 * @version 1.0
 * @date 2020/10/14 19:37
 */

@Service
public class JsonServiceImpl implements JsonService {

    @Autowired
    private  JsonMapper jsonMapper;

    @Override
    public void saveHot3D(Hot3D hot3D) {
        jsonMapper.saveHot3D(hot3D);
    }

    @Override
    public void saveHotYun3D(HotYun3D hotYun3D) {
        jsonMapper.saveHotYun3D(hotYun3D);
    }
}
