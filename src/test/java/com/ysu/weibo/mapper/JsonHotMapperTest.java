package com.ysu.weibo.mapper;

import com.ysu.weibo.entity.Hot3D;
import com.ysu.weibo.entity.HotYun3D;
import com.ysu.weibo.service.JsonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Qiantao-H
 * @version 1.0
 * @date 2020/10/14 19:41
 */

@SpringBootTest
public class JsonHotMapperTest {

    @Autowired
    private JsonService jsonService;

    @Test
    public void testSaveHot3D(){
        Hot3D hot3D = new Hot3D();
        hot3D.setEventname("湖人");
        hot3D.setHotdate("2020-10-14");
        hot3D.setHotvalue(29);
        jsonService.saveHot3D(hot3D);
    }

    @Test
    public void testSaveHotYun3D(){
        HotYun3D hotYun3D = new HotYun3D();
        hotYun3D.setWord("牛逼");
        hotYun3D.setCount(2345);
        jsonService.saveHotYun3D(hotYun3D);
    }
}
