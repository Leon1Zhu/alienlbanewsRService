package com.alienlab.service.serviceImpl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alienlab.domain.AlinewsCollect;
import com.alienlab.domain.AlinewsPaper;
import com.alienlab.domain.AlinewsPaperInfo;
import com.alienlab.domain.AlinewsPaperType;
import com.alienlab.repository.AlinewsPaperRepository;
import com.alienlab.service.AlinewsCollectService;
import com.alienlab.service.AlinewsPaperService;
import com.mongodb.DBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuliang on 2017/5/1.
 */
@Service
public class AlinewsPaperServiceImpl implements AlinewsPaperService{
    @Autowired
    private AlinewsPaperRepository alinewsPaperRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private AlinewsCollectService alinewsCollectService;
    @Override
    public JSONArray findAllTypeAndPaperByList(List<AlinewsPaperType> tyepList,Boolean loginflag,String userid) throws Exception {
        JSONArray result = new JSONArray();
        List<AlinewsCollect> alinewsCollects = new ArrayList<AlinewsCollect>();
        if(loginflag) alinewsCollects =  alinewsCollectService.getAllCollectByUserId(userid);
        else  alinewsCollects=new ArrayList<>();
        int i = 0, len = tyepList.size();
        for (; i < len; i++) {
            List<AlinewsPaper> alinewsPapers = alinewsPaperRepository.findPaperByPaperType(tyepList.get(i).getTypeName());
            if (alinewsPapers == null) {
                alinewsPapers = new ArrayList<>();
            }
            JSONArray papers = new JSONArray();
            JSONObject paper;
            for (int T = 0; T < alinewsPapers.size(); T++) {
                paper = new JSONObject();
                paper= getPaperInfo(alinewsPapers.get(T));
                for(AlinewsCollect alinewsCollect :alinewsCollects){
                    if(alinewsCollect.getPaperId().equals(paper.getString("id"))){
                        paper.put("isCollect", true);
                    }
                }
                papers.add(paper);

            }
            JSONObject jo = new JSONObject();
            jo.put("typeName", tyepList.get(i).getTypeName());
            jo.put("papers", papers);
            result.add(jo);
        }
            return result;
        }

    @Override
    public JSONArray findAllRecommend() throws Exception {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.sort(Sort.Direction.DESC,"collectCount"),
                Aggregation.limit(6)
        );
        AggregationResults<AlinewsPaper> aggRes = mongoTemplate.aggregate(aggregation,"alinewsPaper",AlinewsPaper.class);
        List<AlinewsPaper> alinewsPapers = aggRes.getMappedResults();
        JSONArray papers = new JSONArray();
        JSONObject paper;
        for (int T = 0; T < alinewsPapers.size(); T++) {
            paper = new JSONObject();
            paper= getPaperInfo(alinewsPapers.get(T));
            papers.add(paper);

        }
        return papers;
    }

    //获取一份报纸的相关数据
    public JSONObject getPaperInfo(AlinewsPaper alinewsPaper){
        JSONObject paper = new JSONObject();
        paper.put("id", alinewsPaper.getId());
        paper.put("paperName", alinewsPaper.getPaperName());
        paper.put("paperUrl", alinewsPaper.getPaperUrl());
        paper.put("paperStatus", alinewsPaper.getPaperStatus());
        paper.put("collectCount", alinewsPaper.getCollectCount());
        paper.put("createTime", alinewsPaper.getCreateTime());
        paper.put("picUrl", alinewsPaper.getPicUrl());
        paper.put("isCollect", false);
        paper.put("paperinfolist", getPaperInfoByPaperId(alinewsPaper.getId()));
        return paper;
    }


    //获取每一份报纸当前的期刊数目
    public List<AlinewsPaperInfo> getPaperInfoByPaperId(String paperId){
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("paperId").is(paperId)),
                Aggregation.group("paperId","updateTime").sum("paperId").as("paperInfoCount"),
                Aggregation.sort(Sort.Direction.DESC,"updateTime")
        );

        AggregationResults<AlinewsPaperInfo> aggRes = mongoTemplate.aggregate(aggregation, "alinewsPaperInfo",  AlinewsPaperInfo.class);
        List<AlinewsPaperInfo> listRes = aggRes.getMappedResults();
        for(int i =0;i<listRes.size();i++){
            System.out.println(listRes.get(i));
        }
        return listRes;
    }




}
