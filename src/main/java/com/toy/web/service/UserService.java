package com.toy.web.service;

import com.toy.web.dto.JoinRequest;

public interface UserService {
    JoinRequest loginCheck(String userId, String password);
    JoinRequest findByUserId(String userId);
    void join(JoinRequest joinRequest);
}
