/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basico.core;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author lucas
 */
public class BotaoExemplo2  extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        
        FlowPane noRaiz = new FlowPane();
        Scene minhaCena = new Scene(noRaiz, 300, 200);
        
        // Label label = new Label();
        // label.setText("Hello World");

        Button button = new Button();
        button.setText("Hello World");

        button.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                System.out.println("Ola mundo 2");
            }
            
        });

        noRaiz.getChildren().add(button);

        stage.setScene(minhaCena);

        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
