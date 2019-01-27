package com.zuhelke.springfundamentals.pizzaorderservice.pizzaorder.controller;

import java.util.List;

public class CreatePizzaOrderDto {

    private List<PizzaOrderItemDto> orderItems;

    public CreatePizzaOrderDto(List<PizzaOrderItemDto> orderItems) {
        this.orderItems = orderItems;
    }

    private CreatePizzaOrderDto() {
    }

    public List<PizzaOrderItemDto> getOrderItems() {
        return orderItems;
    }
}
