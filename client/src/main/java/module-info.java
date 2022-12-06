module com.example.client {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires json.simple;
    requires javafx.base;


    opens com.example.client.model to javafx.base;
    opens com.example.client to javafx.fxml;
    exports com.example.client;
    exports com.example.client.viewcontroller;
    opens com.example.client.viewcontroller to javafx.fxml;
}