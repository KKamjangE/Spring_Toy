package com.toy.web.service;

import com.toy.web.dto.JoinRequest;
import com.toy.web.dto.LoginRequest;

public interface UserService {
    JoinRequest loginCheck(LoginRequest loginRequest);
    JoinRequest findByUserId(String userId);
    void join(JoinRequest joinRequest);
}
