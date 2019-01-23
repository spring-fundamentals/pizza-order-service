package ch.mare.springtraining.pizzaorderservice.pizzaorder.controller;

import ch.mare.springtraining.pizzaorderservice.pizzaorder.service.PizzaOrderService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PizzaOrderController {

    private final PizzaOrderService pizzaOrderService;

    public PizzaOrderController(PizzaOrderService pizzaOrderService) {
        this.pizzaOrderService = pizzaOrderService;
    }

    @PostMapping("/pizza-orders")
    public PizzaOrderDto create(@RequestBody CreatePizzaOrderDto createPizzaOrderDto) {
        return pizzaOrderService.create(createPizzaOrderDto);
    }

    @GetMapping("/pizza-orders")
    public List<PizzaOrderDto> getAll() {
        return pizzaOrderService.findAll();
    }

}
