package com.swisscom.springfundamentals.pizzaorderservice.pizzaorder.domain;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class PizzaOrderTest {

  @Test
  public void pizzaOrderWithNinePizza_getTotalQuantityOfOrderedPizzas_returnNine() {
    PizzaOrder pizzaOrderWithNinePizzas = new PizzaOrder(asList(new PizzaOrderItem("Pizza Salami", 5), new PizzaOrderItem("Pizza Parma", 4)));

    int totalQuantityOfOrderedPizzas = pizzaOrderWithNinePizzas.getTotalQuantityOfOrderedPizzas();

    assertThat(totalQuantityOfOrderedPizzas).isEqualTo(9);
  }
}
