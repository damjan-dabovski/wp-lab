package mk.finki.ukim.wp.lab.repo;

import mk.finki.ukim.wp.lab.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaJpaRepository extends JpaRepository<Pizza, String> {
}
