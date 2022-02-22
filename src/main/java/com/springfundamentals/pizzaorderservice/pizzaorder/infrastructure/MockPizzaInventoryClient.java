package com.springfundamentals.pizzaorderservice.pizzaorder.infrastructure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnExpression("${pizza.inventory.mock}==true")
public class MockPizzaInventoryClient implements PizzaInventoryClient {

  @Override
  public boolean isAvailable(String pizzaName) {
    return true;
  }
}
