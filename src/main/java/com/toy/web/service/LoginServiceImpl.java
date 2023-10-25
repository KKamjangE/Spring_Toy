package com.toy.web.service;

import com.toy.web.dto.User;
import com.toy.web.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{

    private final LoginRepository loginRepository;

    @Autowired
    public LoginServiceImpl(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public User loginCheck(String userId, String password) {
        return null;
    }

    @Override
    public User findByUserId(String userId) {
        return loginRepository.findByUserId(userId);
    }

    @Override
    public void join(User user) {
        loginRepository.save(user);
    }
}
