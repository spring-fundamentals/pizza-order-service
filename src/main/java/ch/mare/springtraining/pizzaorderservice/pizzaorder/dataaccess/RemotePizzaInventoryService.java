package ch.mare.springtraining.pizzaorderservice.pizzaorder.dataaccess;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnExpression("${pizza-inventory.mock:false}==false")
public class RemotePizzaInventoryService implements PizzaInventoryService {

  @Override
  public boolean isPizzaAvailable(String pizzaName) {
    try {
      Thread.sleep(4000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    return false;
  }
}
