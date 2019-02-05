package com.zuhelke.springfundamentals.pizzaorderservice.pizzaorder.domain;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PizzaOrderItem {

  @Id
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
