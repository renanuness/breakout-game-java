package application;

import java.util.function.Consumer;

public class Controller {
    private Consumer moveLeftCmd;
    private Consumer moveRightCmd;
    private Consumer throwBallCmd;
    private Consumer pauseGameCmd;

    public Controller(Consumer leftArrowCmd, Consumer moveRightCmd, Consumer throwBallCmd, Consumer pauseGameCmd){
        this.moveLeftCmd = leftArrowCmd;
        this.moveRightCmd = moveRightCmd;
        this.throwBallCmd = throwBallCmd;
        this.pauseGameCmd = pauseGameCmd;
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

    public void pauseGame(){
        pauseGameCmd.accept(Void.class);
    }
}
