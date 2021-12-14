package basico.core.api.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class EventoController {
    
    @FXML
    private Label label;

    public void ola(){
        label.setText("Ola mundo");
    }
}