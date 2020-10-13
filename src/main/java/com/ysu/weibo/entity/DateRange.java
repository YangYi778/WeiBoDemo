package com.ysu.weibo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * Created by 万恶de亚撒西 on 2020/10/13.
 */
@Data
@AllArgsConstructor
public class DateRange {
    private Integer startDate;
    private Integer endDate;
}
