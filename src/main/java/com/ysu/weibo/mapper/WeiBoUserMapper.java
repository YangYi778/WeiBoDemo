package com.ysu.weibo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ysu.weibo.entity.DateRange;
import com.ysu.weibo.entity.WeiBoUser;
import com.ysu.weibo.vo.ProvinceVO;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

/**
 * Created by 万恶de亚撒西 on 2020/10/10.
 */
public interface WeiBoUserMapper extends BaseMapper<WeiBoUser> {
    @Select("select province,count(province) as count from wei_bo_user GROUP BY province")
    public List<ProvinceVO> findAllProvinceDataVO();

    @Select("SELECT count(*) FROM wei_bo_user WHERE created_at BETWEEN DATE_SUB(NOW(),INTERVAL #{endDate} YEAR) AND DATE_SUB(NOW() ,INTERVAL #{startDate} YEAR)")
    public Integer findWeiBoAge(DateRange dateRang);
}
