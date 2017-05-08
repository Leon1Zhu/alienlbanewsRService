package com.alienlab.service;

import com.alibaba.fastjson.JSONArray;
import com.alienlab.domain.AlinewsCollect;
import com.alienlab.domain.AlinewsPaper;

import java.util.List;

/**
 * Created by zhuliang on 2017/5/1.
 */
public interface AlinewsCollectService {
    List<AlinewsCollect> getAllCollectByUserId(String userid) throws Exception;
    AlinewsCollect addCollect(String userId, String paperId)throws Exception;
    AlinewsPaper deleteCollect(String userid, String paperId)throws Exception;
    JSONArray getAllCollectPaperByUserId(String userid) throws Exception;
}
