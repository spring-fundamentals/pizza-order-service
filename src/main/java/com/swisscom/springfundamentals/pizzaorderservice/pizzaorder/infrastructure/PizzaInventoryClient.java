package com.swisscom.springfundamentals.pizzaorderservice.pizzaorder.infrastructure;

public interface PizzaInventoryClient {

  boolean isAvailable(String pizzaName);
}
