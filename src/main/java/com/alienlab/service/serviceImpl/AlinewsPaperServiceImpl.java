package com.alienlab.service.serviceImpl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alienlab.domain.AlinewsPaper;
import com.alienlab.domain.AlinewsPaperType;
import com.alienlab.repository.AlinewsPaperRepository;
import com.alienlab.service.AlinewsPaperService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Override
    public JSONArray findAllTypeAndPaperByList(List<AlinewsPaperType> tyepList) throws Exception {
        JSONArray result = new JSONArray();
        int i=0,len=tyepList.size();
        for (;i<len;i++){
            List<AlinewsPaper> alinewsPapers = alinewsPaperRepository.findPaperByPaperType(tyepList.get(i).getTypeName());
            if(alinewsPapers==null){
                alinewsPapers = new ArrayList<>();
            }
            JSONObject jo = new JSONObject();
            jo.put("typeName",tyepList.get(i).getTypeName());
            jo.put("papers",alinewsPapers);
            result.add(jo);
        }
        return result;
    }
}
