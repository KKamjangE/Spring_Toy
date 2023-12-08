package com.toy.web.controller;

import com.toy.web.dto.JoinRequest;
import com.toy.web.dto.LoginRequest;
import com.toy.web.response.*;
import com.toy.web.service.JsonWebTokenService;
import com.toy.web.service.UserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/sign")
public class UserController {

    private final UserService userService;

    private final JsonWebTokenService jsonWebTokenService;

    @Autowired
    public UserController(UserService userService, JsonWebTokenService jsonWebTokenService) {
        this.userService = userService;
        this.jsonWebTokenService = jsonWebTokenService;
    }

    @PostMapping("/in")
    public ResponseEntity<Object>  signIn(@RequestBody LoginRequest loginRequest) { // 로그인
        JoinRequest userInfo = userService.loginCheck(loginRequest);

        if(userInfo == null) {
            return new ResponseEntity<>(ResponseData.res(Result.SIGN_IN_MATCH_FAIL.getCode(), Result.SIGN_IN_MATCH_FAIL.getDescription()), HttpStatus.CONFLICT);
        }

        String token = jsonWebTokenService.generateToken(loginRequest.getUserId());
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("jwt", token);
        responseBody.put("userName", userInfo.getName());
        return new ResponseEntity<>(ResponseData.res(Result.SUCCESS.getCode(), Result.SUCCESS.getDescription(), responseBody), HttpStatus.OK);
    }

    @PostMapping("/up")
    public ResponseEntity<Object> signUp(@RequestBody JoinRequest joinRequest) { // 회원가입
        System.out.println("joinRequest = " + joinRequest);
        JoinRequest checkJoinRequest = userService.findByUserId(joinRequest.getUserId());
        String encodedPassword = BCrypt.hashpw(joinRequest.getPassword(), BCrypt.gensalt());
        joinRequest.setPassword(encodedPassword);

        if(checkJoinRequest == null) {
            userService.join(joinRequest);
            return new ResponseEntity<>(ResponseData.res(Result.SUCCESS.getCode(), Result.SUCCESS.getDescription()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(ResponseData.res(Result.SIGN_UP_ALREADY_ID.getCode(), Result.SIGN_UP_ALREADY_ID.getDescription()), HttpStatus.CONFLICT);
        }

    }
}
