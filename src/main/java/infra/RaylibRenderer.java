package infra;

import com.raylib.Colors;
import com.raylib.Raylib;
import domain.*;
import domain.interfaces.Renderer;

import java.util.List;

import static com.raylib.Raylib.*;
import static infra.RaylibUtils.*;

public class RaylibRenderer extends Renderer {

    public RaylibRenderer(ScreenSize screenSize) {
        super(screenSize);
    }

    @Override
    public void draw(Ball ball) {
        DrawCircleV(positionToVector2(ball.getCenterPosition()), ball.getRadius(), Colors.WHITE);

    }

    @Override
    public void draw(Paddle paddle) {
        DrawRectangleV(
                positionToVector2(paddle.getPosition()),
                sizeToVector2(paddle.getSize()),
                Colors.GRAY
        );
    }

    @Override
    public void draw(BrickCollection brickCollection) {
        var bricks = brickCollection.getBricks();

        for(int i = 0; i < brickCollection.rows(); i++){
            for(int j = 0; j < brickCollection.columns(); j++){
                var brick = bricks[i][j];
                DrawRectangleV(positionToVector2(brick.getPosition()), sizeToVector2(brick.getSize()), domainColorToRaylibColor(brick.getColor()));
            }
        }
    }
}

