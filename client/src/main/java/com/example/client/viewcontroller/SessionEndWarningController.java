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

    @FXML
    void exit(ActionEvent event) { SceneContainer.changeScene("/signIn.fxml", event);
    }

    @FXML
    void returnToMainPage(ActionEvent event) {
        SceneContainer.changeScene("/main.fxml", event);
        //    TODO: передавать данные авторизованного пользователя и оживить кнопку возврата
    }

}
