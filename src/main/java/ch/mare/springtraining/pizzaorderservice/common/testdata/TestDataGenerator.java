package ch.mare.springtraining.pizzaorderservice.common.testdata;

import static java.util.Arrays.asList;

import ch.mare.springtraining.pizzaorderservice.pizzamenu.dataaccess.PizzaMenuRepository;
import ch.mare.springtraining.pizzaorderservice.pizzaorder.dataaccess.PizzaOrderRepository;
import ch.mare.springtraining.pizzaorderservice.pizzamenu.domain.PizzaMenuItem;
import ch.mare.springtraining.pizzaorderservice.pizzaorder.domain.PizzaOrder;
import ch.mare.springtraining.pizzaorderservice.pizzaorder.domain.PizzaOrderItem;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"default", "dev"})
public class TestDataGenerator implements CommandLineRunner {

  private final PizzaMenuRepository pizzaMenuRepository;
  private final PizzaOrderRepository pizzaOrderRepository;

  public TestDataGenerator(PizzaMenuRepository pizzaMenuRepository, PizzaOrderRepository pizzaOrderRepository) {
    this.pizzaMenuRepository = pizzaMenuRepository;
    this.pizzaOrderRepository = pizzaOrderRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    createPizzaMenuTestData();

    pizzaOrderRepository.save(new PizzaOrder(asList(
        new PizzaOrderItem("Pizza Salami", 2),
        new PizzaOrderItem("Pizza Margherita", 2)
    )));
  }

  private void createPizzaMenuTestData() {
    pizzaMenuRepository.save(new PizzaMenuItem("1", "Pizza Margherita", 15));
    pizzaMenuRepository.save(new PizzaMenuItem("2", "Pizza Salami", 18));
  }
}
