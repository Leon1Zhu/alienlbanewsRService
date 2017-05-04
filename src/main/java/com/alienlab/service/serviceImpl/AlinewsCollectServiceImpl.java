package com.alienlab.service.serviceImpl;

import com.alienlab.domain.AlinewsCollect;
import com.alienlab.repository.AlinewsCollectRepository;
import com.alienlab.service.AlinewsCollectService;
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
        return alinewsCollect;
    }

    @Override
    public void deleteCollect(String userid, String collectId)throws Exception {
        AlinewsCollect alinewsCollect = alinewsCollectRepository.findOne(collectId);
        if(alinewsCollect==null){
           throw new Exception("您还没有收藏过该报纸，无法删除！");
        }
        alinewsCollectRepository.delete(alinewsCollect);
    }
}
