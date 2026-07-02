package application;

import domain.Ball;
import domain.Paddle;
import domain.Position;
import domain.ScreenSize;
import domain.interfaces.ColissionDetector;
import domain.interfaces.Renderer;

import java.util.ArrayList;
import java.util.List;


public class Game {
    private final Paddle paddle;
    private List<Ball> balls;
    private float deltaTime;
    private Controller controller;

    public Game(ScreenSize screenSize){
        // Initialization vars (can be moved to config file)
        float ballRadius = 15f;

        var pos = new Position(512, 700);
        paddle = new Paddle(screenSize, pos);
        balls = new ArrayList<>();
        balls.add(new Ball(screenSize, new Position(paddle.getMiddleX(), pos.y()), ballRadius,true, 45, 0));

        controller = new Controller(
                (x)->this.movePaddle(-1),
                (x)->this.movePaddle(1),
                (x)->this.throwBall()
        );
    }

    public void update(ColissionDetector colissionDetector){
        for(var ball : balls){
            ball.update(deltaTime);
            if(colissionDetector.ballAndPaddle(ball, paddle)){
                ball.updateAngle(225);
            }
        }
    }

    public void movePaddle(int dir){
        if(dir == -1) {
            if (paddle.moveLeft(deltaTime)) {
                if (balls.stream().anyMatch(b -> b.isAttachedToPaddle())) {
                    balls.stream().filter(ball -> ball.isAttachedToPaddle()).forEach(b -> b.moveLeft(paddle.getSpeed().getSpeed(), deltaTime));
                }
            }
        }
        if (dir == 1) {
            if(paddle.moveRight(deltaTime)) {
                if (balls.stream().anyMatch(b -> b.isAttachedToPaddle())) {
                    balls.stream().filter(ball -> ball.isAttachedToPaddle()).forEach(b -> b.moveRight(paddle.getSpeed().getSpeed(), deltaTime));
                }
            }
        }
    }

    public void draw(Renderer renderer){
        for(var ball : balls){
            ball.draw(renderer);
        }

        paddle.draw(renderer);
    }

    public void throwBall() {
        if (balls.stream().anyMatch(b -> b.isAttachedToPaddle())) {
            balls.stream().filter(ball -> ball.isAttachedToPaddle()).forEach(b -> b.startMoving());
        }
    }

    public void updateDeltaTime(float dt){
        deltaTime = dt;
    }

    public Controller getController(){
        return controller;
    }
}
