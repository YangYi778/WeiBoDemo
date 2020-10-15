package com.ysu.weibo.service;

import com.ysu.weibo.entity.Hot3D;
import com.ysu.weibo.entity.HotYun3D;

/**
 * @author Qiantao-H
 * @version 1.0
 * @date 2020/10/14 19:36
 */
public interface JsonService {
    public void saveHot3D(Hot3D hot3D);

    public void saveHotYun3D(HotYun3D hotYun3D);
}
