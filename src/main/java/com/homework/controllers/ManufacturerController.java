package com.homework.controllers;

import com.homework.models.Manufacturer;
import com.homework.models.Product;
import com.homework.services.ManufacturerService;
import com.homework.services.ProductsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("manufacturer")
@AllArgsConstructor
public class ManufacturerController {

    private final ManufacturerService manufacturerService;
    private final ProductsService productsService;

    @GetMapping("{id}/create")
    private String productCreatePage(@PathVariable("id") final String id, final Model model) {
        final UUID manufacturerId = UUID.fromString(id);
        final Manufacturer manufacturer = manufacturerService.findById(manufacturerId);
        model.addAttribute("product", new Product());
        model.addAttribute("manufacturer", manufacturer);
        return "createProduct";
    }

    @PostMapping("{id}/create")
    private String createProduct(@ModelAttribute("manufacturer") @Valid final Manufacturer manufacturer,
                                 @ModelAttribute("product") @Valid final Product product) {
        product.setManufacturer(manufacturer);
        productsService.create(product);
        return "redirect:/";
    }

    @GetMapping("{id}")
    public String productsView(@PathVariable("id") final String id, final Model model) {
        final UUID manufacturerId = UUID.fromString(id);
        final Manufacturer manufacturer = manufacturerService.findById(manufacturerId);
        final List<Product> products = productsService.findByManufacturerId(manufacturerId);
        model.addAttribute("manufacturer", manufacturer);
        model.addAttribute("products", products);
        return "manufacturer";
    }

    @PostMapping
    public String createManufacturer(@ModelAttribute("manufacturer") @Valid final Manufacturer manufacturer, final BindingResult result) {
        manufacturerService.create(manufacturer);
        return "redirect:/";
    }

}
