package com.ysu.weibo.vo;

import lombok.Data;

import java.util.List;

/**
 * Created by 万恶de亚撒西 on 2020/10/13.
 */
@Data
public class WeiBoAgeVO<WeiBoAge> {
    private Integer code;
    private String msg;
    private Long count;
    private List<WeiBoAge> data;
}
