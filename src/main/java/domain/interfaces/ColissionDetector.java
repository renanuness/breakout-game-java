package domain.interfaces;

import domain.Ball;
import domain.Brick;
import domain.BrickCollection;
import domain.Paddle;

public interface ColissionDetector {
    boolean ballAndPaddle(Ball ball, Paddle paddle);
    Brick ballAndBrick(Ball ball, BrickCollection brick);

}
