package domain.exceptions;

public class InvalidIndexBrickConfiguration extends RuntimeException{
    public InvalidIndexBrickConfiguration() {
        super("Invalid index accessing bricks configuration array");
    }
}
