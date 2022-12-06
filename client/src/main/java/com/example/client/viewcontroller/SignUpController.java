package com.example.client.viewcontroller;

import com.example.client.connection.ConnectionHandler;
import com.example.client.container.SceneContainer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.json.simple.JSONObject;

import java.io.IOException;

public class SignUpController {

    @FXML
    private TextField login;

    @FXML
    private TextField name;

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
        String nameStr = name.getText();
        String phoneStr = phoneNumber.getText();
        String loginStr = login.getText();
        String passwordStr = userPassword.getText();

        JSONObject sendingObject = new JSONObject();

        sendingObject.put("requestType", "SIGN_UP");
        sendingObject.put("name", nameStr);
        sendingObject.put("phone", phoneStr);
        sendingObject.put("login", loginStr);
        sendingObject.put("password", passwordStr);

        ConnectionHandler.send(sendingObject);

        JSONObject jsonObject = ConnectionHandler.listen();
        String response = (String) jsonObject.get("message");

        if(response.equals("SUCCESS_REG")) {
            SceneContainer.changeScene("/signIn.fxml", event);
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Ошибка");
            alert.setTitle("Логин уже существует");
            alert.setContentText("Логин уже существует, выберите другой");
            alert.show();
        }
    }

    @FXML
    void goToLogin(ActionEvent event) {
        SceneContainer.changeScene("/signIn.fxml", event);
    }

}
