module events {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    opens events to javafx.fxml;
    exports events;
}