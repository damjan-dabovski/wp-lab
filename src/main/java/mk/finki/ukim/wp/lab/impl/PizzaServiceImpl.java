package mk.finki.ukim.wp.lab.impl;

import mk.finki.ukim.wp.lab.PizzaRepository;
import mk.finki.ukim.wp.lab.model.Pizza;
import mk.finki.ukim.wp.lab.service.PizzaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaServiceImpl implements PizzaService {
    private final PizzaRepository repository;

    public PizzaServiceImpl(PizzaRepository repository){
        this.repository = repository;
    }

    @Override
    public List<Pizza> listPizzas() {
        return this.repository.getAllPizzas();
    }
}
