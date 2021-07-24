module cssstylling {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    opens cssstylling to javafx.fxml;
    exports cssstylling;
}