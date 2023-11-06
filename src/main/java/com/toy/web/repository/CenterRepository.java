package com.toy.web.repository;

import com.toy.web.dto.CenterRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CenterRepository extends MongoRepository<CenterRequest, String> {
}
