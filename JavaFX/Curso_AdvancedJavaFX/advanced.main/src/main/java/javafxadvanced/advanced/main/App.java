package javafxadvanced.advanced.main;

import javafx.application.Application;
import javafx.stage.Stage;
import javafxadvanced.advanced.main.config.ViewManager;
import javafxadvanced.advanced.main.email.EmailManager;

import java.io.IOException;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        ViewManager viewManager = new ViewManager(new EmailManager());
        viewManager.showLoginWindow();
        viewManager.updateStyes();
    }

    public static void main(String[] args) {
        launch(args);
    }

}