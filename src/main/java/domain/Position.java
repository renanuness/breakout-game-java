package domain;

public class Position{
    private float x;
    private float y;

    public Position(float x, float y){
        this.x = x;
        this.y = y;
    }

    public void moveX(float dx){
        x += dx;
    }

    public void moveY(float dy){
        y += dy;
    }


    public float x(){ return x; }
    public float y(){ return y; }
}
