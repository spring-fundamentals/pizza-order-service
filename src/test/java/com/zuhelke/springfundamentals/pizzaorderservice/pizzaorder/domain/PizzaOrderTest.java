package com.zuhelke.springfundamentals.pizzaorderservice.pizzaorder.domain;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class PizzaOrderTest {

  @Test
  public void pizzaOrderWithNinePizza_getTotalQuantityOfOrderedPizzas_returnNine() {
    PizzaOrder pizzaOrderWithNinePizzas = new PizzaOrder(asList(new PizzaOrderItem("Pizza Salami", 5), new PizzaOrderItem("Pizza Parma", 4)));

    int totalQuantityOfOrderedPizzas = pizzaOrderWithNinePizzas.getTotalQuantityOfOrderedPizzas();

    assertThat(totalQuantityOfOrderedPizzas).isEqualTo(9);
  }
}