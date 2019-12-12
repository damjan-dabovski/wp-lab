package mk.finki.ukim.wp.lab.web.rest;

import mk.finki.ukim.wp.lab.model.Ingredient;
import mk.finki.ukim.wp.lab.model.Pizza;
import mk.finki.ukim.wp.lab.service.PizzaService;
import org.springframework.http.HttpStatus;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/pizzas", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
public class PizzaApi {
    private final PizzaService service;

    public PizzaApi(PizzaService service) { this.service = service; }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pizza createPizza(@RequestParam("name") String name,
                             @RequestParam("description") String description,
                             @RequestParam("ingredients")String[] ingredients,
                             @RequestParam(name = "veggie", defaultValue = "false") boolean veggie){
        return this.service.createPizza(name,description,ingredients,veggie);
    }

    @GetMapping
    public List<Pizza> getAllPizzas(){
        return this.service.getAllPizzas();
    }

    @GetMapping(params = "totalIngredients")
    public List<Pizza> getPizzasWithTotalIngredients(@RequestParam("totalIngredients") int total){
        return this.service.getPizzasWithTotalIngredients(total);
    }

    @GetMapping(path = "/compare")
    public List<Ingredient> getMutualIngredients(@RequestParam("pizza1") String p1,
                                                 @RequestParam("pizza2") String p2){
        return this.service.getMutualIngredients(p1,p2);
    }

    @GetMapping(params = "spicy")
    public List<Pizza> getSpicyPizzas(@RequestParam("spicy") boolean spicy){
        return this.service.getSpicyPizzas(spicy);
    }

    @GetMapping(path = "/{id}")
    public Pizza getPizza(@PathVariable String id){
        return this.service.getPizza(id);
    }

    @PutMapping(path = "/{id}")
    public Pizza updatePizza(@PathVariable String id,
                             @RequestParam("name") String name,
                             @RequestParam("description") String description,
                             @RequestParam("ingredients") String[] ingredients,
                             @RequestParam(name = "veggie", defaultValue = "false") boolean veggie){
        return this.service.updatePizza(id, name, description, ingredients, veggie);
    }

    @DeleteMapping(path = "/{id}")
    void deletePizza(@PathVariable String id){
        this.service.deletePizza(id);
    }
}
