package mk.finki.ukim.wp.lab.service;

import mk.finki.ukim.wp.lab.model.Ingredient;
import mk.finki.ukim.wp.lab.model.Pizza;

import java.util.List;

public interface PizzaService {
    //deprecated
    // List<Pizza> listPizzas();

    Pizza createPizza(String name, String description, String[] ingredients, boolean veggie);

    List<Pizza> getAllPizzas();

    Pizza updatePizza(String id, String name, String description, String[] ingredients, boolean veggie);

    void deletePizza(String id);

    List<Pizza> getPizzasWithTotalIngredients(int total);
}
