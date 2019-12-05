package mk.finki.ukim.wp.lab.repo;

import mk.finki.ukim.wp.lab.model.Ingredient;
import mk.finki.ukim.wp.lab.model.exceptions.IngredientNotFoundException;
import mk.finki.ukim.wp.lab.service.IngredientsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public class IngredientsServiceImpl implements IngredientsService {

    private final IngredientsRepository repository;

    public IngredientsServiceImpl(IngredientsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Ingredient getIngredient(String id) {
        return this.repository.findById(id).orElseThrow(IngredientNotFoundException::new);
    }

    @Override
    public Ingredient createIngredient(String name, boolean spicy, float amount, boolean veggie) {
        return this.repository.save(new Ingredient(name,spicy,amount,veggie));
    }

    @Override
    public Page<Ingredient> getAllIngredients(int page, int size) {
        return this.repository.findAll(PageRequest.of(page, size));
    }


}
