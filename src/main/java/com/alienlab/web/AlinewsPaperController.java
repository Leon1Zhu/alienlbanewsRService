package com.alienlab.web;

import com.alibaba.fastjson.JSONArray;
import com.alienlab.domain.AlinewsPaperType;
import com.alienlab.service.AlinewsPaperService;
import com.alienlab.service.AlinewsPaperTypeService;
import com.alienlab.util.ExecResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity getAllPaperTypeAndInfo(){
        try {
           List<AlinewsPaperType> alinewsPaperTypes = alinewsPaperTypeService.getAllType();
            JSONArray ja = alinewsPaperService.findAllTypeAndPaperByList(alinewsPaperTypes);
            return ResponseEntity.ok().body(ja);
        } catch (Exception e) {
            e.printStackTrace();
            ExecResult er=new ExecResult(false,e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(er);
        }
    }

}
