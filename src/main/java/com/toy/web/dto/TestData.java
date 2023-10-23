package com.toy.web.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "test")
public class TestData {
    @Id
    private String id;

    private int page;

    private int perPage;
}
