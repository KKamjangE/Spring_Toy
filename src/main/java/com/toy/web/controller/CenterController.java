package com.toy.web.controller;

import com.toy.web.dto.CenterRequest;
import com.toy.web.response.*;
import com.toy.web.service.CenterService;
import com.toy.web.service.JsonWebTokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<Response.Body> getCenters(@RequestHeader("Authorization") String authorizationHeader) {
        String userName = jsonWebTokenService.checkToken(authorizationHeader.split(" ")[1]);

        List<CenterRequest> allCenters = centerService.findAllCenters(userName);

        return new ResponseSuccess().success(allCenters);
    }

    @PostMapping
    public ResponseEntity<Response.Body> postCenter(@RequestHeader("Authorization") String authorizationHeader, @RequestBody CenterRequest centerRequest) {
        String userName = jsonWebTokenService.checkToken(authorizationHeader.split(" ")[1]);

        CenterRequest checkCenter = centerService.findByUserNameAndId(userName, centerRequest.getId());
        if (checkCenter == null) {
            centerRequest.setUserName(userName);
            centerService.saveCenter(centerRequest);
        } else {
            Map<String, Object> response = new HashMap<>();
            response.put("code", Result.ALREADY_CREATED.getCode());
            response.put("msg", Result.ALREADY_CREATED.getDescription());
            return new ResponseSuccess(response).success();
        }

        return new ResponseSuccess().success();
    }

    @DeleteMapping
    public ResponseEntity<Response.Body> deleteCenter(@RequestHeader("Authorization") String authorizationHeader, @RequestParam String idx) {
        String userName = jsonWebTokenService.checkToken(authorizationHeader.split(" ")[1]);

        CenterRequest centerCheck = centerService.findByUserNameAndId(userName, idx);
        if (centerCheck == null) {
            Map<String, Object> response = new HashMap<>();
            response.put("code", Result.NOT_FOUND.getCode());
            response.put("msg", Result.NOT_FOUND.getDescription());
            return new ResponseSuccess(response).success();
        } else {
            CenterRequest centerRequest = centerService.deleteCenter(userName, idx);
        }
        return new ResponseSuccess().success();
    }
}
