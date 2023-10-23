package com.toy.web.repository;

import com.toy.web.domain.TestData;
import org.springframework.data.mongodb.repository.MongoRepository;

// MongoRepository<Collection과 매핑된 엔티티, 엔티티의 고유 식별자>
// 기본적인 CRUD(Create, Read, Update, Delete) 메서드가 상속된다
public interface TestRepository extends MongoRepository<TestData, String> {

}
