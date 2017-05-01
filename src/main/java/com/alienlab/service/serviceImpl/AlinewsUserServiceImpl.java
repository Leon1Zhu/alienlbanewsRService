package com.alienlab.service.serviceImpl;

import com.alibaba.fastjson.JSONArray;
import com.alienlab.domain.AlinewsUsers;
import com.alienlab.repository.AlinewsUserRepository;
import com.alienlab.service.AlinewsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhuliang on 2017/4/30.
 */
@Service
public class AlinewsUserServiceImpl implements AlinewsUserService {
    @Autowired
    private AlinewsUserRepository alinewsUserRepository;

    @Override
    public List<AlinewsUsers> findALLUser() {
        List<AlinewsUsers> alinewsUserss= alinewsUserRepository.findAll();
        return alinewsUserss;
    }

    @Override
    public AlinewsUsers save(AlinewsUsers alinewsUsers) {
        return alinewsUserRepository.save(alinewsUsers);
    }
}
