package application;

import java.util.function.Consumer;

public class Controller {
    private final Consumer stopPaddleCmd;
    private final Consumer moveLeftCmd;
    private final Consumer moveRightCmd;
    private final Consumer throwBallCmd;
    private final Consumer pauseGameCmd;

    public Controller(Consumer leftArrowCmd, Consumer moveRightCmd, Consumer throwBallCmd, Consumer pauseGameCmd, Consumer stopPaddleCmd){
        this.moveLeftCmd = leftArrowCmd;
        this.moveRightCmd = moveRightCmd;
        this.throwBallCmd = throwBallCmd;
        this.pauseGameCmd = pauseGameCmd;
        this.stopPaddleCmd = stopPaddleCmd;
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

    public void stopPaddle(){ stopPaddleCmd.accept(Void.class); }
}
