package ch.mare.springtraining.pizzaorderservice.pizzaorder.domain;

import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class PizzaOrder {

  @Id
  @GeneratedValue
  private UUID id;

  @OneToMany(cascade = CascadeType.ALL)
  private List<PizzaOrderItem> orderItems;

  private PizzaOrder() {
  }

  public PizzaOrder(List<PizzaOrderItem> orderItems) {
    this.orderItems = orderItems;
  }

  public UUID getId() {
    return id;
  }

  public List<PizzaOrderItem> getOrderItems() {
    return orderItems;
  }
}
