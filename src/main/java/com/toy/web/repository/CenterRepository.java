package com.toy.web.repository;

import com.toy.web.dto.CenterRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CenterRepository extends MongoRepository<CenterRequest, String> {
    List<CenterRequest> findAllByUserName(String userName);
    CenterRequest findByUserNameAndId(String userName, String id);

    CenterRequest deleteByUserNameAndId(String userName, String id);
}
