package com.zuhelke.springfundamentals.pizzaorderservice.pizzamenu.domain;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PizzaMenuItem {

  @Id
  private String id;
  private String name;
  private double price;

  private PizzaMenuItem() {
  }

  public PizzaMenuItem(String id, String name, double price) {
    this.id = id;
    this.name = name;
    this.price = price;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public double getPrice() {
    return price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PizzaMenuItem that = (PizzaMenuItem) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
