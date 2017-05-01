package com.alienlab.service;

import com.alibaba.fastjson.JSONArray;
import com.alienlab.domain.AlinewsUsers;

import java.util.List;

/**
 * Created by zhuliang on 2017/4/30.
 */
public interface AlinewsUserService {
    List<AlinewsUsers> findALLUser();
    AlinewsUsers save(AlinewsUsers alinewsUsers);
}
