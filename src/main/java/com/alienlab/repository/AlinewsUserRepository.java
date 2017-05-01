package com.alienlab.repository;

import com.alienlab.domain.AlinewsUsers;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by zhuliang on 2017/4/30.
 */
@Repository
public interface AlinewsUserRepository extends MongoRepository<AlinewsUsers,String>{
}
