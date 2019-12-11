package mk.finki.ukim.wp.lab.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Ingredients")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Ingredient {
    @Id
    @NonNull
    private String name;

    @NonNull
    private boolean spicy;

    @NonNull
    private float amount;

    @NonNull
    private boolean veggie;

    @JsonIgnore
    @ManyToMany(mappedBy = "ingredients")
    private List<Pizza> pizzas;
}
