package com.alienlab.service;

import com.alienlab.domain.AlinewsCollect;

import java.util.List;

/**
 * Created by zhuliang on 2017/5/1.
 */
public interface AlinewsCollectService {
    List<AlinewsCollect> getAllCollectByUserId(String userid) throws Exception;
    AlinewsCollect addCollect(String userId, String paperId)throws Exception;
    void deleteCollect(String userid,String collectId)throws Exception;
}
