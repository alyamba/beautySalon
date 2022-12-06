package com.example.client.viewcontroller;

import com.example.client.container.SceneContainer;
import com.example.client.model.OrderSelection;
import com.example.client.model.Selection;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ServiceListController implements Initializable {

    @FXML
    private TableColumn<OrderSelection, Integer> idCol;

    @FXML
    private TableColumn<OrderSelection, String> nameCol;

    @FXML
    private TableColumn<OrderSelection, Double> priceCol;

    @FXML
    private TableView<OrderSelection> table;

    private ObservableList<OrderSelection> observableSelections = FXCollections.observableArrayList();

    @Override
    public void initialize(final URL url, final ResourceBundle resourceBundle) {
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        table.setItems(observableSelections);
    }

    public void setData(List<OrderSelection> list) {
        observableSelections.addAll(list);
    }


    public void goToMain(ActionEvent event) {SceneContainer.changeScene("/main.fxml", event);
//    TODO: передавать данные авторизованного пользователя и оживить кнопку возврата
    }
}
