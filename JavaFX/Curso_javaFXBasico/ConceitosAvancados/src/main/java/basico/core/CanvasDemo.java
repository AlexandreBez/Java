/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basico.core;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class CanvasDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        //Layout
        FlowPane noRaiz = new FlowPane(); 
        
        //Cena
        Scene minhaCena = new Scene(noRaiz, 300, 200);
        
        Canvas canvas = new Canvas(400, 400);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.strokeLine(0, 0, 200, 100);
        
        noRaiz.getChildren().add(canvas);

        //Adicionar a cena ao palco
        primaryStage.setScene(minhaCena);
        
        //Exibir o palco e sua(s) cena(s)
        primaryStage.show();
    }
    
    public static void main(String args[]){
        launch(args);
    }
    
}
