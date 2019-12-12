package mk.finki.ukim.wp.lab.repo;

import mk.finki.ukim.wp.lab.PizzaRepository;
import mk.finki.ukim.wp.lab.model.Ingredient;
import mk.finki.ukim.wp.lab.model.Pizza;
import mk.finki.ukim.wp.lab.model.exceptions.IngredientAlreadyExistsException;
import mk.finki.ukim.wp.lab.model.exceptions.IngredientNotFoundException;
import mk.finki.ukim.wp.lab.model.exceptions.TooManySpicyIngredientsException;
import mk.finki.ukim.wp.lab.service.IngredientsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
        Ingredient temp = this.repository.findById(name).orElse(null);
        if(temp!=null){ throw new IngredientAlreadyExistsException(); }
        int currentSpicyCount = this.repository.countSpicyIngredients();
        if(spicy && currentSpicyCount>=3){ throw new TooManySpicyIngredientsException(); }
        return this.repository.save(new Ingredient(name,spicy,amount,veggie));
    }

    @Override
    public Page<Ingredient> getAllIngredients(int page, int size) {
        return this.repository.findAll(PageRequest.of(page, size, Sort.by("name").ascending()));
    }

    @Override
    public List<Ingredient> getSpicyIngredients(boolean spicy) {
        return this.repository.getSpicyIngredients(spicy);
    }

    @Override
    public List<Pizza> getPizzasContaining(String id) {
        return this.repository.getPizzasContaining(id);
    }

    @Override
    public Ingredient updateIngredient(String id, String newName, boolean spicy, float amount, boolean veggie) {
        Ingredient target = this.repository.findById(id).orElseThrow(IngredientNotFoundException::new);
        if(!id.equals(newName)) {
            this.repository.deleteById(id);
        }
        target.setName(newName);
        target.setSpicy(spicy);
        target.setAmount(amount);
        target.setVeggie(veggie);
        return this.repository.save(target);
    }

    @Override
    public void deleteIngredient(String name) {
        Ingredient target = this.getIngredient(name);
        List<Pizza> pizzasContainingThis = this.getPizzasContaining(name);
        for(Pizza p : pizzasContainingThis){
            p.removeIngredient(target);
        }
        this.repository.deleteById(name);
    }
}
