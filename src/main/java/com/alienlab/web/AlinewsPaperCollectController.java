package com.alienlab.web;

import com.alienlab.domain.AlinewsCollect;
import com.alienlab.service.AlinewsCollectService;
import com.alienlab.util.ExecResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by zhuliang on 2017/5/4.
 */
@RestController
@RequestMapping("/api")
public class AlinewsPaperCollectController {
    @Autowired
    private AlinewsCollectService alinewsCollectService;
    @GetMapping("/alinews-collects")
    @ApiOperation(value="获取当前登录人的所有收藏报纸",notes="获取当前登录人的所有收藏报纸。")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userid", value = "用户openid",  dataType = "String"),
    })
    public ResponseEntity getCollects(@RequestParam String userid){
        try {
            List<AlinewsCollect> alinewsCollects = alinewsCollectService.getAllCollectByUserId(userid);
            return ResponseEntity.ok().body(alinewsCollects);
        }catch (Exception e){
            e.printStackTrace();
            ExecResult er=new ExecResult(false,e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(er);
        }
    }
    @PostMapping("/alinews-collects")
    @ApiOperation(value="新增收藏报纸",notes="新增收藏报纸。")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userid", value = "用户openid",  dataType = "String"),
            @ApiImplicitParam(name = "paperId", value = "报纸id",  dataType = "String"),
    })
    public ResponseEntity addCollects(@RequestParam String userid,@RequestParam String paperId){
        try {
           AlinewsCollect alinewsCollect = alinewsCollectService.addCollect(userid,paperId);
            return ResponseEntity.ok().body(alinewsCollect);
        }catch (Exception e){
            e.printStackTrace();
            ExecResult er=new ExecResult(false,e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(er);
        }
    }
    @DeleteMapping("/alinews-collects")
    @ApiOperation(value="取消收藏报纸",notes="取消收藏报纸。")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userid", value = "用户openid",  dataType = "String"),
            @ApiImplicitParam(name = "collectId", value = "收藏id",  dataType = "String"),
    })
    public ResponseEntity deleteCollects(@RequestParam String userid,@RequestParam String collectId){
        try {
            alinewsCollectService.deleteCollect(userid,collectId);
            return ResponseEntity.ok().body("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            ExecResult er=new ExecResult(false,e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(er);
        }
    }
}
