package infra;

import application.Controller;

import static com.raylib.Raylib.*;
import static com.raylib.Raylib.IsKeyDown;
import static com.raylib.Raylib.KEY_UP;

public class RaylibInputController {

    public void readInputs(Controller controller){
        if(IsKeyDown(KEY_LEFT)){
            controller.left_arrow();
        }
        if(IsKeyDown(KEY_RIGHT)){
            controller.moveRight();
        }
        if(IsKeyDown(KEY_UP)){
            controller.throwBall();
        }
        if(IsKeyReleased(KEY_P)){
            controller.pauseGame();
        }

        if(IsKeyReleased(KEY_LEFT) || IsKeyReleased(KEY_RIGHT)){
            controller.stopPaddle();
        }
    }
}
