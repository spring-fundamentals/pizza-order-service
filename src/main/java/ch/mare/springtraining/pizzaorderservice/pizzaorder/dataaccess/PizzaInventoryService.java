package ch.mare.springtraining.pizzaorderservice.pizzaorder.dataaccess;

public interface PizzaInventoryService {

  boolean isPizzaAvailable(String pizzaName);
}
