package com.example.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class MasterController {

    @FXML
    private Button add;

    @FXML
    private ImageView createBtn;

    @FXML
    private Button delete;

    @FXML
    private ImageView deleteBtn;

    @FXML
    private Button edit;

    @FXML
    private ImageView editBtn;

    @FXML
    private TableColumn<?, ?> firstNameMaster;

    @FXML
    private TableColumn<?, ?> idMaster;

    @FXML
    private TableColumn<?, ?> lastNameMaster;

    @FXML
    private Button logout;

    @FXML
    private Button masterManagement;

    @FXML
    private TableView<?> mastertable;

    @FXML
    private Button serviceManagement;

    @FXML
    private TableColumn<?, ?> serviceMaster;

    @FXML
    private Button userManagementBtn;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    void addUser(ActionEvent event) {

    }

    @FXML
    void createUser(MouseEvent event) {

    }

    @FXML
    void deleteUser(MouseEvent event) {

    }

    @FXML
    void editUser(MouseEvent event) {

    }

    @FXML
    void logout(ActionEvent event) throws IOException {
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
