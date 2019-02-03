package com.zuhelke.springfundamentals.pizzaorderservice.pizzaorder.dataaccess;

import com.zuhelke.springfundamentals.pizzaorderservice.pizzaorder.domain.PizzaOrder;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaOrderRepository extends JpaRepository<PizzaOrder, String> {

}
