module com.bro {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    opens com.bro to javafx.fxml;
    exports com.bro;
}