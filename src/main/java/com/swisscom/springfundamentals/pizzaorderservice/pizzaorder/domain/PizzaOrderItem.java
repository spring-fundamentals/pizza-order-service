package com.swisscom.springfundamentals.pizzaorderservice.pizzaorder.domain;

import java.util.UUID;

public class PizzaOrderItem {

  private UUID id;

  private String name;
  private int quantity;

  private PizzaOrderItem() {
  }

  public PizzaOrderItem(String name, int quantity) {
    this.id = UUID.randomUUID();
    this.name = name;
    this.quantity = quantity;
  }

  public UUID getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int getQuantity() {
    return quantity;
  }
}
