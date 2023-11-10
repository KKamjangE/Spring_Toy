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
        return new ResponseEntity<>(ResponseData.res(StatusCode.OK, ResponseMessage.GET_CENTERS_SUCCESS, allCenters), HttpStatus.OK);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<ResponseData> postCenter(@RequestBody CenterRequest centerRequest) {
        centerService.saveCenter(centerRequest);
        return new ResponseEntity<>(ResponseData.res(StatusCode.OK, ResponseMessage.POST_CENTER_SUCCESS, centerRequest), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<ResponseData> deleteCenter(@RequestParam String idx) {
        centerService.deleteCenter(idx);
        return new ResponseEntity<>(ResponseData.res(StatusCode.OK, ResponseMessage.DELETE_CENTER_SUCCESS), HttpStatus.OK);
    }
}
