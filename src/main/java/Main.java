import com.raylib.Colors;
import domain.Game;
import domain.ScreenSize;
import infra.RaylibCollisionDetector;
import infra.RaylibRenderer;

import static com.raylib.Colors.LIGHTGRAY;
import static com.raylib.Colors.RAYWHITE;
import static com.raylib.Raylib.*;

public class Main {
    public static void main(String[] args){
        final int screenWidth = 1024;
        final int screenHeight = 768;
        var screenSize = new ScreenSize(screenWidth, screenHeight);

        InitWindow(screenWidth, screenHeight, "Breakout game");
        SetTargetFPS(60);

        var renderer = new RaylibRenderer();
        var collisionDetector = new RaylibCollisionDetector();

        var game = new Game(screenSize);
        while (!WindowShouldClose())
        {
            var deltaTime = GetFrameTime();

            // Read inputs
            if(IsKeyDown(KEY_LEFT)){
                game.movePaddle(deltaTime,-1);
            }
            if(IsKeyDown(KEY_RIGHT)){
                game.movePaddle(deltaTime,1);
            }
            if(IsKeyDown(KEY_UP)){
                game.throwBall();
            }
            // Update
            //----------------------------------------------------------------------------------
            game.update(deltaTime, collisionDetector);
            //----------------------------------------------------------------------------------


            // Draw
            //----------------------------------------------------------------------------------
            BeginDrawing();
            ClearBackground(Colors.BLACK);

            game.draw(renderer);

            EndDrawing();
            //----------------------------------------------------------------------------------
        }

        // De-Initialization
        //--------------------------------------------------------------------------------------
        CloseWindow();        // Close window and OpenGL context
        //--------------------------------------------------------------------------------------
    }
}
