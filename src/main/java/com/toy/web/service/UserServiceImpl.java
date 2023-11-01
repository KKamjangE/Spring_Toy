package com.toy.web.service;

import com.toy.web.dto.JoinRequest;
import com.toy.web.dto.LoginRequest;
import com.toy.web.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String loginCheck(LoginRequest loginRequest) {
        JoinRequest userInfo = userRepository.findByUserId(loginRequest.getUserId());

        if(BCrypt.checkpw(loginRequest.getPassword(), userInfo.getPassword())) {
            return userInfo.getName();
        } else {
            return null;
        }
    }

    @Override
    public JoinRequest findByUserId(String userId) {
        return userRepository.findByUserId(userId);
    }

    @Override
    public void join(JoinRequest joinRequest) {
        userRepository.save(joinRequest);
    }
}
