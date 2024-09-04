package com.springfundamentals.pizzaorderservice.pizzaorder.dataaccess;

import com.springfundamentals.pizzaorderservice.pizzaorder.domain.PizzaOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PizzaOrderRepository extends JpaRepository<PizzaOrder, UUID> {

}
