package ch.mare.springtraining.pizzaorderservice.pizzamenu.controller;

import ch.mare.springtraining.pizzaorderservice.common.exceptionhandling.ResourceNotFoundException;
import ch.mare.springtraining.pizzaorderservice.pizzamenu.service.PizzaMenuService;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PizzaMenuController {

    private final PizzaMenuService pizzaMenuService;

    public PizzaMenuController(PizzaMenuService pizzaMenuService) {
        this.pizzaMenuService = pizzaMenuService;
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
