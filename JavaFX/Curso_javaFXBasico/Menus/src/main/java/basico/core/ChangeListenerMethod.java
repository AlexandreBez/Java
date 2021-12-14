package basico.core;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class ChangeListenerMethod extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        BorderPane noRaiz = new BorderPane();
        Scene scene = new Scene(noRaiz, 640, 480);

        MenuBar mb = new MenuBar();

        Menu menuArquivo = new Menu("Arquivo");

        MenuItem novo = new MenuItem("Novo");
        MenuItem abrir = new MenuItem("Abrir");
        MenuItem sair = new MenuItem("sair");

        sair.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
            
        });

        menuArquivo.getItems().addAll(novo, abrir, sair);
        mb.getMenus().add(menuArquivo);

        noRaiz.setTop(mb);

        stage.setScene(scene);

        stage.show();
    }

    public static void main(String args[]) {
        launch(args);
    }

}