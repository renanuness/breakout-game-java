package domain;

import domain.exceptions.InvalidIndexBrickConfiguration;

public class BricksLayout{
    private BrickConfiguration[][] bricks;

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    private Size size;

    public BricksLayout() {}

    public BrickConfiguration[][] getBricks() { return bricks; }
    public void setBricks(BrickConfiguration[][] bricks) { this.bricks = bricks; }

    public int rows(){ return bricks.length; }
    public int columns(){ return bricks[0].length; }

    public BrickConfiguration getBrickConfiguration(int row, int column){
        if((row < 0 || row > rows()) || (column < 0 || column > columns())){
            throw new InvalidIndexBrickConfiguration();
        }
        return bricks[row][column];
    }
}
