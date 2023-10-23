package com.toy.web.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collation = "test")
public class TestData {
    @Id
    private String id;

    private int page;

    private int perPage;
}
