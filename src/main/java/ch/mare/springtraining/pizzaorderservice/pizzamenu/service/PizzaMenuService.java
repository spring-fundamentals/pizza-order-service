package ch.mare.springtraining.pizzaorderservice.pizzamenu.service;

import static java.util.stream.Collectors.toList;

import ch.mare.springtraining.pizzaorderservice.pizzamenu.controller.PizzaMenuItemDto;
import ch.mare.springtraining.pizzaorderservice.pizzamenu.dataaccess.PizzaMenuRepository;
import ch.mare.springtraining.pizzaorderservice.pizzamenu.domain.PizzaMenuItem;
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

  private PizzaMenuItemDto mapToPizzaMenuItemDto(PizzaMenuItem pizzaMenuItem) {
    return new PizzaMenuItemDto(pizzaMenuItem.getId(), pizzaMenuItem.getName(), pizzaMenuItem.getPrice());
  }
}
