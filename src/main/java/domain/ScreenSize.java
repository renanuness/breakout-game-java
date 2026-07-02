package domain;

public class ScreenSize {
    private int width;
    private int height;

    public ScreenSize(int width, int height){
        this.width = width;
        this.height = height;
    }

    public int width() { return width; }
    public int height() { return height; }
}
