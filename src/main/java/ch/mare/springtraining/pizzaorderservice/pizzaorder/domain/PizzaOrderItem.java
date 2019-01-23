package ch.mare.springtraining.pizzaorderservice.pizzaorder.domain;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PizzaOrderItem {

  @Id
  @GeneratedValue
  private UUID id;
  private String name;
  private int quantity;

  private PizzaOrderItem() {
  }

  public PizzaOrderItem(String name, int quantity) {
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
