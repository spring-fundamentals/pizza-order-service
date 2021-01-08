package com.swisscom.springfundamentals.pizzaorderservice.pizzamenu.controller;

public class PizzaMenuItemDto {

    private String id;
    private String name;
    private double price;

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
