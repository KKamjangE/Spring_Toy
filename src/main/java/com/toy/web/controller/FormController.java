package com.toy.web.controller;

import com.toy.web.dto.TestData;
import com.toy.web.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/center") // url 주소 매핑
public class FormController {

    private final TestService testService;

    @Autowired
    public FormController(TestService testService) {
        this.testService = testService;
    }

    @PostMapping
    public TestData submit(TestData testData) { // Domain을 생성하면 Boot가 자동으로 쿼리스트링과 연결해준다
        System.out.println("testData = " + testData);
        return testService.createTestData(testData);
    }
}
