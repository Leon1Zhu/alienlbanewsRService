package com.alienlab.web;

import com.alibaba.fastjson.JSONArray;
import com.alienlab.domain.AlinewsPaperType;
import com.alienlab.service.AlinewsPaperService;
import com.alienlab.service.AlinewsPaperTypeService;
import com.alienlab.util.ExecResult;
import com.alienlab.util.HttpRequest;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by zhuliang on 2017/5/1.
 */
@RestController
@RequestMapping("/api")
public class AlinewsPaperController {
    @Autowired
    private AlinewsPaperTypeService alinewsPaperTypeService;
    @Autowired
    private AlinewsPaperService alinewsPaperService;

    @GetMapping("/alinews-paper")
    @ApiOperation(value="获取所有报纸种类以及类别下面的报纸信息",notes="获取所有报纸种类以及类别下面的报纸信息。")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "loginflag", value = "是否登陆的flag",  dataType = "Boolean"),
            @ApiImplicitParam(name = "userid", value = "用户id",  dataType = "String"),
    })
    public ResponseEntity getAllPaperTypeAndInfo(@RequestParam boolean loginflag,@RequestParam String userid){
        try {
           List<AlinewsPaperType> alinewsPaperTypes = alinewsPaperTypeService.getAllType();
            JSONArray ja = alinewsPaperService.findAllTypeAndPaperByList(alinewsPaperTypes,loginflag,userid);
            return ResponseEntity.ok().body(ja);
        } catch (Exception e) {
            e.printStackTrace();
            ExecResult er=new ExecResult(false,e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(er);
        }
    }

 /*   @GetMapping("/alinews-paper/recommend")
    @ApiOperation(value="获取报纸推荐列表",notes="获取报纸推荐列表")
    public ResponseEntity getAllPaperRecommend(){
        try {
            List<AlinewsPaperType> alinewsPaperTypes = alinewsPaperTypeService.findAllRecommend();
            JSONArray ja = alinewsPaperService.findAllTypeAndPaperByList(alinewsPaperTypes);
            return ResponseEntity.ok().body(ja);
        } catch (Exception e) {
            e.printStackTrace();
            ExecResult er=new ExecResult(false,e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(er);
        }
    }*/

    @GetMapping("/alinews-paper/news")
    @ApiOperation(value="获取今日头条",notes="获取今日头条")
    public ResponseEntity getAllPaperNews(@RequestParam String type){
        try {
            String result =  HttpRequest.sendGet("http://v.juhe.cn/toutiao/index","type="+type+"&key=bcfb13764084bc734f2bc6b23e339633");
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            e.printStackTrace();
            ExecResult er=new ExecResult(false,e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(er);
        }
    }

}
