package domain;

public class Definitions {
    private ScreenSize screenSize;
    private BricksLayout bricksLayout;


    public Position getStartingBricksPosition(){
        var x = (getScreenSize().width() -(getBricksLayout().getSize().getWidth() * getBricksLayout().columns()))/2;
        var y = getScreenSize().height()/5;
        return new Position(x, y);
    }

    public ScreenSize getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(ScreenSize screenSize) {
        this.screenSize = screenSize;
    }

    public BricksLayout getBricksLayout() { return bricksLayout; }

    public void setBricksLayout(BricksLayout bricksLayout) { this.bricksLayout = bricksLayout; }
}


