package com.example.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class RegisterController {

    @FXML
    private TextField email;

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField phoneNumber;

    @FXML
    private PasswordField userPassword;

    @FXML
    private Hyperlink linkToLoginWindow;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    void registration(ActionEvent event) throws IOException {
        System.out.println("open method registration");
        String userFirstName = firstName.getText();
        String userLastName = lastName.getText();
        String userPhone = phoneNumber.getText();
        String userEmail = email.getText();

        System.out.println(userEmail);

        FXMLLoader loader = new FXMLLoader(RegisterController.class.getResource("main.fxml"));

        root = loader.load();

        MainController mainController = loader.getController();
        mainController.displayInfoAboutUser(userFirstName, userLastName, userPhone, userEmail);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        stage.show();
    }

    @FXML
    void goToLogin(ActionEvent event) throws Exception{
        System.out.println("method goToLogin");

        FXMLLoader loader = new FXMLLoader(LoginController.class.getResource("login.fxml"));

        root = loader.load();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        stage.show();
    }

}
