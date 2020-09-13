package com.javakrk.twiter.controller;

import com.javakrk.twiter.model.dto.UserSecDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @GetMapping("/start")
    public String getLoginView() {
        return "login";
    }

    @GetMapping("/adduser")
    public ModelAndView getAddUserView() {
        return new ModelAndView("newuser", "newUser", new UserSecDto());
    }

    @GetMapping("/passwordreset")
    public String passwordResetUserView() {
        return "passwordreset";
    }

}
