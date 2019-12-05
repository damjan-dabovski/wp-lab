package mk.finki.ukim.wp.lab.repo;

import mk.finki.ukim.wp.lab.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientsRepository extends JpaRepository<Ingredient, String> {

}
