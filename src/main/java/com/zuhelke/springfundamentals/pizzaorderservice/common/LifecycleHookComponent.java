package com.zuhelke.springfundamentals.pizzaorderservice.common;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class LifecycleHookComponent {

  @PostConstruct
  public void customInit() {
    System.out.println("Hello.");
  }

  @PreDestroy
  public void customDestroy() {
    System.out.println("Good Bye.");
  }
}
