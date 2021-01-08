package com.swisscom.springfundamentals.pizzaorderservice.pizzamenu.service;

import static java.util.stream.Collectors.toList;

import com.swisscom.springfundamentals.pizzaorderservice.pizzamenu.dataaccess.PizzaMenuRepository;
import com.swisscom.springfundamentals.pizzaorderservice.pizzamenu.domain.PizzaMenuItem;
import com.swisscom.springfundamentals.pizzaorderservice.pizzamenu.controller.PizzaMenuItemDto;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class PizzaMenuService {

  private final PizzaMenuRepository pizzaMenuRepository;

  public PizzaMenuService(PizzaMenuRepository pizzaMenuRepository) {
    this.pizzaMenuRepository = pizzaMenuRepository;
  }

  public List<PizzaMenuItemDto> findAll() {
    return pizzaMenuRepository.findAll().stream()
        .map(this::mapToPizzaMenuItemDto)
        .collect(toList());
  }

  public Optional<PizzaMenuItemDto> findById(String id) {
    return pizzaMenuRepository.findById(id)
        .map(this::mapToPizzaMenuItemDto);
  }

  public List<PizzaMenuItemDto> findByNameContaining(String wordToContain) {
    return pizzaMenuRepository.findByNameContaining(wordToContain).stream()
        .map(this::mapToPizzaMenuItemDto)
        .collect(toList());
  }

  public PizzaMenuItemDto create(PizzaMenuItemDto pizzaMenuItem) {
    return mapToPizzaMenuItemDto(this.pizzaMenuRepository.save(new PizzaMenuItem(pizzaMenuItem.getId(), pizzaMenuItem.getName(), pizzaMenuItem.getPrice())));
  }

  private PizzaMenuItemDto mapToPizzaMenuItemDto(PizzaMenuItem pizzaMenuItem) {
    return new PizzaMenuItemDto(pizzaMenuItem.getId(), pizzaMenuItem.getName(), pizzaMenuItem.getPrice());
  }
}
