package infra;

import domain.*;
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
    public Brick ballAndBrick(Ball ball, BrickCollection brickCollection) {
        if(
            (ball.getTopCenterPosition().y()-(ball.getRadius()*2) > brickCollection.getBricksBottomY()) ||
            (ball.getBottomCenterPosition().y() < brickCollection.getBricksTopY())
        ){
            return null;
        }
        var bricks = brickCollection.getBricks();
        for(int i = 0; i < brickCollection.rows(); i++){
            for(int j = 0; j < brickCollection.columns(); j++){
                var brick = bricks[i][j];
                if(brick.getColor() == Color.BLACK){ continue; }
                if(CheckCollisionCircleRec(positionToVector2(ball.getCenterPosition()), ball.getRadius(), sizeAndPositionToRectangle(brick.getSize(), brick.getPosition()))){
                    brick.collideWithBall();
                    return brick;
                }
            }
        }
        return null;
    }
}
