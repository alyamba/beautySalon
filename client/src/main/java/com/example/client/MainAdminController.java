package com.example.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainAdminController {

    @FXML
    private Button logout;

    @FXML
    private Button masterManagement;

    @FXML
    private Button serviceManagement;

    @FXML
    private Button userManagementBtn;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    void logout(ActionEvent event) throws IOException{
        System.out.println("method sessionEndWarning");

        FXMLLoader loader = new FXMLLoader(LoginController.class.getResource("sessionEndWarning.fxml"));

        root = loader.load();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        stage.show();
    }

    @FXML
    void masterControl(ActionEvent event) throws IOException {
        System.out.println("method masterControl");

        FXMLLoader loader = new FXMLLoader(LoginController.class.getResource("masterControl.fxml"));

        root = loader.load();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        stage.show();
    }

    @FXML
    void serviceControl(ActionEvent event) throws IOException{
        System.out.println("method serviceControl");

        FXMLLoader loader = new FXMLLoader(LoginController.class.getResource("serviceControl.fxml"));

        root = loader.load();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        stage.show();
    }

    @FXML
    void userControl(ActionEvent event) throws IOException{
        System.out.println("method userControl");

        FXMLLoader loader = new FXMLLoader(LoginController.class.getResource("userControl.fxml"));

        root = loader.load();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        stage.show();
    }

}
