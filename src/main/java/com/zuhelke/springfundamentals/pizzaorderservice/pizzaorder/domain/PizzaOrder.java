package com.zuhelke.springfundamentals.pizzaorderservice.pizzaorder.domain;

import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

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
