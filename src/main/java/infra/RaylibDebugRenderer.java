package infra;

import application.Game;
import com.raylib.Colors;
import domain.BrickCollection;
import domain.ScreenSize;
import domain.interfaces.DebugRenderer;

import java.awt.*;

import static com.raylib.Raylib.DrawText;

public class RaylibDebugRenderer extends RaylibRenderer implements DebugRenderer {
    private float updateRate = 0.4f;
    private float acc = 0;
    public RaylibDebugRenderer(ScreenSize screenSize) {
        super(screenSize);
    }

    @Override
    public void drawDebugInfo(Game game) {
        var fontSize = 22;
        var startingY = 10;
        for (var ball : game.getBalls()) {
            // Position
            DrawText(ball.getCenterPosition().toString(), 10, startingY, fontSize, Colors.WHITE);
            startingY += 30;
            // Angle
            DrawText(String.format("%.2fº", ball.getAngle()), 10, startingY, fontSize, Colors.WHITE);
            startingY += 30;
            // Speed
            DrawText(String.format("%.2f", ball.getSpeed()), 10, startingY, fontSize, Colors.WHITE);
            startingY += 30;
        }
    }
}
