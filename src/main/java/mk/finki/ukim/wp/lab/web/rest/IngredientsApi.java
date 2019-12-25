package mk.finki.ukim.wp.lab.web.rest;

import mk.finki.ukim.wp.lab.model.Ingredient;
import mk.finki.ukim.wp.lab.model.Pizza;
import mk.finki.ukim.wp.lab.service.IngredientsService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "/api/ingredients", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
public class IngredientsApi {
    private final IngredientsService service;

    public IngredientsApi(IngredientsService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ingredient createIngredient(@RequestParam("name") String name,
                                       @RequestParam("spicy") boolean spicy,
                                       @RequestParam("amount") float amount,
                                       @RequestParam("veggie") boolean veggie) {
        return service.createIngredient(name, spicy, amount, veggie);
    }


    @GetMapping
    public Page<Ingredient> getAllIngredients(@RequestHeader(name = "page", defaultValue = "0", required = false) int page,
                                              @RequestHeader(name = "page-size", defaultValue = "5",required = false) int size){
        return this.service.getAllIngredients(page, size);
    }

    @GetMapping("/{id}")
    public Ingredient getIngredient(@PathVariable String id){
        return this.service.getIngredient(id);
    }

    @GetMapping("/{id}/pizzas")
    public List<Pizza> getPizzasContaining(@PathVariable String id){
        return this.service.getPizzasContaining(id);
    }

    @GetMapping(params = "spicy")
    public List<Ingredient> getSpicyIngredients(@RequestParam boolean spicy){
        return this.service.getSpicyIngredients(spicy);
    }

    @PatchMapping("/{id}")
    public Ingredient updateIngredient(@PathVariable String id,
                                       @RequestParam("name") String name,
                                       @RequestParam("spicy") boolean spicy,
                                       @RequestParam("amount") float amount,
                                       @RequestParam("veggie") boolean veggie){
        return this.service.updateIngredient(id,name, spicy, amount, veggie);
    }

    @DeleteMapping("/{id}")
    public void deleteIngredient(@PathVariable String id){
        this.service.deleteIngredient(id);
    }

}
