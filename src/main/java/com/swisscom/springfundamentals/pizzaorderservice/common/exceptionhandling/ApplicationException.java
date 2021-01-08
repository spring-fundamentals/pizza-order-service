package com.swisscom.springfundamentals.pizzaorderservice.common.exceptionhandling;

public class ApplicationException extends RuntimeException {

  private String problem;

  public ApplicationException(String problem) {
    this.problem = problem;
  }

  public String getProblem() {
    return problem;
  }
}
