package com.example.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SessionEndWarningController {

    @FXML
    private Button noBtn;

    @FXML
    private Button yesBtn;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    void exit(ActionEvent event) throws Exception{
        System.out.println("method exit");

        FXMLLoader loader = new FXMLLoader(LoginController.class.getResource("login.fxml"));

        root = loader.load();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        stage.show();
    }

    @FXML
    void returnToMainPage(ActionEvent event) {

    }

}
