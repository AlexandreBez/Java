module JavaFX {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
	requires javafx.graphics;
    opens JavaFX.JavaFX to javafx.fxml;
    exports JavaFX.JavaFX;
}