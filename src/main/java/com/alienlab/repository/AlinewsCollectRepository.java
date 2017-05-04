package com.alienlab.repository;

import com.alienlab.domain.AlinewsCollect;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhuliang on 2017/5/1.
 */
@Repository
public interface AlinewsCollectRepository extends MongoRepository<AlinewsCollect,String> {
    AlinewsCollect findCollectByUserIdAndPaperId(String userId,String paperId);
    List<AlinewsCollect> findCollectByUserId(String userId);
}
