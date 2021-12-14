/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basico.core;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
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
public class GraficoExemplo1 extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        //Layout
        FlowPane noRaiz = new FlowPane(); 
        
        //Cena
        Scene minhaCena = new Scene(noRaiz, 300, 200);
        
        //Cria eixo X
        CategoryAxis eixoX = new CategoryAxis();
        
        //Cria eixo Y
        NumberAxis eixoY = new NumberAxis();
        
        //Cria gráfico de barra
        //LineChart<String, Number> grafico = new LineChart<>(eixoX, eixoY);
        BarChart<String, Number> grafico = new BarChart<>(eixoX, eixoY);
        
        //Cria as series para o gráfico
        XYChart.Series<String, Number> maria = new XYChart.Series<>();
        maria.setName("Maria");
        XYChart.Series<String, Number> joao = new XYChart.Series<>();
        joao.setName("João");
        XYChart.Series<String, Number> pedro = new XYChart.Series<>();
        pedro.setName("Pedro");
        
        //Adiciona os dados as séries
        maria.getData().add(new XYChart.Data<String, Number>("Janeiro", 2500));
        joao.getData().add(new XYChart.Data<String, Number>("Janeiro", 2000));
        pedro.getData().add(new XYChart.Data<String, Number>("Janeiro", 1000));
        
        maria.getData().add(new XYChart.Data<String, Number>("Fevereiro", 500));
        joao.getData().add(new XYChart.Data<String, Number>("Fevereiro", 5000));
        pedro.getData().add(new XYChart.Data<String, Number>("Fevereiro", 2000));
        
        maria.getData().add(new XYChart.Data<String, Number>("Março", 2500));
        joao.getData().add(new XYChart.Data<String, Number>("Março", 0));
        pedro.getData().add(new XYChart.Data<String, Number>("Março", 3000));
        
        //Adiciona as séries ao gráfico
        grafico.getData().addAll(maria, joao, pedro);
        
        //Adiciona o gráfico ao grafo de cena
        noRaiz.getChildren().add(grafico);
        
        //Adicionar a cena ao palco
        primaryStage.setScene(minhaCena);
        
        //Exibir o palco e sua(s) cena(s)
        primaryStage.show();
    }
    
    public static void main(String args[]){
        launch(args);
    }
    
}
