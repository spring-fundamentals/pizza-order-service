package com.zuhelke.springfundamentals.pizzaorderservice.pizzaorder.infrastructure;

public interface PizzaInventoryClient {

  boolean isAvailable(String pizzaName);
}
