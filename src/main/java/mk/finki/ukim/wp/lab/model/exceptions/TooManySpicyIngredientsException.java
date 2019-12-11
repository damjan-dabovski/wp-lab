package mk.finki.ukim.wp.lab.model.exceptions;

public class TooManySpicyIngredientsException extends RuntimeException {
    public TooManySpicyIngredientsException(){
        super("Can't have more than 3 spicy ingredients!");
    }
}
