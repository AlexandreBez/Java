package basico.core;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
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

        ObservableList<String> fruta = FXCollections.observableArrayList("Maça", "Banana", "Laranja", "Pera");
        ComboBox comboBox = new ComboBox(fruta);

        comboBox.getSelectionModel()
                .selectedItemProperty()
                .addListener(new ChangeListener<String>() {

                    @Override
                    public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
                        System.out.println(arg2);
                    }
                    
                });

        noRaiz.getChildren().add(comboBox);

        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}