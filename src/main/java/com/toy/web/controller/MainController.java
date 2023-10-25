package com.toy.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/contents/list")
    public String list() {
        return "contents/list";
    }

    @GetMapping("/auth/login")
    public String login() {
        return "auth/login";
    }
}
