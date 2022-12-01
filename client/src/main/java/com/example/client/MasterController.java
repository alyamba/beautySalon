package com.example.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

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
    void logout(ActionEvent event) {

    }

    @FXML
    void masterControl(ActionEvent event) {

    }

    @FXML
    void serviceControl(ActionEvent event) {

    }

    @FXML
    void userControl(ActionEvent event) {

    }

}
