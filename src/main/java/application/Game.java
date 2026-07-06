package application;

import domain.*;
import domain.interfaces.ColissionDetector;
import domain.interfaces.Renderer;

import java.util.ArrayList;
import java.util.List;


public class Game {
    private final Paddle paddle;
    private List<Ball> balls;
    private float deltaTime;
    private Controller controller;
    private ScreenSize screenSize;
    private BrickCollection brickCollection;

    public Game(Definitions definitions){
        // Initialization vars (can be moved to config file)

        this.screenSize = definitions.getScreenSize();
        float ballRadius = 15f;

        var pos = new Position(512, 700);
        paddle = new Paddle(screenSize, pos);
        balls = new ArrayList<>();
        balls.add(new Ball(screenSize, new Position(paddle.getMiddleX(), pos.y()), ballRadius,true, 45, 0, ((x)->ballFollowed(x))));
        createDummyBall();

        var columns = definitions.getBricksLayout().columns();
        var startingX = definitions.getStartingBricksPosition();
        brickCollection = new BrickCollection(definitions);

        controller = new Controller(
                (x)->this.movePaddle(-1),
                (x)->this.movePaddle(1),
                (x)->this.throwBall()
        );
    }

    private void createDummyBall(){
        var ball = new Ball(screenSize, new Position(screenSize.width()/2, screenSize.height()/2), 15f, false, 45, -200, ((x)->ballFollowed(x)));
        balls.add(ball);
    }

    public void update(ColissionDetector colissionDetector){
        for(var ball : balls){
            ball.update(deltaTime);
            if(colissionDetector.ballAndPaddle(ball, paddle)){
                ball.collideWithPaddle(paddle.getSpeed().getSpeed());
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
        brickCollection.draw(renderer);

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

    private void ballFollowed(Ball ball){
        balls.remove(ball);
        if(balls.isEmpty()){
            System.out.println("GAME OVER");
        }
    }

    public List<Ball> getBalls() { return balls;    }

    public float getDeltaTime() {
        return deltaTime;
    }
}
