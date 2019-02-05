package com.zuhelke.springfundamentals.pizzaorderservice.common.testdata;

import static java.util.Arrays.asList;

import com.zuhelke.springfundamentals.pizzaorderservice.pizzaorder.domain.PizzaOrderItem;
import com.zuhelke.springfundamentals.pizzaorderservice.pizzamenu.dataaccess.PizzaMenuRepository;
import com.zuhelke.springfundamentals.pizzaorderservice.pizzaorder.dataaccess.PizzaOrderRepository;
import com.zuhelke.springfundamentals.pizzaorderservice.pizzamenu.domain.PizzaMenuItem;
import com.zuhelke.springfundamentals.pizzaorderservice.pizzaorder.domain.PizzaOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"default", "dev", "cloud"})
public class TestDataGenerator implements CommandLineRunner {

  private static final Logger logger = LoggerFactory.getLogger(TestDataGenerator.class);

  private final PizzaMenuRepository pizzaMenuRepository;
  private final PizzaOrderRepository pizzaOrderRepository;

  public TestDataGenerator(PizzaMenuRepository pizzaMenuRepository, PizzaOrderRepository pizzaOrderRepository) {
    this.pizzaMenuRepository = pizzaMenuRepository;
    this.pizzaOrderRepository = pizzaOrderRepository;
  }

  @Override
  public void run(String... args) {

    logger.info("generate test data ");

    createPizzaMenuTestData();
    createPizzaOrderTestData();
  }

  private void createPizzaMenuTestData() {
    pizzaMenuRepository.save(new PizzaMenuItem("1", "Pizza Margherita", 15));
    pizzaMenuRepository.save(new PizzaMenuItem("2", "Pizza Salami", 18));
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
