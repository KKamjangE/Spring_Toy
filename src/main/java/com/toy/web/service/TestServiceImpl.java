package com.toy.web.service;

import com.toy.web.dto.TestData;
import com.toy.web.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService{

    private final TestRepository testRepository;

    @Autowired
    public TestServiceImpl(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @Override
    public TestData createTestData(TestData testData) {
        return testRepository.save(testData);
    }

    @Override
    public List<TestData> getAllTestData() {
        return testRepository.findAll();
    }

    @Override
    public TestData getDataById(String id) {
        return testRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteTestDataById(String id) {
        testRepository.deleteById(id);
    }
}
