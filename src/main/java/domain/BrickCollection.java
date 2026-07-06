package domain;

import domain.interfaces.Renderer;

public class BrickCollection {
    private Brick[][] bricks;
    private int rows;
    private int columns;
    private Position startingPosition;
    private BricksLayout bricksLayout;

    public BrickCollection(Definitions definitions){
        this.bricksLayout = definitions.getBricksLayout();
        this.rows = definitions.getBricksLayout().rows();
        this.columns = definitions.getBricksLayout().columns();
        bricks = new Brick[rows][columns];
        startingPosition = definitions.getStartingBricksPosition();
        initializeBricks();
    }

    private void initializeBricks(){
        float xPosition = startingPosition.x();
        float yPosition = startingPosition.y();
        Size brickSize = new Size(100, 20);

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++) {
                bricks[i][j] = new Brick(new Position(xPosition, yPosition), brickSize, bricksLayout.getBrickConfiguration(i,j).getColor());
                xPosition += brickSize.getWidth()+1;
            }
            yPosition += brickSize.getHeight()+1;
            xPosition = startingPosition.x();
        }
    }

    public Brick[][] getBricks(){ return bricks; }
    public int rows(){ return rows;}
    public int columns() { return columns; }

    public void draw(Renderer renderer){
        renderer.draw(this);
    }
}
