package com.alienlab.repository;

import com.alienlab.domain.AlinewsPaperType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by zhuliang on 2017/5/1.
 */
@Repository
public interface AlinewsPaperTypeRepository extends MongoRepository<AlinewsPaperType,String>{
}
