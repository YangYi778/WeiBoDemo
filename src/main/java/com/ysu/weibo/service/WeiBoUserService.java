package com.ysu.weibo.service;

import com.ysu.weibo.entity.WeiBoUser;
import com.ysu.weibo.vo.DataVO;
import com.ysu.weibo.vo.PieVO;

/**
 * Created by 万恶de亚撒西 on 2020/10/10.
 */
public interface WeiBoUserService {
    public DataVO<WeiBoUser> findData(Integer page, Integer limit);
    public List<PieVO> getPieVO();
}
