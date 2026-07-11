package domain;

public class BallPaddleColliderRule {
    public void collide(Ball ball, Paddle paddle){
        System.out.println(String.format("Ball angle: %s", ball.getAngle()));
        System.out.println(String.format("Paddle speed: %s", paddle.getSpeed().getSpeed()));
        var speedPercentage = paddle.getSpeedPercentage();


        var side = getAngleSide(ball.getAngle());

        if(side == 1 && paddle.getSpeed().getSpeed() > 0){ // Ball and paddle going to right
            var speed = ball.getSpeed() * -1;
            var angle = ball.getAngle()+ speedPercentage/100*30;
            ball.setAngleAndSpeed(angle, speed);
        }else if(side == 1 && paddle.getSpeed().getSpeed() < 0){ // Ball going right and paddle going left
            var speed = ball.getSpeed() * -1;
            var angle = getInvertedAngle(ball.getAngle()) + (speedPercentage/100*30);
            ball.setAngleAndSpeed(angle, speed);
        }else if(side == -1 && paddle.getSpeed().getSpeed() < 0) { // Ball going left and paddle going right
            var speed = ball.getSpeed() * -1;
            var angle = getInvertedAngle(ball.getAngle()) - speedPercentage / 100 * 30;
            ball.setAngleAndSpeed(angle, speed);
        }else if(side == -1 && paddle.getSpeed().getSpeed() < 0) { // Ball going right and paddle going left
            var speed = ball.getSpeed() * -1;
            var angle = ball.getAngle() + speedPercentage / 100 * 30;
            ball.setAngleAndSpeed(angle, speed);
        }
        else{
            var speed = ball.getSpeed() * -1;
            var angle = Math.clamp(ball.getAngle() - speedPercentage/100*45, 0, 90);
            ball.setAngleAndSpeed(angle, speed);
        }

    }

    private float getInvertedAngle(float angle){
        return (180 - angle )%180;
    }

    private int getAngleSide(float angle) {
        if (angle < 90 || (angle > 180 && angle < 270)) {
            return 1;
        } else if ((angle > 90 && angle < 180) || (angle > 270 && angle < 380)){
            return -1;
        }
        return 0;
    }
}
