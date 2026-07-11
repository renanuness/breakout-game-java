package domain;

public class Speed {
    private float speed;
    
    public Speed(float v) {
        this.speed = v;
    }


    public void accelerate(float acceleration){
        speed += acceleration;
    }

    public float getSpeed() { return speed; }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
