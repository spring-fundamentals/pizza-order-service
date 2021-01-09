package com.swisscom.springfundamentals.pizzaorderservice.pizzaorder.domain;

import java.util.List;
import java.util.UUID;

public class PizzaOrder {

  private UUID id;
  private List<PizzaOrderItem> orderItems;

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
