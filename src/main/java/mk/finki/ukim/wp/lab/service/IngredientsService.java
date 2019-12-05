package mk.finki.ukim.wp.lab.service;

import mk.finki.ukim.wp.lab.model.Ingredient;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface IngredientsService {
    public Ingredient getIngredient(String id);

    public Ingredient createIngredient(String name, boolean spicy, float amount, boolean veggie);

    public Page<Ingredient> getAllIngredients(int page, int size);
}
