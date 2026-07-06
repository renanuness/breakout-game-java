package domain.exceptions;

public class DefinitionsReadException extends RuntimeException{
    public DefinitionsReadException(String filename){
        super(String.format("Error trying to read definitions from %s", filename));
    }
}
