package domain.interfaces;

import domain.Ball;
import domain.Brick;
import domain.Paddle;

public interface ColissionDetector {
    boolean ballAndPaddle(Ball ball, Paddle paddle);
    boolean ballAndBrick(Ball ball, Brick brick);
}
