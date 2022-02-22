package com.springfundamentals.pizzaorderservice.common.exceptionhandling;

public class ProblemDto {

  private final String title;
  private final int status;
  private final String detail;

  public ProblemDto(String title, int status, String detail) {
    this.title = title;
    this.status = status;
    this.detail = detail;
  }

  public String getTitle() {
    return title;
  }

  public int getStatus() {
    return status;
  }

  public String getDetail() {
    return detail;
  }
}
