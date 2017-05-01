package com.alienlab.repository;

import com.alienlab.domain.AlinewsMessage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by zhuliang on 2017/5/1.
 */
@Repository
public interface AlinewsMessageRepository extends MongoRepository<AlinewsMessage,String>{
}
