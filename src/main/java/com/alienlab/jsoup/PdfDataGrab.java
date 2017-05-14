package com.alienlab.jsoup;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alienlab.domain.AlinewsPaper;
import com.alienlab.service.AlinewsPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Size;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Msater Zg on 2017/5/3.
 * 执行下载的方法
 */
@Component
public class PdfDataGrab {
    @Autowired
    private JsoupAsyncMethod jsoupAsyncMethod;

    @Autowired
    private AlinewsPaperService alinewsPaperService;

    @Value("${dummypath}")
    private String dummypath;
    public static JSONArray jsonArrayAllData = new JSONArray();

    public JSONArray getPdfUrl()  {
        List<AlinewsPaper> alinewsPapers = null;
        try {
            System.out.println(alinewsPaperService);
            alinewsPapers = alinewsPaperService.findAllRecommend();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(alinewsPapers==null){
            System.out.println("出错啦");
            return new JSONArray();
        }
        SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd");
        List<String> newsName=new ArrayList<>();
        List<String> newsUrl = new ArrayList<>();
       for (int i=0;i<5;i++){
          /* for (int i=0;i<alinewsPapers.size();i++){*/
           /*paper.put("id", alinewsPaper.getId());
           paper.put("paperName", alinewsPaper.getPaperName());
           paper.put("paperUrl", alinewsPaper.getPaperUrl());
           paper.put("paperStatus", alinewsPaper.getPaperStatus());
           paper.put("collectCount", alinewsPaper.getCollectCount());
           paper.put("createTime", alinewsPaper.getCreateTime());
           paper.put("picUrl", alinewsPaper.getPicUrl());
           paper.put("isCollect", false);
           paper.put("paperinfolist", getPaperInfoByPaperId(alinewsPaper.getId()));*/
           String oldTime  = alinewsPapers.get(i).getUpdateTime();
           oldTime = oldTime==null? "":oldTime;
           String newTime = smf.format(new Date());
           if(!oldTime.equals(newTime)){
               System.out.println(alinewsPapers.get(i).getPaperUrl());
               newsName.add(alinewsPapers.get(i).getPaperName());
               newsUrl.add(alinewsPapers.get(i).getPaperUrl());
           }
       }
        jsoupAsyncMethod.getUrlPdf(newsName, newsUrl, dummypath);
        while (true) {
            if (jsonArrayAllData.size() == newsName.size()) {
                break;
            } else {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(jsonArrayAllData);
        return jsonArrayAllData;
    }
}
