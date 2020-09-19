package com.javakrk.twiter.controller;

import com.javakrk.twiter.model.dto.LocationDto;
import com.javakrk.twiter.model.dto.UserSecurityDto;
import com.javakrk.twiter.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/start")
    public String getLoginView() {
        return "login";
    }

    @GetMapping("/adduser")
    public ModelAndView getAddUserView() {
        return new ModelAndView("newuser", "newUser", new UserSecurityDto());
    }

    @PostMapping("/adduser")
    public String addNewUse(@ModelAttribute UserSecurityDto userSecurityDto, LocationDto locationDto) {
        userService.addNewUser(userSecurityDto, locationDto);
        return "redirect:start";
    }

    @GetMapping("/passwordreset")
    public String passwordResetUserView() {
        return "passwordreset";
    }
}
