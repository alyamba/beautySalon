package com.example.client.viewcontroller;

import com.example.client.connection.ConnectionHandler;
import com.example.client.container.SceneContainer;
import com.example.client.model.Selection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.json.simple.JSONObject;

import java.net.URL;
import java.util.*;

public class OrderController implements Initializable {
    @FXML
    private ChoiceBox<String> optionBox;

    @FXML
    private TableColumn<Selection, String> optionNameColumn;

    @FXML
    private Label optionNameLabel;

    @FXML
    private TableColumn<Selection, Double> optionPriceColumn;

    @FXML
    private TableView<Selection> optionTable;

    @FXML
    private Label orderPriceLabel;

    private ObservableList<Selection> observableSelections = FXCollections.observableArrayList();

    private Map<String, Double> optionsMap = new HashMap<>();

    private String login;

    @Override
    public void initialize(final URL url, final ResourceBundle resourceBundle) {
        optionNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        optionPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        optionTable.setItems(observableSelections);

        optionBox.setOnAction(event -> {
            optionNameLabel.setText("Услуга: " + optionBox.getValue());
            orderPriceLabel.setText("Цена: " + optionsMap.get(optionBox.getValue()));
        });

        optionBox.getSelectionModel().selectFirst();
    }

    @FXML
    void addOption(ActionEvent event) {
        String option = optionBox.getValue();
        if(!checkIfOptionAdded(optionBox.getValue())) {
            observableSelections.add(new Selection(option, optionsMap.get(option)));
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Добавление услуги");
            alert.setTitle("Услуга уже добавлена!");
            alert.show();
        }
    }

    private boolean checkIfOptionAdded(String name) {
        Iterator<Selection> itr = observableSelections.iterator();
        while (itr.hasNext()) {
            if (itr.next().getName().equals(name)) return true;
        }
        return false;
    }

    public void setOptionBoxData(List<Selection> list) {
        optionBox.getItems().addAll(list.stream().map(selection -> selection.getName()).toList());
    }

    public void initMap(List<Selection> list) {
        for (int i = 0; i < list.size(); i++) {
            optionsMap.put(list.get(i).getName(), list.get(i).getPrice());
        }
    }

    public void makeOrder(final ActionEvent event) {
        if(observableSelections.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Добавление услуги");
            alert.setTitle("Сперва добавьте услугу!");
            alert.show();
        } else {
            List<Selection> list = observableSelections.stream().toList();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("requestType", "MAKE_ORDER");
            jsonObject.put("login", login);
            for (int i = 0; i < list.size(); i++) {
                jsonObject.put("name" + i, list.get(i).getName());
            }
            jsonObject.put("size", list.size());
            System.out.println("отправлен:");
            System.out.println(jsonObject.toJSONString());
            ConnectionHandler.send(jsonObject);

            System.out.println(ConnectionHandler.listen().toJSONString());

            SceneContainer.changeScene("/main.fxml", event);
            MainController mainController = SceneContainer.getFxmlLoader().getController();
            mainController.setLogin();
        }
    }
    public void goToMain(ActionEvent event) {SceneContainer.changeScene("/main.fxml", event);
//    TODO: передавать данные авторизованного пользователя
    }

    public void setLogin(final String login) {
        this.login = login;
    }


}
