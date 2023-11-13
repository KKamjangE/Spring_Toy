package com.toy.web.controller;

import com.toy.web.dto.CenterRequest;
import com.toy.web.response.ResponseData;
import com.toy.web.response.ResponseMessage;
import com.toy.web.response.StatusCode;
import com.toy.web.service.CenterService;
import com.toy.web.service.JsonWebTokenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/center")
public class CenterController {

    private final CenterService centerService;
    private final JsonWebTokenService jsonWebTokenService;

    public CenterController(CenterService centerService, JsonWebTokenService jsonWebTokenService) {
        this.centerService = centerService;
        this.jsonWebTokenService = jsonWebTokenService;
    }

    @GetMapping
    public ResponseEntity<ResponseData> getCenters(@RequestHeader("Authorization") String authorizationHeader) {
        String userName = jsonWebTokenService.checkToken(authorizationHeader.split(" ")[1]);

        List<CenterRequest> allCenters = centerService.findAllCenters(userName);

        return new ResponseEntity<>(ResponseData.res(StatusCode.OK, ResponseMessage.GET_CENTERS_SUCCESS, allCenters), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseData> postCenter(@RequestHeader("Authorization") String authorizationHeader, @RequestBody CenterRequest centerRequest) {
        String userName = jsonWebTokenService.checkToken(authorizationHeader.split(" ")[1]);

        CenterRequest checkCenter = centerService.findByUserNameAndId(userName, centerRequest.getId());
        if (checkCenter == null) {
            centerRequest.setUserName(userName);
            centerService.saveCenter(centerRequest);
            return new ResponseEntity<>(ResponseData.res(StatusCode.OK, ResponseMessage.POST_CENTER_SUCCESS, centerRequest), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(ResponseData.res(StatusCode.CONFLICT, ResponseMessage.POST_CENTER_CONFLICT, centerRequest), HttpStatus.OK);
        }
    }

    @DeleteMapping
    public ResponseEntity<ResponseData> deleteCenter(@RequestHeader("Authorization") String authorizationHeader, @RequestParam String idx) {
        String userName = jsonWebTokenService.checkToken(authorizationHeader.split(" ")[1]);

        CenterRequest centerCheck = centerService.findByUserNameAndId(userName, idx);
        System.out.println("centerCheck = " + centerCheck);
        if (centerCheck == null) {
            return new ResponseEntity<>(ResponseData.res(StatusCode.NOT_FOUND, ResponseMessage.DELETE_CENTER_FAIL, idx), HttpStatus.OK);
        } else {
            CenterRequest centerRequest = centerService.deleteCenter(userName, idx);
            return new ResponseEntity<>(ResponseData.res(StatusCode.OK, ResponseMessage.DELETE_CENTER_SUCCESS, centerRequest), HttpStatus.OK);
        }
    }
}
