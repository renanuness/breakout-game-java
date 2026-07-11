package domain;

import domain.interfaces.DrawBall;

import java.util.function.Consumer;

public class Ball {
    private final BallPaddleColliderRule rule;
    private Position position;
    private Speed speed;
    private float radius;
    private float angle;
    private ScreenSize screenSize;
    private boolean attachedToPaddle;
    private boolean followed;

    private Consumer<Ball> ballFollowedEvent;
    public Ball(ScreenSize screenSize,
                Position startingPosition,
                float radius,
                boolean attachedToPaddle,
                float angle,
                float initialSpeed,
                BallPaddleColliderRule rule,
                Consumer<Ball> ballFollowedEvent){
        speed = new Speed(initialSpeed);
        this.screenSize = screenSize;
        this.radius = radius;
        this.angle = angle;
        this.attachedToPaddle = attachedToPaddle;
        this.ballFollowedEvent = ballFollowedEvent;
        this.rule = rule;
        if(attachedToPaddle) {
            startingPosition.moveY(-radius);
        }
        position = startingPosition;
        followed = false;
    }

    public void update(float deltaTime) {
        var radians = Math.toRadians(angle);
        var xSpeed = (float)Math.cos(radians) * speed.getSpeed();
        var ySpeed = (float)Math.sin(radians) * speed.getSpeed();

        var simulatedPosition = position.simulateMovement(xSpeed*deltaTime, ySpeed*deltaTime);
        if(simulatedPosition.x() + radius >= screenSize.width()){
            invertAngle();
        }

        if(simulatedPosition.x() - (radius+0.1) <= 0){
            invertAngle();
        }

        if(simulatedPosition.y() - radius <= 0 && speed.getSpeed() < 0){
            System.out.println("INVERTING Y");
            speed.setSpeed(speed.getSpeed()*-1);
            invertAngle();
        }

        if(simulatedPosition.y() >= screenSize.height()){
            ballFollowedEvent.accept(this);
        }

        xSpeed = (float)Math.cos(radians) * speed.getSpeed();
        ySpeed = (float)Math.sin(radians) * speed.getSpeed();
        position.move(new Vector2(xSpeed * deltaTime,ySpeed * deltaTime));
    }

    public void invertAngle(){
        angle = (180 - angle )%360;
    }

    public void updateAngle(float newAngle){
        angle = newAngle;
    }

    public void draw(DrawBall drawBall){
        drawBall.draw(this);
    }

    // region Ball position
    public Position getCenterPosition() {
        return position;
    }

    public Position getTopCenterPosition(){
        return new Position(position.x(), position.y()-radius);
    }

    public Position getBottomCenterPosition(){
        return new Position(position.x(), position.y()+radius);
    }
    // endregion

    public float getRadius() { return radius; }

    public void startMoving(){
        attachedToPaddle = false;
        speed.setSpeed(-350);
    }

    //
    public void moveLeft(float speed, float deltaTime) {
        position.moveX(-speed * deltaTime);
    }

    public void moveRight(float speed, float deltaTime){
        position.moveX(speed * deltaTime);
    }

    public boolean isAttachedToPaddle(){ return attachedToPaddle; }

    public void collideWithPaddle(Paddle paddle) {
        if(speed.getSpeed() > 0) {
            rule.collide(this, paddle);
        }
    }

    public void setAngleAndSpeed(float angle, float speed){
        this.angle = angle;
        this.speed.setSpeed(speed);
    }

    public float getAngle() {
        return angle;
    }

    public float getSpeed() {
        return speed.getSpeed();
    }

    public void collideWithBrick(Brick brick) {
        if ((position.y() > brick.getPosition().y() && position.y() < brick.getPosition().y() + brick.getSize().getHeight())){
            invertAngle();
            return;
        }
        if(position.x() > brick.getPosition().x() && position.x() < brick.getPosition().x()+ brick.getSize().getWidth()){
            speed.setSpeed(speed.getSpeed() * -1);
            invertAngle();
        }
    }

    public void follow(){
        followed = true;
    }

    public boolean hasFollowed(){
        return followed;
    }
}
