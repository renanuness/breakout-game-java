package domain;

import domain.interfaces.DrawBall;

public class Ball {
    private Position position;
    private Speed speed;
    private float radius;
    private float angle;
    private ScreenSize screenSize;
    private boolean attachedToPaddle;

    public Ball(ScreenSize screenSize, Position startingPosition, float radius, boolean attachedToPaddle, float angle, float initialSpeed){
        speed = new Speed(initialSpeed);
        this.screenSize = screenSize;
        this.radius = radius;
        this.angle = angle;
        this.attachedToPaddle = attachedToPaddle;

        if(attachedToPaddle) {
            startingPosition.moveY(-radius);
        }
        position = startingPosition;
    }

    public void update(float deltaTime) {
        var radians = Math.toRadians(angle);
        var xSpeed = Math.cos(radians) * speed.getSpeed();
        var ySpeed = Math.sin(radians) * speed.getSpeed();

        position.moveX((float)xSpeed * deltaTime);
        position.moveY((float)ySpeed * deltaTime);

        if(position.x() + radius > screenSize.width()){

        }
    }

    public void invertAngle(){

    }

    public void updateAngle(float newAngle){
        angle = newAngle;
    }

    public void draw(DrawBall drawBall){
        drawBall.draw(this);
    }

    public Position getCenterPosition() {
        return position;
    }

    public float getRadius() { return radius; }

    public void startMoving(){
        speed.setSpeed(150);
    }

    //
    public void moveLeft(float speed, float deltaTime) {
        position.moveX(-speed * deltaTime);
    }

    public void moveRight(float speed, float deltaTime){
        position.moveX(speed * deltaTime);
    }

    public boolean isAttachedToPaddle(){ return attachedToPaddle; }
}
