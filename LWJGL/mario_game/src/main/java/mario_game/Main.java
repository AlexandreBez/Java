package mario_game;

import mario_game.core.config.Window;

public class Main {
    public static void main(String[] args) {
        Window window = Window.get();
        window.run();
    }
}