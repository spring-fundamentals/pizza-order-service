package com.springfundamentals.pizzaorderservice.pizzaorder.dataaccess;

import com.springfundamentals.pizzaorderservice.pizzaorder.domain.PizzaOrder;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class PizzaOrderRepository {

    private static final Logger logger = LoggerFactory.getLogger(PizzaOrderRepository.class);

    public List<PizzaOrder> findAll() {
        return InMemoryDB.PIZZA_ORDERS;
    }

    public PizzaOrder save(PizzaOrder pizzaOrder) {
        InMemoryDB.PIZZA_ORDERS.add(pizzaOrder);
        logger.info("Pizza saved");
        return pizzaOrder;
    }

    public Optional<PizzaOrder> findById(UUID id) {
        return InMemoryDB.PIZZA_ORDERS.stream()
            .filter(pizzaOrder -> pizzaOrder.getId().equals(id))
            .findAny();
    }
}
