package com.toy.web.service;

import com.toy.web.dto.User;

public interface LoginService {
    User loginCheck(String userId, String password);
    User findByUserId(String userId);
    void join(User user);
}
