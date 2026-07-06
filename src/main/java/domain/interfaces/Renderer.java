package domain.interfaces;

import domain.ScreenSize;

public abstract class Renderer implements DrawBall, DrawPaddle, DrawBrickCollection{
    protected ScreenSize screenSize;
    public Renderer(ScreenSize screenSize){
        this.screenSize = screenSize;
    }
}

