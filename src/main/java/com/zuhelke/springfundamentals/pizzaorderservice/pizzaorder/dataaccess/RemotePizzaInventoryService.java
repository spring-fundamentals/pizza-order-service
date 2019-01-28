package com.zuhelke.springfundamentals.pizzaorderservice.pizzaorder.dataaccess;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Service;

@ConditionalOnExpression("${pizza.inventory.mock:false}==false")

@Service
public class RemotePizzaInventoryService implements PizzaInventoryService {

  private String url;
  private String user;
  private String password;
  private String blubi;
  private PizzaInventoryProperties pizzaInventoryProperties;

  public RemotePizzaInventoryService(
      @Value("${pizza.inventory.url}") String url,
      @Value("${pizza.inventory.user}") String user,
      @Value("${pizza.inventory.password}") String password,
      @Value("${pizza.inventory.lala:luli}") String blubi,
      PizzaInventoryProperties pizzaInventoryProperties) {
    this.url = url;
    this.user = user;
    this.password = password;
    this.blubi = blubi;
    this.pizzaInventoryProperties = pizzaInventoryProperties;
  }

  @Override
  public boolean isPizzaAvailable(String pizzaName) {

    System.out.println(url);
    System.out.println(user);
    System.out.println(password);
    System.out.println(blubi);

    System.out.println(pizzaInventoryProperties.getUser());
    System.out.println(pizzaInventoryProperties.getPassword());
    System.out.println(pizzaInventoryProperties.getUrl());

    try {
      Thread.sleep(4000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    return pizzaName.hashCode() % 3 != 0;
  }
}
