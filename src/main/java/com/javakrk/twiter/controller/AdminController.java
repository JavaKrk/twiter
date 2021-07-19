package com.javakrk.twiter.controller;

import com.javakrk.twiter.model.dao.UserEntity;
import com.javakrk.twiter.model.dto.UserFindDto;
import com.javakrk.twiter.service.AdminService;
import com.javakrk.twiter.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@AllArgsConstructor
public class AdminController {

    private final AdminService adminService;
    private final UserService userService;

    @ModelAttribute("getUsers")
    public List<UserEntity> getUsers(UserFindDto userFindDto) {
        return adminService.getUserByLoginNameSurname(userFindDto);
    }

    @GetMapping("/management")
    public ModelAndView findUser() {
        return new ModelAndView("management", "findUser", new UserFindDto());
    }

    @ModelAttribute("userLogin")
    public String getLoginView() {
        return userService.getLoginLoggedUser();
    }

    @RequestMapping(value = "/management", params = {"userDetails"})
    public String userDetails(Integer userId, final BindingResult bindingResult) {
        return "management";
    }
}
