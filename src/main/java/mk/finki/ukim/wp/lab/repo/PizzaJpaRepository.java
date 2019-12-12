package mk.finki.ukim.wp.lab.repo;

import mk.finki.ukim.wp.lab.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PizzaJpaRepository extends JpaRepository<Pizza, String> {

    @Query("select p from Pizzas p join p.ingredients pi where pi.spicy=:spicy")
    List<Pizza> getSpicyPizzas(@Param("spicy") boolean spicy);
}
