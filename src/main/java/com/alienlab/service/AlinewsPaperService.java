package com.alienlab.service;

import com.alibaba.fastjson.JSONArray;
import com.alienlab.domain.AlinewsPaper;
import com.alienlab.domain.AlinewsPaperType;

import java.util.List;

/**
 * Created by zhuliang on 2017/5/1.
 */
public interface AlinewsPaperService {
    JSONArray findAllTypeAndPaperByList(List<AlinewsPaperType> tyepList,Boolean loginflag,String userid) throws Exception;
    //获取热门推荐
    List<AlinewsPaper> findAllRecommend()throws Exception;
}
