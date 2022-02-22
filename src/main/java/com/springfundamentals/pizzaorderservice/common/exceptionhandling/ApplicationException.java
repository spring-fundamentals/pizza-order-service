package com.springfundamentals.pizzaorderservice.common.exceptionhandling;

public class ApplicationException extends RuntimeException {

  private final String problem;

  public ApplicationException(String problem) {
    this.problem = problem;
  }

  public String getProblem() {
    return problem;
  }
}
