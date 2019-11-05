package mk.finki.ukim.wp.lab;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import mk.finki.ukim.wp.lab.model.Pizza;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
@NoArgsConstructor
public class PizzaRepository {
    private List<Pizza> pizzas = new ArrayList<>();

    @PostConstruct
    public void init(){
        pizzas.add(new Pizza("Margherita","Margherita (tomato sauce, mozzarella)"));
        pizzas.add(new Pizza("Carbonara","Carbonara (fresh cream, mozzarella, bacon)"));
        pizzas.add(new Pizza("Vegetariana","Vegetariana (tomato sauce, mushrooms))"));
        pizzas.add(new Pizza("Calzone","Calzone (Pizza dough, ricotta, pepperoni, pizza sauce, olive oil)"));
        pizzas.add(new Pizza("Cheddar","Cheddar (cheddar, tomato sauce)"));
        pizzas.add(new Pizza("Capricciosa","Capricciosa (tomato sauce, cheese, ham)"));
        pizzas.add(new Pizza("Burger Classic","Burger Classic (barbecue sauce, beef, mozzarella, onions)"));
        pizzas.add(new Pizza("Boston Barbecue","Boston Barbecue (ham, chicken meat, onions)"));
        pizzas.add(new Pizza("Pepperoni","Pepperoni (tomato sauce, mozzarella, sausage)"));
        pizzas.add(new Pizza("Quattro Formaggi","Quattro Formaggi (Taleggio, Mascarpone, Gorgonzola, Parmesan)"));
    }

    public List<Pizza> getAllPizzas(){
        return pizzas;
    }

}
