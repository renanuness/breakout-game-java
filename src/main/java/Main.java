import com.raylib.Colors;
import application.Game;
import domain.ScreenSize;
import infra.RaylibCollisionDetector;
import infra.RaylibInputController;
import infra.RaylibRenderer;

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
        var raylibController = new RaylibInputController();

        var game = new Game(screenSize);
        while (!WindowShouldClose())
        {
            var deltaTime = GetFrameTime();
            game.updateDeltaTime(deltaTime);

            // Read inputs
            raylibController.readInputs(game.getController());

            // Update
            //----------------------------------------------------------------------------------
            game.update(collisionDetector);
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
