package com.toy.web.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

class UserControllerTest {

    @Test
    public void encoder() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String result = encoder.encode("1234");
        Assertions.assertTrue(encoder.matches("1234", result));
    }

}