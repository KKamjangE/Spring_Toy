package com.toy.web.service;

import com.toy.web.dto.TestData;

import java.util.List;

public interface TestService {
    TestData createTestData(TestData testData);
    List<TestData> getAllTestData();
    TestData getDataById(String id);
    void deleteTestDataById(String id);
}
