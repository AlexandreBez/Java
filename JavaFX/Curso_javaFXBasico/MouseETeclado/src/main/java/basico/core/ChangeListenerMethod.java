package basico.core;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
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

        scene.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event){
                System.out.println(event.getCharacter());
            }
        });

        scene.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                switch(event.getButton()) {
                    case MIDDLE:
                        event.consume();
                        break;
                    
                    case SECONDARY:
                        event.consume();
                        break;
                }
            }
            
        });

        scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event){
                int qtdClick = event.getClickCount();

                // switch(event.getButton()){
                //     case PRIMARY:
                        System.out.println("Esquerdo");
                //         break;
                //     case MIDDLE:
                //         System.out.println("Meio");
                //         break;
                //     case SECONDARY:
                //         System.out.println("Direito");
                //         break;
                // }

                System.out.println(qtdClick);
            }
        });

        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}