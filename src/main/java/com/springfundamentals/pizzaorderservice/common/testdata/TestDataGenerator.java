package com.springfundamentals.pizzaorderservice.common.testdata;

import com.springfundamentals.pizzaorderservice.pizzaorder.dataaccess.PizzaOrderRepository;
import com.springfundamentals.pizzaorderservice.pizzaorder.domain.PizzaOrder;
import com.springfundamentals.pizzaorderservice.pizzaorder.domain.PizzaOrderItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static java.util.Arrays.asList;

@Component
@Profile({"default", "dev"})
public class TestDataGenerator implements CommandLineRunner {

  private static final Logger logger = LoggerFactory.getLogger(TestDataGenerator.class);

  private final PizzaOrderRepository pizzaOrderRepository;

  public TestDataGenerator(PizzaOrderRepository pizzaOrderRepository) {
    this.pizzaOrderRepository = pizzaOrderRepository;
  }

  @Override
  public void run(String... args) {

    logger.info("generate test data ");

    createPizzaOrderTestData();
  }

  private void createPizzaOrderTestData() {
    pizzaOrderRepository.save(new PizzaOrder(asList(
        new PizzaOrderItem("Pizza Salami", 2),
        new PizzaOrderItem("Pizza Margherita", 2)
    )));

    pizzaOrderRepository.save(new PizzaOrder(asList(
        new PizzaOrderItem("Pizza Funghi", 3),
        new PizzaOrderItem("Pizza Salami", 1)
    )));
  }
}
