package com.zuhelke.springfundamentals.pizzaorderservice.pizzaorder.dataaccess;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
@ConditionalOnExpression("${pizza-inventory.mock:false}==true")
public class MockInventoryService implements PizzaInventoryService {

  @Override
  public boolean isPizzaAvailable(String pizzaName) {
    return true;
  }
}
