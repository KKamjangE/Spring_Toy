package com.toy.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RestController {

    @GetMapping("/center")
    public void getCenter() {
    }

    @GetMapping("/auth/login")
    public void login() {
    }
}
