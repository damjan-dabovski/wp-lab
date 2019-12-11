package mk.finki.ukim.wp.lab.model.exceptions;

public class VeggiePizzaException extends RuntimeException {
    public VeggiePizzaException(){
        super("Error. The pizza declared as vegetarian has non-vegetarian ingredients selected.");
    }
}
