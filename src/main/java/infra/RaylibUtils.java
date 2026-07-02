package infra;

import com.raylib.Raylib;
import domain.Position;
import domain.Size;

public class RaylibUtils {
    public static Raylib.Vector2 positionToVector2(Position position){
        var vec2 = new Raylib.Vector2();
        vec2.x(position.x());
        vec2.y(position.y());
        return vec2;
    }

    public static Raylib.Vector2 sizeToVector2(Size size){
        var vec2 = new Raylib.Vector2();
        vec2.x(size.getWidth());
        vec2.y(size.getHeight());
        return vec2;
    }

    public static Raylib.Rectangle sizeAndPositionToRectangle(Size size, Position position){
        var rec = new Raylib.Rectangle();
        rec.width(size.getWidth());
        rec.height(size.getHeight());
        rec.x(position.x());
        rec.y(position.y());
        return rec;
    }
}
