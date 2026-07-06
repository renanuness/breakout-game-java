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

    public void move(Vector2 vector2){
        x += vector2.x();
        y += vector2.y();
    }

    public Position simulateMovement(float dx, float dy){
        var newX = x + dx;
        var newY = y + dy;

        return new Position(newX, newY);
    }

    public float x(){ return x; }
    public float y(){ return y; }

    @Override
    public String toString() {
        return String.format("(%.2f, %.2f)", x, y);
    }
}
