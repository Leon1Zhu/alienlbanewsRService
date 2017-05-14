package com.alienlab.service;

import com.alibaba.fastjson.JSONArray;
import com.alienlab.domain.AlinewsPaperInfo;

import java.util.List;

/**
 * Created by zhuliang on 2017/5/1.
 */
public interface AlinewsPaperInfoService {
    List<AlinewsPaperInfo> saveDoweloadPaper(String name, JSONArray ja)throws  Exception;
}
