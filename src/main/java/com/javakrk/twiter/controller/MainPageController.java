package com.javakrk.twiter.controller;

import com.javakrk.twiter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainPageController {

    @Autowired
    private UserService userService;

    @GetMapping("/MainPage")
    public ModelAndView getMainPageView() {
        return new ModelAndView("MainPage", "user", userService.getNameAndSurnameLoggedUser());
    }

    @GetMapping("/login")
    public String getLoginView() {
        return "login";
    }
}


