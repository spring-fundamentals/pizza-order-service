package com.springfundamentals.pizzaorderservice.pizzamenu.controller;

import com.springfundamentals.pizzaorderservice.common.exceptionhandling.ResourceNotFoundException;
import com.springfundamentals.pizzaorderservice.pizzamenu.service.PizzaMenuService;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PizzaMenuController {

    private final PizzaMenuService pizzaMenuService;

    public PizzaMenuController(PizzaMenuService pizzaMenuService) {
        this.pizzaMenuService = pizzaMenuService;
    }

    @PostMapping("pizzas")
    public PizzaMenuItemDto create(@RequestBody PizzaMenuItemDto pizzaMenuItem) {
        return pizzaMenuService.create(pizzaMenuItem);
    }

    @GetMapping("pizzas")
    public List<PizzaMenuItemDto> getAll(@RequestParam Optional<String> nameContains) {
        if (nameContains.isPresent()) {
            return pizzaMenuService.findByNameContaining(nameContains.get());
        }
        return pizzaMenuService.findAll();
    }

    @GetMapping("pizzas/{id}")
    public PizzaMenuItemDto getById(@PathVariable String id) {
        return pizzaMenuService.findById(id)
            .orElseThrow(ResourceNotFoundException::new);
    }
}
