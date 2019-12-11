package mk.finki.ukim.wp.lab.service;

import mk.finki.ukim.wp.lab.model.Ingredient;
import mk.finki.ukim.wp.lab.model.Pizza;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IngredientsService {
    public Ingredient getIngredient(String id);

    public Ingredient createIngredient(String name, boolean spicy, float amount, boolean veggie);

    public Page<Ingredient> getAllIngredients(int page, int size);

    public Ingredient updateIngredient(String id, String newName, boolean spicy, float amount, boolean veggie);

    void deleteIngredient(String name);

    List<Ingredient> getSpicyIngredients(boolean spicy);

    List<Pizza> getPizzasContaining(String id);
}
