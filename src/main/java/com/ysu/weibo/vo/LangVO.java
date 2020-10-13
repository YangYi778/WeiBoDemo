package com.ysu.weibo.vo;

import lombok.Data;

import java.util.List;

@Data
public class LangVO {
    private List<String> names;
    private List<Integer> values;
    private List<Double> scales;
}
