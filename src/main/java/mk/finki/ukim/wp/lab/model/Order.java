package mk.finki.ukim.wp.lab.model;

import lombok.Data;

@Data
public class Order {
    private String pizzaType;
    private String clientName;
    private String clientAddress;
    Long orderId;
}
