package com.example.client.viewcontroller;

import com.example.client.container.SceneContainer;
import com.example.client.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ShowUsersController implements Initializable {

    @FXML
    private TableColumn<User, String> loginCol;

    @FXML
    private TableColumn<User, String> nameCol;

    @FXML
    private TableColumn<?, ?> phoneCol;

    @FXML
    private TableView<User> usertable;

    ObservableList<User> observableList = FXCollections.observableArrayList();

    @FXML
    void back(ActionEvent event) {
        SceneContainer.changeScene("/mainAdmin.fxml", event);
    }

    @Override
    public void initialize(final URL url, final ResourceBundle resourceBundle) {
        loginCol.setCellValueFactory(new PropertyValueFactory<>("login"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));

        usertable.setItems(observableList);
    }

    public void addData(List<User> users) {
        observableList.addAll(users);
    }
}
