package com.ysu.weibo.mapper;

import com.ysu.weibo.entity.Hot3D;
import com.ysu.weibo.entity.HotYun3D;
import org.apache.ibatis.annotations.Insert;

/**
 * @author Qiantao-H
 * @version 1.0
 * @date 2020/10/14 19:27
 */
public interface JsonMapper {

    @Insert("INSERT INTO event_hot (event_hot.eventname,event_hot.hotdate,event_hot.hotvalue) VALUES (#{eventname},#{hotdate},#{hotvalue})")
    public void saveHot3D(Hot3D hot3D);

    @Insert("INSERT INTO word_yun (word_yun.word,word_yun.count) VALUES (#{word},#{count})")
    public void saveHotYun3D(HotYun3D hotYun3D);
}
