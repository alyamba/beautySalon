package com.example.client.viewcontroller;

import com.example.client.connection.ConnectionHandler;
import com.example.client.container.SceneContainer;
import com.example.client.model.OrderSelection;
import com.example.client.model.Selection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainController {

    @FXML
    private Button chooseService;

    @FXML
    private Label firstName;

    @FXML
    private Label login;

    @FXML
    private Label userPhone;

    @FXML
    private Button viewServiceHistory;

    private Stage stage;
    private Scene scene;
    private Parent root;

    private static String loginStr;

    @FXML
    void chooseService(ActionEvent event) {
        JSONObject sendingObject = new JSONObject();
        sendingObject.put("requestType", "GET_OPTIONS");
        ConnectionHandler.send(sendingObject);

        JSONObject receivedObject = ConnectionHandler.listen();
        int size = (int) receivedObject.get("size");

        List<Selection> selectionList = new ArrayList<>();

        if(size == 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Внимание");
            alert.setTitle("На данный момент никаких услуг не обнаружено");
            alert.show();
        } else {
            for (int i = 0; i < size; i++) {
                Map userMap = (Map) receivedObject.get("option" + i);

                Selection selection = new Selection();

                selection.setName((String) userMap.get("name"));
                selection.setPrice(Double.parseDouble((String) userMap.get("price")));
                selectionList.add(selection);
            }
        }

        SceneContainer.changeScene("/order.fxml", event);

        OrderController orderController = SceneContainer.getFxmlLoader().getController();
        orderController.initMap(selectionList);
        orderController.setOptionBoxData(selectionList);
        orderController.setLogin(login.getText().substring(7));
        orderController.setName(firstName.getText().substring(5));
        orderController.setPhone(userPhone.getText().substring(9));
    }

    @FXML
    void logout(ActionEvent event) {
        SceneContainer.changeScene("/sessionEndWarning.fxml", event);

        SessionEndWarningController sessionEndWarningController = SceneContainer.getFxmlLoader().getController();
        sessionEndWarningController.setLogin(login.getText().substring(7));
        sessionEndWarningController.setName(firstName.getText().substring(5));
        sessionEndWarningController.setPhone(userPhone.getText().substring(9));
    }

    @FXML
    void viewServiceHistory(ActionEvent event) {
        JSONObject sendingObject = new JSONObject();
        sendingObject.put("requestType", "GET_PERSONAL_ORDERS");
        sendingObject.put("login", login.getText().substring(7));
        ConnectionHandler.send(sendingObject);

        JSONObject receivedObject = ConnectionHandler.listen();
        int size = (int) receivedObject.get("size");

        List<OrderSelection> selectionList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Map orderedItem = (Map) receivedObject.get("option" + i);

            OrderSelection orderSelection = new OrderSelection();
            orderSelection.setId((Integer) orderedItem.get("id"));
            orderSelection.setName((String) orderedItem.get("name"));
            orderSelection.setPrice((Double) orderedItem.get("price"));
            selectionList.add(orderSelection);
        }

        SceneContainer.changeScene("/serviceList.fxml", event);
        ServiceListController serviceListController = SceneContainer.getFxmlLoader().getController();
        serviceListController.setData(selectionList);
        serviceListController.setLogin(login.getText().substring(7));
        serviceListController.setName(firstName.getText().substring(5));
        serviceListController.setPhone(userPhone.getText().substring(9));
    }

    public void setName(String text) {
        firstName.setText("Имя: " + text);
    }

    public void setPhone(String text) {
        userPhone.setText("Телефон: " + text);
    }

    public void setLogin() {
        login.setText("Логин: " + loginStr);
    }

//    public void setPassword(String password) {
//        this.password = password;
//    }

    public static void setLoginStr(final String loginStr) {
        MainController.loginStr = loginStr;
    }
}
