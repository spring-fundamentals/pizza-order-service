package com.swisscom.springfundamentals.pizzaorderservice.pizzaorder.api;

import java.util.List;

public class PizzaOrderDto {

    private String orderId;
    private List<PizzaOrderItemDto> orderItems;

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
