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

public class ServiceController {

    @FXML
    private Button add;

    @FXML
    private ImageView createBtn;

    @FXML
    private TableColumn<?, ?> decriptionService;

    @FXML
    private Button delete;

    @FXML
    private ImageView deleteBtn;

    @FXML
    private Button edit;

    @FXML
    private ImageView editBtn;

    @FXML
    private TableColumn<?, ?> idService;

    @FXML
    private Button logout;

    @FXML
    private Button masterManagement;

    @FXML
    private TableColumn<?, ?> masterService;

    @FXML
    private TableView<?> mastertable;

    @FXML
    private TableColumn<?, ?> nameService;

    @FXML
    private Button serviceManagement;

    @FXML
    private TableColumn<?, ?> timeService;

    @FXML
    private Button userManagementBtn;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    void addUser(ActionEvent event) {

    }

    @FXML
    void createService(MouseEvent event) {

    }

    @FXML
    void deleteService(MouseEvent event) {

    }

    @FXML
    void deleteUser(ActionEvent event) {

    }

    @FXML
    void editService(MouseEvent event) {

    }

    @FXML
    void editUser(ActionEvent event) {

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
