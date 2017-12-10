package com.homework.controllers;

import com.homework.models.AppUser;
import com.homework.services.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("users")
@AllArgsConstructor
public class UsersController {

    private final UsersService usersService;

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Valid final AppUser user,
                                      final BindingResult result) {
        final boolean existing = usersService.exist(user.getEmail());
        if (existing) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }

        if (result.hasErrors()) {
            return "register";
        }

        usersService.create(user);
        return "redirect:/";
    }
}