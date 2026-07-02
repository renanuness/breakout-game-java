package infra;

import com.raylib.Colors;
import com.raylib.Raylib;
import domain.Ball;
import domain.Paddle;
import domain.Position;
import domain.Size;
import domain.interfaces.Renderer;

import static com.raylib.Raylib.DrawCircleV;
import static com.raylib.Raylib.DrawRectangleV;
import static infra.RaylibUtils.positionToVector2;
import static infra.RaylibUtils.sizeToVector2;

public class RaylibRenderer extends Renderer {
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
}
