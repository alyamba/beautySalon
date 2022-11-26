package com.example.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private Hyperlink linkToRegistrationWindow;

    @FXML
    private Button loginBtn;

    @FXML
    private TextField userName;

    @FXML
    private PasswordField userPassword;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    void authorization(ActionEvent event) {

    }

    @FXML
    void goToRegistration(ActionEvent event) throws Exception{
        System.out.println("method goToRegistration");

        FXMLLoader loader = new FXMLLoader(LoginController.class.getResource("registration.fxml"));

        root = loader.load();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        stage.show();
    }

}
