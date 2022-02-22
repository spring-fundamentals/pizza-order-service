package com.springfundamentals.pizzaorderservice.pizzaorder.api;

import java.util.List;

public class CreatePizzaOrderDto {

    private List<PizzaOrderItemDto> orderItems;

    private CreatePizzaOrderDto() {
    }

    public List<PizzaOrderItemDto> getOrderItems() {
        return orderItems;
    }
}
