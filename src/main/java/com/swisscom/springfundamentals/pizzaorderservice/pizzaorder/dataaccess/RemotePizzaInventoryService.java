package com.swisscom.springfundamentals.pizzaorderservice.pizzaorder.dataaccess;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Service;

@ConditionalOnExpression("${pizza.inventory.mock:false}==false")
@Service
public class RemotePizzaInventoryService implements PizzaInventoryService {

  private PizzaInventoryProperties pizzaInventoryProperties;

  public RemotePizzaInventoryService(PizzaInventoryProperties pizzaInventoryProperties) {
    this.pizzaInventoryProperties = pizzaInventoryProperties;
  }

  @Override
  public boolean isPizzaAvailable(String pizzaName) {

    try {
      Thread.sleep(4000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    return pizzaName.hashCode() % 3 != 0;
  }
}
