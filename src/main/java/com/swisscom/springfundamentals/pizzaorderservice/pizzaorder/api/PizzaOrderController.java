package com.swisscom.springfundamentals.pizzaorderservice.pizzaorder.api;

import com.swisscom.springfundamentals.pizzaorderservice.pizzaorder.service.PizzaOrderService;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PizzaOrderController {

    private final PizzaOrderService pizzaOrderService;

    public PizzaOrderController(PizzaOrderService pizzaOrderService) {
        this.pizzaOrderService = pizzaOrderService;
    }

    @GetMapping("/pizza-orders")
    public List<PizzaOrderDto> getAllWithFilter(@RequestParam Optional<String> containingPizzaName) {
        if (containingPizzaName.isPresent()) {
            return pizzaOrderService.findAllWithContainingPizza(containingPizzaName.get());
        }
        return pizzaOrderService.findAll();
    }

    @GetMapping("/pizza-orders/{id}")
    public PizzaOrderDto getById(@PathVariable String id) {
        return pizzaOrderService.findById(id);
    }

    @PostMapping("/pizza-orders")
    public PizzaOrderDto create(@RequestBody CreatePizzaOrderDto createPizzaOrderDto) {
        return pizzaOrderService.create(createPizzaOrderDto);
    }
}
