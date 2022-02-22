package com.springfundamentals.pizzaorderservice.pizzamenu.controller;

public class PizzaMenuItemDto {

    private final String id;
    private final String name;
    private final double price;

    public PizzaMenuItemDto(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
