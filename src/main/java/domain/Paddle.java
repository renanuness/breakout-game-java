package domain;

import domain.interfaces.DrawPaddle;

public class Paddle {
    private Speed speed;
    private float maxSpeed = 300;
    private Position position;
    private Size size;
    private ScreenSize screenSize;


    public Paddle(ScreenSize screenSize, Position startingPosition){
        position = startingPosition;
        speed = new Speed(0);
        size = new Size(103, 20);
        this.screenSize = screenSize;
    }

    public boolean moveLeft(float deltaTime) {
        if (position.x() > 0){
            //position.moveX(-speed.getSpeed() * deltaTime);
            if(speed.getSpeed() > -maxSpeed) {
                speed.accelerate(-15);
            }
            return true;
        }else{
            stop();
        }
        return false;
    }

    public boolean moveRight(float deltaTime){
        if(position.x() < screenSize.width()-size.getWidth()) {
            //position.moveX(speed.getSpeed() * deltaTime);
            if(speed.getSpeed()< maxSpeed) {
                speed.accelerate(15);
            }
            return true;
        }else{
            stop();
        }
        return false;
    }

    public void stop(){
        speed.setSpeed(0);
    }
    public void update(float deltaTime){
        position.moveX(speed.getSpeed() * deltaTime);
    }

    public Position getPosition() { return position; }

    public Size getSize() { return size; }

    public void draw(DrawPaddle renderer) {
        renderer.draw(this);
    }

    public Speed getSpeed() { return speed; }

    public float getMiddleX(){ return position.x() + size.getWidth()/2; }

    public float getSpeedPercentage(){
        return (Math.abs(speed.getSpeed()) * 100) / maxSpeed;
    }
}