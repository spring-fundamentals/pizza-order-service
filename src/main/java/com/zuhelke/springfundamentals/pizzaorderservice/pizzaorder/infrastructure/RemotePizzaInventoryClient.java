package com.zuhelke.springfundamentals.pizzaorderservice.pizzaorder.infrastructure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Service;

@ConditionalOnExpression("${pizza.inventory.mock}==false")
@Service
public class RemotePizzaInventoryClient implements PizzaInventoryClient {

  @Override
  public boolean isAvailable(String pizzaName) {
    return pizzaName.hashCode() % 2 == 0;
  }
}
