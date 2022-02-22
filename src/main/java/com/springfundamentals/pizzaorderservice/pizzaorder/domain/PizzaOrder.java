package com.springfundamentals.pizzaorderservice.pizzaorder.domain;

import java.util.List;
import java.util.UUID;

public class PizzaOrder {

  private final UUID id;
  private final List<PizzaOrderItem> orderItems;

  public PizzaOrder(List<PizzaOrderItem> orderItems) {
    this.id = UUID.randomUUID();
    this.orderItems = orderItems;
  }

  public UUID getId() {
    return id;
  }

  public List<PizzaOrderItem> getOrderItems() {
    return orderItems;
  }
}
