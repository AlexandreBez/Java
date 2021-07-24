module switchscenes {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    opens switchscenes to javafx.fxml;
    exports switchscenes;
}