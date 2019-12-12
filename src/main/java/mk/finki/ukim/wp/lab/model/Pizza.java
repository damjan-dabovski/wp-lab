package mk.finki.ukim.wp.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Pizzas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pizza {
    @Id
    private String name;

    private String description;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Ingredient> ingredients;

    private boolean veggie;

    public void removeIngredient(Ingredient i){
        this.ingredients.remove(i);
        i.removePizza(this);
    }
}
