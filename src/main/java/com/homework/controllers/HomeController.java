package com.homework.controllers;

import com.homework.models.Manufacturer;
import com.homework.services.ManufacturerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class HomeController {

    private final ManufacturerService manufacturerService;

    @GetMapping("/")
    public String root(Model model) {
        final List<Manufacturer> all = manufacturerService.findAll();
        model.addAttribute("manufacturers", all);
        return "index";
    }

    @GetMapping("/create")
    private String manufacturerPage(final Model model) {
        model.addAttribute("manufacturer", new Manufacturer());
        return "createManufacturer";
    }

    @GetMapping("/user")
    public String userIndex() {
        return "user/index";
    }
}
