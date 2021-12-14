module basico.core {
    requires javafx.controls;
    requires javafx.fxml;

    opens basico.core to javafx.fxml;
    exports basico.core;
}
