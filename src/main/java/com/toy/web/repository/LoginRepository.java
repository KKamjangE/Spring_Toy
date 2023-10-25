package com.toy.web.repository;

import com.toy.web.dto.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

// MongoRepository<Collection과 매핑된 엔티티, 엔티티의 고유 식별자>
// 기본적인 CRUD(Create, Read, Update, Delete) 메서드가 상속된다
@Repository
public interface LoginRepository extends MongoRepository<User, String> {
    User findByUserId(String userId); // 커스텀 메서드명을 참고하여 mongoRepository가 자동으로 쿼리를 생성해준다
}
