package com.alienlab.web;

import com.alibaba.fastjson.JSONObject;
import com.alienlab.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuliang on 2017/4/5.
 */
@RestController
public class tokenController {
    @Value("${jwt.TTLMillis}")
    private Long TTLMillis;
    @Value("${jwt.audience}")
    private String audience;
    @Value("${jwt.base64Security}")
    private String base64Security;

    @RequestMapping(value="/getToken",method = RequestMethod.POST)
    public ResponseEntity test(){
       String token = JwtUtils.createJWT("zhuliang","123456","",audience,"test",TTLMillis,base64Security);
        JSONObject jo = new JSONObject();
        jo.put("token",token);
       return  ResponseEntity.ok().body(jo);
    }
}
