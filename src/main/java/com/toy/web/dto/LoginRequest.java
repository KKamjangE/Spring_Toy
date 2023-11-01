package com.toy.web.dto;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "users")
public class LoginRequest {
    private String userId;
    private String password;
}
