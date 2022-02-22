package com.springfundamentals.pizzaorderservice.pizzaorder.dataaccess;

import com.springfundamentals.pizzaorderservice.pizzaorder.domain.PizzaOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaOrderRepository extends JpaRepository<PizzaOrder, String> {

}
