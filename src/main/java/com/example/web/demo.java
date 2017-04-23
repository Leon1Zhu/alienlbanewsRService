package com.example.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuliang on 2017/4/3.
 */
@RestController
@RequestMapping("/api")
public class demo {
    @RequestMapping(value="/test",method = RequestMethod.GET)
    public ResponseEntity test(){
        List list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        return  ResponseEntity.ok().body(list);
    }

}
