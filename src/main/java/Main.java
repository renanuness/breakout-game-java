import com.raylib.Colors;
import application.Game;
import domain.AppMode;
import domain.ScreenSize;
import infra.*;

import static com.raylib.Raylib.*;

public class Main {
    public static void main(String[] args){
        AppMode appMode = AppMode.DEBUG;

        var definitions = new DefinitionsJsonReader("definitions.json").readDefinitions();

        final int screenWidth = 1024;
        final int screenHeight = 768;
        var screenSize = new ScreenSize(screenWidth, screenHeight);

        // region Raylib settings
        InitWindow(screenWidth, screenHeight, "Breakout game");
        SetTargetFPS(60);
        // endregion

        var renderer = new RaylibRenderer(screenSize);
        if(appMode == AppMode.DEBUG){
            renderer = new RaylibDebugRenderer(screenSize);
        }
        var collisionDetector = new RaylibCollisionDetector();
        var raylibController = new RaylibInputController();

        var game = new Game(definitions);
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
            if(renderer instanceof RaylibDebugRenderer){
                ((RaylibDebugRenderer) renderer).drawDebugInfo(game);
            }
            EndDrawing();
            //----------------------------------------------------------------------------------
        }

        // De-Initialization
        //--------------------------------------------------------------------------------------
        CloseWindow();        // Close window and OpenGL context
        //--------------------------------------------------------------------------------------
    }
}
