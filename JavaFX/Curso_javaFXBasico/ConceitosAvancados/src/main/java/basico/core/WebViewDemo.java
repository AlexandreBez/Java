package basico.core;

import java.lang.Thread.State;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
// import javafx.scene.web.WebEngine;
// import javafx.scene.web.WebView;
import javafx.stage.Stage;


public class WebViewDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        //Layout
        FlowPane noRaiz = new FlowPane(); 
        
        //Cena
        Scene minhaCena = new Scene(noRaiz, 300, 200);

        WebView 

        WebEngine webEngine = new WebEngine();
        
        webEngine.getLoadWorker().stateProperty().addListener(
            new ChangeListener<State>() {
                public void changed(ObservableValue ov, State oldState, State newState) {
                    if (newState == State.RUNNABLE) {
                        primaryStage.setTitle(webEngine.getLocation());
                    }
                }
            });
        webEngine.load("http://google.com");
     }

        noRaiz.getChildren().add();

        //Adicionar a cena ao palco
        primaryStage.setScene(minhaCena);
        
        //Exibir o palco e sua(s) cena(s)
        primaryStage.show();
    }
    
    public static void main(String args[]){
        launch(args);
    }
    
}
