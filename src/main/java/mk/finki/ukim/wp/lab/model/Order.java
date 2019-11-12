package mk.finki.ukim.wp.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String pizzaType;
    private String pizzaSize;
    private String clientName;
    private String clientAddress;
    Long orderId;
}
