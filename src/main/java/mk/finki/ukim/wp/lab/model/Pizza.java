package mk.finki.ukim.wp.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Pizzas")
@Data
@AllArgsConstructor
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String name;

    private String description;

    @OneToMany
    private List<Ingredient> ingredients;

    private boolean veggie;
}
