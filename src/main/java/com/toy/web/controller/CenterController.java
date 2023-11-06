package com.toy.web.controller;

import com.toy.web.dto.CenterRequest;
import com.toy.web.response.ResponseData;
import com.toy.web.response.ResponseMessage;
import com.toy.web.response.StatusCode;
import com.toy.web.service.CenterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/center")
public class CenterController {

    private final CenterService centerService;

    public CenterController(CenterService centerService) {
        this.centerService = centerService;
    }

    @GetMapping
    public ResponseEntity<ResponseData> getCenters() {
        List<CenterRequest> allCenters = centerService.findAllCenters();
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("centers", allCenters);
        return new ResponseEntity<>(ResponseData.res(StatusCode.OK, ResponseMessage.GET_CENTERS_SUCCESS, responseBody), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseData> postCenter() {
        return new ResponseEntity<>(ResponseData.res(StatusCode.OK, ResponseMessage.POST_CENTER_SUCCESS), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<ResponseData> deleteCenter() {
        return new ResponseEntity<>(ResponseData.res(StatusCode.OK, ResponseMessage.DELETE_CENTER_SUCCESS), HttpStatus.OK);
    }
}
