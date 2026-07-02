package application;

import java.util.function.Consumer;

public class Controller {
    private Consumer moveLeftCmd;
    private Consumer moveRightCmd;
    private Consumer throwBallCmd;

    public Controller(Consumer leftArrowCmd, Consumer moveRightCmd, Consumer throwBallCmd){
        this.moveLeftCmd = leftArrowCmd;
        this.moveRightCmd = moveRightCmd;
        this.throwBallCmd = throwBallCmd;
    }

    public void left_arrow(){
        moveLeftCmd.accept(Void.class);
    }

    public void moveRight(){
        moveRightCmd.accept(Void.class);
    }

    public void throwBall(){
        throwBallCmd.accept(Void.class);
    }
}
