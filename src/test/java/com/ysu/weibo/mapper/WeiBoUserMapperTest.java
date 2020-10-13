package com.ysu.weibo.mapper;

import com.ysu.weibo.service.WeiBoUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Created by 万恶de亚撒西 on 2020/10/10.
 */
@SpringBootTest
class WeiBoUserMapperTest {

    @Autowired
    private WeiBoUserService weiBoUserService;

    @Test
    public void testWeiBoAge(){
        System.out.println(weiBoUserService.findWeiBoAge());
    }
//    @Autowired
//    private WeiBoUserMapper weiBoUserMapper;
//
//    @Test
//    void test(){
//        weiBoUserMapper.selectList(null).forEach(System.out::println);
//    }
}