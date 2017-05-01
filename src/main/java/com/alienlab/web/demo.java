package com.alienlab.web;

import com.alienlab.domain.AlinewsUsers;
import com.alienlab.service.serviceImpl.AlinewsUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuliang on 2017/4/3.
 */
@RestController
public class demo {
    @Autowired
    private AlinewsUserServiceImpl alinewsUserServiceImpl;
    @RequestMapping(value="/test",method = RequestMethod.GET)
    public ResponseEntity test(){
        List<AlinewsUsers> alinewsUserss = alinewsUserServiceImpl.findALLUser();
        return  ResponseEntity.ok().body(alinewsUserss);
    }

    @RequestMapping(value="/save",method = RequestMethod.GET)
    public ResponseEntity save(@RequestParam String name,@RequestParam String password,@RequestParam String tel,@RequestParam String email,@RequestParam String resource){
        AlinewsUsers alinewsUsers = new AlinewsUsers();
        alinewsUsers.setUserName(name);
        alinewsUsers.setUserPassword(password);
        alinewsUsers.setTel(tel);
        alinewsUsers.setEmail(email);
        alinewsUsers.setSource(resource);
        alinewsUsers = alinewsUserServiceImpl.save(alinewsUsers);
        return  ResponseEntity.ok().body(alinewsUsers);
    }

}
