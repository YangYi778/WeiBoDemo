package com.ysu.weibo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ysu.weibo.entity.DateRange;
import com.ysu.weibo.entity.Gender;
import com.ysu.weibo.entity.Lang;
import com.ysu.weibo.entity.WeiBoUser;
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


}