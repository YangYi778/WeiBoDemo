package com.ysu.weibo.vo;

import lombok.Data;

import java.util.List;

/**
 * Created by 万恶de亚撒西 on 2020/10/12.
 */
@Data
public class ProvinceDataVO<ProvinceItemVO> {
    private Integer code;
    private String msg;
    private Long count;
    private List<ProvinceItemVO> data;
}
