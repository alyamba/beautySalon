package com.example.client.viewcontroller;

import com.example.client.connection.ConnectionHandler;
import com.example.client.container.SceneContainer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.json.simple.JSONObject;

import java.util.List;

public class AddCategoryController {
    @FXML
    private TextField categoryName;

    @FXML
    void addCategory(ActionEvent event) {
        String name = categoryName.getText();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("requestType", "ADD_CATEGORY");
        jsonObject.put("name", name);

        ConnectionHandler.send(jsonObject);

        System.out.println(name);
        System.out.println(ConnectionHandler.listen());

        SceneContainer.changeScene("/mainAdmin.fxml", event);
    }

    @FXML
    void goToMain(ActionEvent event) {
        SceneContainer.changeScene("/mainAdmin.fxml", event);
    }

}
