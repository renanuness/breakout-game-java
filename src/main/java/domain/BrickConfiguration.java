package domain;

import com.fasterxml.jackson.annotation.JsonValue;

public class BrickConfiguration{
    private Color color;
    private BrickType type;

    public BrickConfiguration() {}


    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public BrickType getType() {
        return type;
    }

    public void setType(BrickType type) {
        this.type = type;
    }
}
