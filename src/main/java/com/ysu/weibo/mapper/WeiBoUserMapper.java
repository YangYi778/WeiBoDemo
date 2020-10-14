package com.ysu.weibo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ysu.weibo.entity.*;
import com.ysu.weibo.vo.LangVO;
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

    @Select("select gender as name,count(*) as value from wei_bo_user GROUP BY gender")
    public List<Gender> findWeiBoGender();

    /*@Select("SELECT lang as name,a.cnt as value,CONCAT(ROUND(a.cnt/b.sum *100,2)) as scale " +
            "FROM (select lang,COUNT(lang) AS value FROM wei_bo_user GROUP BY langORDER BY cnt DESC) AS a," +
            "(SELECT COUNT(*) AS sum FROM wei_bo_user) AS b)")*/
    @Select("SELECT\n" +
            "\tlang AS NAME,\n" +
            "\ta.cnt AS \n" +
            "VALUE\n" +
            "\t,\n" +
            "\tCONCAT(\n" +
            "\tROUND( a.cnt / b.sum * 100, 2 )) AS scale \n" +
            "FROM\n" +
            "\t( SELECT lang, COUNT( lang ) AS cnt FROM wei_bo_user GROUP BY lang ORDER BY cnt DESC ) AS a,\n" +
            "\t( SELECT COUNT(*) AS sum FROM wei_bo_user ) AS b;")
    public List<Lang> findWeiBoLang();

    /*
    * 地区分布
    * */
    @Select("SELECT Zone1,Zone2,Zone3,Zone4,Zone5,Zone6,Zone7,Zone8,Zone9 FROM \n" +
            "(SELECT COUNT(*) AS Zone1 FROM wei_bo_user WHERE province IN (31,32,33,34,35,37,71)) a\n" +
            ",(SELECT COUNT(*) AS Zone2 FROM wei_bo_user WHERE province IN (44,45,46,81,82)) b\n" +
            ",(SELECT COUNT(*) AS Zone3 FROM wei_bo_user WHERE province IN (36,41,42,43)) c\n" +
            ",(SELECT COUNT(*) AS Zone4 FROM wei_bo_user WHERE province IN (11,12,13,14,15)) d\n" +
            ",(SELECT COUNT(*) AS Zone5 FROM wei_bo_user WHERE province IN (61,62,63,64,65)) e\n" +
            ",(SELECT COUNT(*) AS Zone6 FROM wei_bo_user WHERE province IN (50,51,52,53,54)) f\n" +
            ",(SELECT COUNT(*) AS Zone7 FROM wei_bo_user WHERE province IN (21,22,23)) g\n" +
            ",(SELECT COUNT(*) AS Zone8 FROM wei_bo_user WHERE province IN (400)) h\n" +
            ",(SELECT COUNT(*) AS Zone9 FROM wei_bo_user WHERE province IN (100)) i")
    public Zone findWeiBoZone();

}