package ch.mare.springtraining.pizzaorderservice.pizzaorder.dataaccess;

import ch.mare.springtraining.pizzaorderservice.pizzaorder.domain.PizzaOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaOrderRepository extends JpaRepository<PizzaOrder, String> {

}
