package com.example.client.viewcontroller;

import com.example.client.connection.ConnectionHandler;
import com.example.client.container.SceneContainer;
import com.example.client.model.Category;
import com.example.client.model.Selection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import org.json.simple.JSONObject;

import java.util.List;

public class AddProductController {
    @FXML
    private ChoiceBox<String> categoryBox;

    @FXML
    private TextField selectionName;

    @FXML
    private TextField selectionPrice;

    @FXML
    void addSelection(ActionEvent event) {
        String name = selectionName.getText();
        String price = selectionPrice.getText();
        String category = categoryBox.getSelectionModel().getSelectedItem();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("requestType", "ADD_PRODUCT");
        jsonObject.put("name", name);
        jsonObject.put("price", price);
        jsonObject.put("category", category);

        ConnectionHandler.send(jsonObject);

        System.out.println(ConnectionHandler.listen());

        SceneContainer.changeScene("/mainAdmin.fxml", event);
    }

    public void setBoxData(List<String> list) {
        categoryBox.getItems().addAll(list);
    }
}
