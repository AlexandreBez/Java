package basico.core;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class ChangeListenerMethod extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FlowPane noRaiz = new FlowPane();
        Scene scene = new Scene(noRaiz, 640, 480);

        Image img = new Image("https://t8j5n5j3.rocketcdn.me/wp-content/uploads/2019/02/existe-vulcao-no-brasil-tudo-o-que-voce-precisa-saber-sobre-isso-1.jpg");

        ImageView imageView = new ImageView(img);

        noRaiz.getChildren().add(imageView);

        stage.setScene(scene);

        stage.show();
    }

    public static void main(String args[]) {
        launch(args);
    }

}