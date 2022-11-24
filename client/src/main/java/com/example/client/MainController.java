package com.example.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

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

    @FXML
    void chooseService(ActionEvent event) {

    }

    @FXML
    void logout(ActionEvent event) {

    }

    @FXML
    void viewServiceHistory(ActionEvent event) {

    }

    public void displayInfoAboutUser(String userName, String userLastName, String email, String phone) {
        firstName.setText("Имя: " + userName);
        lastName.setText("Фамилия: " + userLastName);
        userEmail.setText("Email: " + email);
        userPhone.setText("Телефон: " + phone);
    }
}
