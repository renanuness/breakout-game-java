package domain.interfaces;

import application.Game;
import domain.ScreenSize;

public interface DebugRenderer extends DrawPaddle, DrawBall, DrawBrickCollection{
    void drawDebugInfo(Game game);

}
