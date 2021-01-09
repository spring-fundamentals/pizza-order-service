package com.swisscom.springfundamentals.pizzaorderservice.pizzaorder.api;

public class PizzaOrderItemDto {

    private String name;
    private int quantity;

    public PizzaOrderItemDto(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}
