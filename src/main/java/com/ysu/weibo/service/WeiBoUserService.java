package com.ysu.weibo.service;

import com.ysu.weibo.entity.*;
import com.ysu.weibo.vo.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by 万恶de亚撒西 on 2020/10/10.
 */
public interface WeiBoUserService {
    public DataVO<WeiBoUser> findData(Integer page, Integer limit);
    public void deleteOne(String uid);

    public DataVO<ProvinceItemVO> getProvinceDataVO();

    public WeiBoAgeVO findWeiBoAge();

    public DataVO<Gender> findWeiBoGender();

    public LangVO findWeiBoLang();

    public List<ZoneVO> findWeiBoZone();

    public void deleteInvaildDate();

    public void deleteRepeat();
}
