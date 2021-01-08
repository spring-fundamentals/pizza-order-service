package com.swisscom.springfundamentals.pizzaorderservice.pizzaorder.dataaccess;

import com.swisscom.springfundamentals.pizzaorderservice.pizzaorder.domain.PizzaOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaOrderRepository extends JpaRepository<PizzaOrder, String> {

}
