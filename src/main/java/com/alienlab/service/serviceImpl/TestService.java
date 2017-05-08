package com.alienlab.service.serviceImpl;

import com.alienlab.domain.AlinewsPaper;
import com.alienlab.domain.AlinewsUsers;
import com.alienlab.repository.AlinewsPaperRepository;
import com.alienlab.repository.AlinewsUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by zhuliang on 2017/5/5.
 */
@Service
public class TestService {
    @Autowired
    private AlinewsUserRepository alinewsUserRepository;
    @Autowired
    private AlinewsPaperRepository alinewsPaperRepository;
    @Async
    public void run(int t){
    }
}
