package com.alienlab.repository;

import com.alienlab.domain.AlinewsPaperInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by zhuliang on 2017/5/1.
 */
@Repository
public interface AlinewsPaperInfoRepository extends MongoRepository<AlinewsPaperInfo,String>{

}
