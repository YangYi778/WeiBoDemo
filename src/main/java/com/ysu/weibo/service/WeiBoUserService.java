package com.ysu.weibo.service;

import com.ysu.weibo.entity.DateRange;
import com.ysu.weibo.entity.WeiBoAge;
import com.ysu.weibo.entity.WeiBoUser;
import com.ysu.weibo.vo.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by 万恶de亚撒西 on 2020/10/10.
 */
public interface WeiBoUserService {
    public DataVO<WeiBoUser> findData(Integer page, Integer limit);

    public ProvinceDataVO getProvinceDataVO();

    public WeiBoAgeVO findWeiBoAge();
}
