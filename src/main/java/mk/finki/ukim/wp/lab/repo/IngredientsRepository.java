package mk.finki.ukim.wp.lab.repo;

import mk.finki.ukim.wp.lab.model.Ingredient;
import mk.finki.ukim.wp.lab.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientsRepository extends JpaRepository<Ingredient, String> {

    @Query("select i from Ingredients i WHERE i.spicy=:spicyValue")
    List<Ingredient> getSpicyIngredients(@Param("spicyValue") boolean spicyValue);

    @Query("select count(i) from Ingredients i where i.spicy=true")
    int countSpicyIngredients();

    @Query("SELECT p FROM Pizzas p join p.ingredients pi where pi.name like :id")
    List<Pizza> getPizzasContaining(@Param("id") String id);
}
