package basico.core;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        VBox noRaiz =  new VBox();

        URL fxmUrl = this.getClass().getClassLoader().getResource("teste.fxml");

        noRaiz = FXMLLoader.<VBox>load(fxmUrl);

        Scene minhaCena = new Scene(noRaiz);

        stage.setScene(minhaCena);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}