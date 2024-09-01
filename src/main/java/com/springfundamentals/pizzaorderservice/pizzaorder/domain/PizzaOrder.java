package com.springfundamentals.pizzaorderservice.pizzaorder.domain;

import java.util.List;
import java.util.UUID;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class PizzaOrder {

  @Id
  private UUID id;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name="pizza_order_id")
  private List<PizzaOrderItem> orderItems;

  private PizzaOrder() {
  }

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
