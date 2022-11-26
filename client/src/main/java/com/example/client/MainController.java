package com.example.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    @FXML
    private Button chooseService;

    @FXML
    private Label firstName;

    @FXML
    private Label lastName;

    @FXML
    private Button logout;

    @FXML
    private Label userEmail;

    @FXML
    private Label userPhone;

    @FXML
    private Button viewServiceHistory;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    void chooseService(ActionEvent event) {

    }

    @FXML
    void logout(ActionEvent event) throws Exception{
        System.out.println("method sessionEndWarning");

        FXMLLoader loader = new FXMLLoader(LoginController.class.getResource("sessionEndWarning.fxml"));

        root = loader.load();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        stage.show();
    }

    @FXML
    void viewServiceHistory(ActionEvent event) throws IOException {
        System.out.println("method viewServiceHistory");

        FXMLLoader loader = new FXMLLoader(LoginController.class.getResource("serviceList.fxml"));

        root = loader.load();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        stage.show();
    }

    public void displayInfoAboutUser(String userName, String userLastName, String email, String phone) {
        firstName.setText("Имя: " + userName);
        lastName.setText("Фамилия: " + userLastName);
        userEmail.setText("Email: " + email);
        userPhone.setText("Телефон: " + phone);
    }
}
