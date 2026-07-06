package domain;

public class Brick {
    private Position position;
    private Size size;
    private Color color;


    public Brick(Position position, Size size, Color color) {
        this.position = position;
        this.size = size;
        this.color = color;
    }


    public Position getPosition() { return position; }

    public Size getSize() { return size; }

    public Color getColor() { return color; }

    public void collideWithBall(){
        this.color = Color.BLACK;
    }
}
