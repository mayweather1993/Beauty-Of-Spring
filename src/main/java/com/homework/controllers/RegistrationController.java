package com.homework.controllers;

import com.homework.models.AppUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class RegistrationController {
    @GetMapping("/register")
    public String registrationPage() {
        return "register";
    }

    @ModelAttribute("user")
    public AppUser userRegistrationDto() {
        return new AppUser();
    }
}
