package mk.finki.ukim.wp.lab.impl;

import mk.finki.ukim.wp.lab.model.Ingredient;
import mk.finki.ukim.wp.lab.model.Pizza;
import mk.finki.ukim.wp.lab.model.exceptions.IngredientNotFoundException;
import mk.finki.ukim.wp.lab.model.exceptions.PizzaNotFoundException;
import mk.finki.ukim.wp.lab.model.exceptions.VeggiePizzaException;
import mk.finki.ukim.wp.lab.repo.IngredientsRepository;
import mk.finki.ukim.wp.lab.repo.PizzaJpaRepository;
import mk.finki.ukim.wp.lab.service.PizzaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PizzaServiceImpl implements PizzaService {
    private final PizzaJpaRepository repository;
    private final IngredientsRepository ingredientsRepository;

    public PizzaServiceImpl(PizzaJpaRepository repository, IngredientsRepository ingredientsRepository) {
        this.repository = repository;
        this.ingredientsRepository = ingredientsRepository;
    }

    @Override
    public Pizza createPizza(String name, String description, String[] ingredients, boolean veggie) {
        List<Ingredient> ingredientList= new ArrayList<>();
        veggie = true;
        for(String ingredientName : ingredients){
            ingredientList.add(this.ingredientsRepository.findById(ingredientName).orElseThrow(IngredientNotFoundException::new));
        }
        for (Ingredient i : ingredientList) {
            if(!i.isVeggie()){
                veggie = false;
                break;
            }
        }
        return this.repository.save(new Pizza(name,description,ingredientList,veggie));
    }

    @Override
    public List<Pizza> getAllPizzas() {
        return this.repository.findAll();
    }

    @Override
    public Pizza updatePizza(String id, String name, String description, String[] ingredients, boolean veggie) {
        Pizza target = this.repository.findById(id).orElseThrow(PizzaNotFoundException::new);
        if(!id.equals(name)) {
            this.repository.deleteById(id);
        }
        target.setName(name);
        target.setDescription(description);
        List<Ingredient> ingredientList= new ArrayList<>();
        for(String ingredientName : ingredients){
            ingredientList.add(this.ingredientsRepository.findById(ingredientName).orElseThrow(IngredientNotFoundException::new));
        }
        target.setIngredients(ingredientList);
        target.setVeggie(veggie);
        return this.repository.save(target);
    }

    @Override
    public void deletePizza(String id) {
        this.repository.deleteById(id);
    }

    @Override
    public List<Pizza> getPizzasWithTotalIngredients(int total) {
        List<Pizza> allPizzas = this.getAllPizzas();
        List<Pizza> filteredPizzas = new ArrayList<>();
        for(Pizza p : allPizzas){
            if(p.getIngredients().size() < total){
                filteredPizzas.add(p);
            }
        }
        return filteredPizzas;
    }


}
