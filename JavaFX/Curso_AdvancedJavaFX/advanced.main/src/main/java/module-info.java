module javafxadvanced.advanced.main {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires mail;
    requires activation;

    opens javafxadvanced.advanced.main to javafx.fxml;
    exports javafxadvanced.advanced.main;
    opens javafxadvanced.advanced.main.controller;
    opens javafxadvanced.advanced.main.config;
    opens javafxadvanced.advanced.main.email;
}
