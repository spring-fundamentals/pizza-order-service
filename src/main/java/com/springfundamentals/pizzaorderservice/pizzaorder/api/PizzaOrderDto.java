package com.springfundamentals.pizzaorderservice.pizzaorder.api;

import java.util.List;

public class PizzaOrderDto {

    private final String orderId;
    private final List<PizzaOrderItemDto> orderItems;

    public PizzaOrderDto(String orderId, List<PizzaOrderItemDto> orderItems) {
        this.orderId = orderId;
        this.orderItems = orderItems;
    }

    public String getOrderId() {
        return orderId;
    }

    public List<PizzaOrderItemDto> getOrderItems() {
        return orderItems;
    }
}
