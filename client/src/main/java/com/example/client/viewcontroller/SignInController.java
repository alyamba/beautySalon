package com.example.client.viewcontroller;

import com.example.client.connection.ConnectionHandler;
import com.example.client.container.SceneContainer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class SignInController implements Initializable{
    @FXML
    private Hyperlink linkToRegistrationWindow;

    @FXML
    private Button loginBtn;

    @FXML
    private TextField userName;

    @FXML
    private PasswordField userPassword;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    void authorization(ActionEvent event) throws IOException {
        String loginText = userName.getText();
        String passwordText = userPassword.getText();

        System.out.println(loginText);
        System.out.println(passwordText);

        JSONObject sendingObject = new JSONObject();
        sendingObject.put("requestType", "SIGN_IN");
        sendingObject.put("login", loginText);
        sendingObject.put("password", passwordText);
        ConnectionHandler.send(sendingObject);

        JSONObject receivedObject = ConnectionHandler.listen();
        String response = (String) receivedObject.get("message");

        if(response.equals("USER_SUCCESS")) {
            SceneContainer.changeScene("/main.fxml", event);

            MainController.setLoginStr((String) receivedObject.get("login"));
            MainController mainController = SceneContainer.getFxmlLoader().getController();

            mainController.setLogin();
            mainController.setPhone((String) receivedObject.get("phone"));
            mainController.setName((String) receivedObject.get("name"));
        } else if(response.equals("ADMIN_SUCCESS")) {
            // TODO: сеттеры для некст сцены
            SceneContainer.changeScene("/mainAdmin.fxml", event);
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Ошибка");
            alert.setTitle("Неверный ввод");
            alert.setContentText("Неправильный логин или пароль");
            alert.show();
        }

    }

    @FXML
    void goToRegistration(ActionEvent event) throws Exception{
        System.out.println("method goToRegistration");

        FXMLLoader loader = new FXMLLoader(SignInController.class.getResource("/signUp.fxml"));

        root = loader.load();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        stage.show();
    }


    @Override
    public void initialize(final URL url, final ResourceBundle resourceBundle) {
        new ConnectionHandler();
    }
}
