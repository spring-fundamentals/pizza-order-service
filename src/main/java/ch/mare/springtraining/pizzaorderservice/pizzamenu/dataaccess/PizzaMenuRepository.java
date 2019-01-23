package ch.mare.springtraining.pizzaorderservice.pizzamenu.dataaccess;

import ch.mare.springtraining.pizzaorderservice.pizzamenu.domain.PizzaMenuItem;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaMenuRepository extends JpaRepository<PizzaMenuItem, String> {

  List<PizzaMenuItem> findByNameContaining(String wordToContain);
}
