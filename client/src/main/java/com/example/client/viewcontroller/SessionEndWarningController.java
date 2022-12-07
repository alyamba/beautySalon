package com.example.client.viewcontroller;

import com.example.client.container.SceneContainer;
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

    private String login;
    private String name;
    private String phone;

    @FXML
    void exit(ActionEvent event) { SceneContainer.changeScene("/signIn.fxml", event);
    }

    @FXML
    void returnToMainPage(ActionEvent event) {
        SceneContainer.changeScene("/main.fxml", event);
        MainController mainController = SceneContainer.getFxmlLoader().getController();

        mainController.setLogin();
        mainController.setPhone(this.phone);
        mainController.setName(this.name);
    }

    public void setLogin (String login) {
        this.login = login;
    }
    public void setName (String name) {
        this.name = name;
    }
    public void setPhone (String phone) {
        this.phone = phone;
    }

}
