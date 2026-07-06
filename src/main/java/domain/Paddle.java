package domain;

import domain.interfaces.DrawPaddle;

public class Paddle {
    private Speed speed;
    private Position position;
    private Size size;
    private ScreenSize screenSize;


    public Paddle(ScreenSize screenSize, Position startingPosition){
        position = startingPosition;
        speed = new Speed(200);
        size = new Size(103, 20);
        this.screenSize = screenSize;
    }

    public boolean moveLeft(float deltaTime) {
        if (position.x() > 0){
            position.moveX(-speed.getSpeed() * deltaTime);
            return true;
        }
        return false;
    }

    public boolean moveRight(float deltaTime){
        if(position.x() < screenSize.width()-size.getWidth()) {
            position.moveX(speed.getSpeed() * deltaTime);
            return true;
        }
        return false;
    }

    public Position getPosition() { return position; }

    public Size getSize() { return size; }

    public void draw(DrawPaddle renderer) {
        renderer.draw(this);
    }

    public Speed getSpeed() { return speed; }

    public float getMiddleX(){ return position.x() + size.getWidth()/2; }
}