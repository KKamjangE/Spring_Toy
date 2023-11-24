package com.toy.web.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "centers")
public class CenterRequest {
    @Id
    private String _id;

    private String id;
    private String userName;
    private String address;
    private String centerName;
    private String updatedAt;
    private float lat;
    private float lng;
    private String phoneNumber;
    private String centerType;
}
