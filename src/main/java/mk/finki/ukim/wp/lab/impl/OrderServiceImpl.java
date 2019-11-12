package mk.finki.ukim.wp.lab.impl;

import mk.finki.ukim.wp.lab.model.Order;
import mk.finki.ukim.wp.lab.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private Long id = 0L;

    @Override
    public Order placeOrder(String pizzaType, String pizzaSize, String clientName, String address) {
        Order ret = new Order(pizzaType, pizzaSize, clientName, address, id++);
        return ret;
    }
}
