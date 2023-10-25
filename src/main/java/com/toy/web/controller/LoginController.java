package com.toy.web.controller;

import com.toy.web.dto.User;
import com.toy.web.response.ResponseData;
import com.toy.web.response.ResponseMessage;
import com.toy.web.response.StatusCode;
import com.toy.web.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sign")
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/in")
    public String signIn() { // 로그인
        return "login";
    }

    @PostMapping("/up")
    public ResponseEntity<ResponseData> signUp(User user) { // 회원가입

        User checkUser = loginService.findByUserId(user.getUserId());

        if(checkUser == null) {
            loginService.join(user);
            return new ResponseEntity<>(ResponseData.res(StatusCode.OK, ResponseMessage.SIGN_UP_SUCCESS), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(ResponseData.res(StatusCode.CONFLICT, ResponseMessage.ALREADY_USER), HttpStatus.OK);
        }

    }
}
