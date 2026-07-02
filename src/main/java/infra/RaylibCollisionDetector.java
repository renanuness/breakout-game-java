package infra;

import domain.Ball;
import domain.Brick;
import domain.Paddle;
import domain.interfaces.ColissionDetector;

import static com.raylib.Raylib.CheckCollisionCircleRec;
import static infra.RaylibUtils.positionToVector2;
import static infra.RaylibUtils.sizeAndPositionToRectangle;

public class RaylibCollisionDetector implements ColissionDetector {
    @Override
    public boolean ballAndPaddle(Ball ball, Paddle paddle) {
        return CheckCollisionCircleRec(positionToVector2(ball.getCenterPosition()), ball.getRadius(), sizeAndPositionToRectangle(paddle.getSize(), paddle.getPosition()));
    }

    @Override
    public boolean ballAndBrick(Ball ball, Brick brick) {
        return false;
    }
}
