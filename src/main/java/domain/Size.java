package domain;

public class Size {
    private int width;

    public Size() {
    }



    private int height;

    public Size(int width, int height){
        this.width = width;
        this.height = height;
    }


    // region Getters & Setters
    public int getWidth(){ return width; }
    public int getHeight(){ return  height; }
    public void setWidth(int width) { this.width = width; }
    public void setHeight(int height) { this.height = height; }
    // endregion
}
