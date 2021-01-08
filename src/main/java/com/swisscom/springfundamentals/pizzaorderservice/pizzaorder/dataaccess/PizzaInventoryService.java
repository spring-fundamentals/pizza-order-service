package com.swisscom.springfundamentals.pizzaorderservice.pizzaorder.dataaccess;

public interface PizzaInventoryService {

  boolean isPizzaAvailable(String pizzaName);
}
