package mk.finki.ukim.wp.lab.model.exceptions;

public class IngredientAlreadyExistsException extends RuntimeException {
    public IngredientAlreadyExistsException(){
        super("An ingredient with the same name already exists!");
    }
}
