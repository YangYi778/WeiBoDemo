package com.ysu.weibo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ysu.weibo.entity.WeiBoUser;
import com.ysu.weibo.mapper.WeiBoUserMapper;
import com.ysu.weibo.service.WeiBoUserService;
import com.ysu.weibo.vo.DataVO;
import com.ysu.weibo.vo.PieVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 万恶de亚撒西 on 2020/10/10.
 */
@Service
public class WeiBoUserServiceImpl implements WeiBoUserService {

    @Autowired
    private WeiBoUserMapper weiBoUserMapper;

    @Override
    public DataVO<WeiBoUser> findData(Integer page, Integer limit) {
        DataVO dataVO = new DataVO();
        dataVO.setCode(0);
        dataVO.setMsg("");

        IPage<WeiBoUser> weiBoUserIPage = new Page<>(page, limit);
        IPage<WeiBoUser> result = weiBoUserMapper.selectPage(weiBoUserIPage, null);
        dataVO.setCount(result.getTotal());
        dataVO.setData(result.getRecords());

        return dataVO;
    }

    @Override
    public List<PieVO> getPieVO() {
        List<PieVO> pieVOList= pieVOList.stream();
               .map(e->new PieVO(
                       e.get
        ))
        return null;
    }
}
