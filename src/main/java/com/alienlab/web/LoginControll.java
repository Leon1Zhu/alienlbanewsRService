package com.alienlab.web;

import com.alienlab.domain.AlinewsUsers;
import com.alienlab.service.AlinewsUserService;
import com.alienlab.service.serviceImpl.TestService;
import com.alienlab.util.ExecResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zhuliang on 2017/5/4.
 */
@RestController
@RequestMapping("/api")
public class LoginControll {
    @Autowired
    private AlinewsUserService alinewsUserService;

    @Autowired
    private TestService testService;

    @PostMapping("/user-login")
    @ApiOperation(value="登陆",notes="登陆。")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "loginname", value = "用户名",  dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码",  dataType = "String"),
    })
    public ResponseEntity userLogin(@RequestParam String loginname, @RequestParam String password){
        try {
            AlinewsUsers alinewsUsers = alinewsUserService.login(loginname, password);
            return ResponseEntity.ok().body(alinewsUsers);
        }catch (Exception e){
            e.printStackTrace();
            ExecResult er=new ExecResult(false,e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(er);
        }
    }

    @PostMapping("/user-regist/third")
    @ApiOperation(value="注册和第三方登陆接口",notes="注册和第三方登陆接口。")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "loginname", value = "用户名",  dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码",  dataType = "String"),
            @ApiImplicitParam(name = "tel", value = "电话",  dataType = "String"),
            @ApiImplicitParam(name = "email", value = "邮箱",  dataType = "String"),
            @ApiImplicitParam(name = "imgurl", value = "头像",  dataType = "String"),
            @ApiImplicitParam(name = "resource", value = "来源",  dataType = "String"),
            @ApiImplicitParam(name = "nickname", value = "昵称",  dataType = "String"),
    })
    public ResponseEntity userRegist(@RequestParam String loginname, @RequestParam String password, @RequestParam String tel,@RequestParam String email ,@RequestParam String imgurl,@RequestParam String resource,@RequestParam String nickname){
        try {
            AlinewsUsers alinewsUsers = alinewsUserService.regist(loginname, password, tel, email, imgurl, resource,nickname);
            return ResponseEntity.ok().body(alinewsUsers);
        }catch (Exception e){
            e.printStackTrace();
            ExecResult er=new ExecResult(false,e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(er);
        }
    }


 /*   @GetMapping("/testApi")
    public void testApi(){
        for(int i=0;i<5;i++){
            testService.run(i);
        }
    }*/
}
