package com.alienlab.service.serviceImpl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alienlab.domain.AlinewsCollect;
import com.alienlab.domain.AlinewsPaper;
import com.alienlab.repository.AlinewsCollectRepository;
import com.alienlab.repository.AlinewsPaperRepository;
import com.alienlab.service.AlinewsCollectService;
import com.alienlab.service.AlinewsPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Created by zhuliang on 2017/5/1.
 */
@Service
public class AlinewsCollectServiceImpl implements AlinewsCollectService{
    @Autowired
    private AlinewsCollectRepository alinewsCollectRepository;
    @Autowired
    private AlinewsPaperRepository alinewsPaperRepository;

    @Autowired
    private AlinewsPaperServiceImpl alinewsPaperServiceImpl;

    @Override
    public List<AlinewsCollect> getAllCollectByUserId(String userid) throws Exception {
        List<AlinewsCollect> alinewsCollects = alinewsCollectRepository.findCollectByUserId(userid);
        if(alinewsCollects==null){
            throw new  Exception("暂无收藏记录！");
        }
        return alinewsCollects;
    }

    @Override
    public AlinewsCollect addCollect(String userId, String paperId) throws Exception{
        AlinewsCollect alinewsCollect =alinewsCollectRepository.findCollectByUserIdAndPaperId(userId,paperId);
        if(alinewsCollect!=null){
            throw new Exception("您已收藏过该报纸！");
        }
        alinewsCollect = new AlinewsCollect();
        alinewsCollect.setPaperId(paperId);
        alinewsCollect.setUserId(userId);
        alinewsCollect.setCollectTime(new Date());
        alinewsCollect = alinewsCollectRepository.save(alinewsCollect);
        AlinewsPaper alinewsPaper = alinewsPaperRepository.findOne(paperId);
        if(alinewsPaper==null){
            throw new Exception("没有该报纸信息！");
        }
        int count =alinewsPaper.getCollectCount()+1;
        alinewsPaper.setCollectCount(count);
        alinewsPaperRepository.save(alinewsPaper);
        return alinewsCollect;
    }

    @Override
    public AlinewsPaper deleteCollect(String userid, String paperId)throws Exception {
        AlinewsCollect alinewsCollect = alinewsCollectRepository.findCollectByUserIdAndPaperId(userid, paperId);
        if(alinewsCollect==null){
           throw new Exception("您还没有收藏过该报纸，无法删除！");
        }
        alinewsCollectRepository.delete(alinewsCollect);
        AlinewsPaper alinewsPaper = alinewsPaperRepository.findOne(paperId);
        if(alinewsPaper==null){
            throw new Exception("没有该报纸信息！");
        }
        int count =alinewsPaper.getCollectCount()-1;
        alinewsPaper.setCollectCount(count);
        return alinewsPaperRepository.save(alinewsPaper);
    }

    @Override
    public JSONArray getAllCollectPaperByUserId(String userid) throws Exception {
        JSONArray result = new JSONArray();
        List<AlinewsCollect> alinewsCollects = alinewsCollectRepository.findCollectByUserId(userid);
        if(alinewsCollects==null){
            throw new Exception("您还没有收藏的报纸！");
        }
        int len = alinewsCollects.size();
        for(int i = 0 ;i<len;i++){
            AlinewsPaper alinewsPaper = alinewsPaperRepository.findOne(alinewsCollects.get(i).getPaperId());
            if(alinewsPaper==null){
                continue;
            }
            JSONObject jo = alinewsPaperServiceImpl.getPaperInfo(alinewsPaper);
            jo.put("isCollect", true);
            result.add(jo);
        }
        return result;
    }
}
