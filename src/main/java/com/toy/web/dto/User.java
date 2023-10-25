package com.toy.web.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "users") // 해당 collection에 연결
public class User { // 회원 정보 DTO
    @Id
    private String userId;

    private String password;
    private String name;
}
