package com.springfundamentals.pizzaorderservice.pizzaorder.infrastructure;

import com.springfundamentals.pizzaorderservice.pizzaorder.domain.PizzaOrder;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository
public class PizzaOrderRepository {

    public List<PizzaOrder> findAll() {
        return InMemoryDB.PIZZA_ORDERS;
    }

    public PizzaOrder save(PizzaOrder pizzaOrder) {
        InMemoryDB.PIZZA_ORDERS.add(pizzaOrder);
        return pizzaOrder;
    }

    public Optional<PizzaOrder> findById(UUID id) {
        return InMemoryDB.PIZZA_ORDERS.stream()
            .filter(pizzaOrder -> pizzaOrder.getId().equals(id))
            .findAny();
    }
}
