package com.toy.web.service;

import com.toy.web.dto.JoinRequest;
import com.toy.web.repository.UserRepository;
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
    public JoinRequest loginCheck(String userId, String password) {
        return null;
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
