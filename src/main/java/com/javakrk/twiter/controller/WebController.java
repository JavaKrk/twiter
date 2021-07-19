package com.javakrk.twiter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping({"/", "/login"})
    public String getLoginView() {
        return "login";
    }

    @GetMapping("/passwordreset")
    public String passwordResetUserView() {
        return "passwordreset";
    }
}
