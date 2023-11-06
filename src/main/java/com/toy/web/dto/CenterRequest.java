package com.toy.web.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "centers")
public class CenterRequest {
    @Id
    private String id;

    private String address;
    private String centerName;
    private String updatedAt;
}
