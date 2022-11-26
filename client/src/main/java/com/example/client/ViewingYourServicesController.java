package com.example.client;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewingYourServicesController implements Initializable {

    @FXML
    private Button chooseService;

    @FXML
    private Button logout;

    @FXML
    private Button viewServiceHistory;

    @FXML
    private ListView<String> yourListOfServices;

    @FXML
    private Label yourService;

    String[] yourServiceList = {"массаж", "маска для лица", "маникюр", "чистка лица", "пилинг"};
    String currentService;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    void chooseService(ActionEvent event) {

    }

    @FXML
    void logout(ActionEvent event) throws Exception{
        System.out.println("method sessionEndWarning");

        FXMLLoader loader = new FXMLLoader(LoginController.class.getResource("sessionEndWarning.fxml"));

        root = loader.load();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        stage.show();
    }

    @FXML
    void viewServiceHistory(ActionEvent event) throws IOException {
        System.out.println("method viewServiceHistory");

        FXMLLoader loader = new FXMLLoader(LoginController.class.getResource("serviceList.fxml"));

        root = loader.load();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        yourListOfServices.getItems().addAll(yourServiceList);

        yourListOfServices.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                currentService = yourListOfServices.getSelectionModel().getSelectedItem();
                yourService.setText(currentService);
            }
        });
    }
}
