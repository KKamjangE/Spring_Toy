package com.toy.web.controller;

import com.toy.web.dto.JoinRequest;
import com.toy.web.response.ResponseData;
import com.toy.web.response.ResponseMessage;
import com.toy.web.response.StatusCode;
import com.toy.web.service.UserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sign")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/in")
    public void signIn() { // 로그인
    }

    @PostMapping("/up")
    public ResponseEntity<ResponseData> signUp(JoinRequest joinRequest) { // 회원가입

        JoinRequest checkJoinRequest = userService.findByUserId(joinRequest.getUserId());

        String encodedPassword = BCrypt.hashpw(joinRequest.getPassword(), BCrypt.gensalt());
        joinRequest.setPassword(encodedPassword);

        if(checkJoinRequest == null) {
            userService.join(joinRequest);
            return new ResponseEntity<>(ResponseData.res(StatusCode.OK, ResponseMessage.SIGN_UP_SUCCESS), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(ResponseData.res(StatusCode.CONFLICT, ResponseMessage.ALREADY_USER), HttpStatus.OK);
        }

    }
}
