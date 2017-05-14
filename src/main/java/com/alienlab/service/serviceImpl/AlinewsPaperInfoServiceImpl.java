package com.alienlab.service.serviceImpl;

import com.alibaba.fastjson.JSONArray;
import com.alienlab.domain.AlinewsPaper;
import com.alienlab.domain.AlinewsPaperInfo;
import com.alienlab.repository.AlinewsPaperInfoRepository;
import com.alienlab.repository.AlinewsPaperRepository;
import com.alienlab.service.AlinewsPaperInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zhuliang on 2017/5/1.
 */
@Service
public class AlinewsPaperInfoServiceImpl implements AlinewsPaperInfoService{
    @Autowired
    private AlinewsPaperRepository alinewsPaperRepository;
    @Autowired
    private AlinewsPaperInfoRepository alinewsPaperInfoRepository;
    @Override
    public List<AlinewsPaperInfo> saveDoweloadPaper(String name, JSONArray ja) throws Exception {
        SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd");
        AlinewsPaper alinewsPaper =  alinewsPaperRepository.findPaperBypaperName(name);
        List<AlinewsPaperInfo> alinewsPaperInfos = new  ArrayList();
        if(alinewsPaper==null){
            throw  new Exception("没有找到名称为"+name+"的报刊！");
        }
        AlinewsPaperInfo alinewsPaperInfo = null;
        for(int i = 0;i<ja.size();i++){
            alinewsPaperInfo = new AlinewsPaperInfo();
            alinewsPaperInfo.setPaperId(alinewsPaper.getId());
            alinewsPaperInfo.setCreateTime(new Date());
            alinewsPaperInfo.setUpdateTime(smf.format(new Date()));
            alinewsPaperInfo.setHtmlUrl(ja.get(i).toString());
            System.out.println("保存报纸"+name+(i)+"");
           alinewsPaperInfos.add(alinewsPaperInfoRepository.save(alinewsPaperInfo));
        }
        alinewsPaper.setUpdateTime(smf.format(new Date()));
        /*alinewsPaperRepository.save(alinewsPaper);*/
        return alinewsPaperInfos;
    }
}
