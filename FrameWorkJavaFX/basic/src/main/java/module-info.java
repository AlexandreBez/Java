module scenebuilder {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    opens scenebuilder to javafx.fxml;
    exports scenebuilder;
}