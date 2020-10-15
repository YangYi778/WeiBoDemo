package com.ysu.weibo.vo;

import lombok.Data;

import java.util.List;

/**
 * Created by 万恶de亚撒西 on 2020/10/14.
 */
@Data
public class HotTopicVO {
    private List<String> hotdate;
    private List<Integer> hotvalue;
}
