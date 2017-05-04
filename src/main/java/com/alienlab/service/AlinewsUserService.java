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

    AlinewsUsers login(String username,String password)throws Exception;

    AlinewsUsers regist(String username,String password,String tel,String email,String imgurl,String resource)throws  Exception;
}
