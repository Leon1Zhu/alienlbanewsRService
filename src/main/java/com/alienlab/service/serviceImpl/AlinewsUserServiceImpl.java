package com.alienlab.service.serviceImpl;

import com.alibaba.fastjson.JSONArray;
import com.alienlab.domain.AlinewsUsers;
import com.alienlab.repository.AlinewsUserRepository;
import com.alienlab.service.AlinewsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    @Override
    public AlinewsUsers login(String username, String password) throws Exception {
        AlinewsUsers alinewsUsers = alinewsUserRepository.findUserByUserNameAndUserPasswordAndSource(username,password,"0");
        if(alinewsUsers==null){
            throw new Exception("用户名或密码错误！");
        }
        return alinewsUsers;
    }

    @Override
    public AlinewsUsers regist(String username, String password, String tel, String email, String imgurl, String resource,String nickname) throws Exception {
        AlinewsUsers alinewsUsers;
        if(resource.equals("0")){
            alinewsUsers = alinewsUserRepository.findUserByUserNameAndSource(username,"0");
            if(alinewsUsers!=null){
                throw new Exception("很抱歉，该用户已被注册。");
            }
            alinewsUsers = new AlinewsUsers();
            alinewsUsers.setUserName(username);
            alinewsUsers.setCreateTime(new Date());
            alinewsUsers.setEmail(email);
            alinewsUsers.setTel(tel);
            alinewsUsers.setSource(resource);
            alinewsUsers.setImgUrl(imgurl);
            alinewsUsers.setUserPassword(password);
            alinewsUsers.setNickName(nickname);
        return alinewsUserRepository.save(alinewsUsers);
        }else{
            alinewsUsers = alinewsUserRepository.findUserByUserNameAndSource(username,resource);
            if(alinewsUsers==null){
                alinewsUsers = new AlinewsUsers();
                alinewsUsers.setUserName(username);
                alinewsUsers.setCreateTime(new Date());
            }
            alinewsUsers.setEmail(email);
            alinewsUsers.setTel(tel);
            alinewsUsers.setSource(resource);
            alinewsUsers.setImgUrl(imgurl);
            alinewsUsers.setUserPassword(password);
            alinewsUsers.setNickName(nickname);
            return alinewsUserRepository.save(alinewsUsers);
        }
    }
}
