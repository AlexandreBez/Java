module JavaFXScenes {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
	requires javafx.graphics;
    opens JavaFXScenes.scenes to javafx.fxml;
    exports JavaFXScenes.scenes;
}