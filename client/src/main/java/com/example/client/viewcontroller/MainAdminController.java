package com.example.client.viewcontroller;

import com.example.client.connection.ConnectionHandler;
import com.example.client.container.SceneContainer;
import com.example.client.model.Category;
import com.example.client.model.OrderSelection;
import com.example.client.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainAdminController {

    @FXML
    void addProduct(ActionEvent event) {
        JSONObject sendingObject = new JSONObject();
        sendingObject.put("requestType", "GET_CATEGORY");
        ConnectionHandler.send(sendingObject);

        JSONObject receivedObject = ConnectionHandler.listen();
        int size = (int) receivedObject.get("size");

        List<Category> categoryArrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Map categoryMap = (Map) receivedObject.get("category" + i);

            Category category = new Category();
            category.setName((String) categoryMap.get("name"));
            categoryArrayList.add(category);
        }

        SceneContainer.changeScene("/addProduct.fxml", event);
        AddProductController addProductController = SceneContainer.getFxmlLoader().getController();
        addProductController.setBoxData(categoryArrayList.stream().map(selection -> selection.getName()).toList());
    }

    @FXML
    void logout(ActionEvent event) {
        SceneContainer.changeScene("/signIn.fxml", event);
    }

    @FXML
    void showUsers(ActionEvent event) {
        JSONObject sendingObject = new JSONObject();
        sendingObject.put("requestType", "GET_ALL_USERS");
        ConnectionHandler.send(sendingObject);

        JSONObject receivedObject = ConnectionHandler.listen();
        int size = (int) receivedObject.get("size");

        List<User> users = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Map orderedItem = (Map) receivedObject.get("user" + i);

            User user = new User();
            user.setName((String) orderedItem.get("name"));
            user.setLogin((String) orderedItem.get("login"));
            user.setPhone((String) orderedItem.get("phone"));
            users.add(user);
        }

        SceneContainer.changeScene("/showUsers.fxml", event);
        ShowUsersController showUsersController = SceneContainer.getFxmlLoader().getController();
        showUsersController.addData(users);
    }

}
