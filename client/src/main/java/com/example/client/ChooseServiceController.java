package com.example.client;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class ChooseServiceController {

    @FXML
    private VBox choosenServiceCard;

    @FXML
    private GridPane grid;

    @FXML
    private ComboBox<?> master;

    @FXML
    private Label name;

    @FXML
    private Label price;

    @FXML
    private ScrollPane scroll;

    @FXML
    private ImageView serviceImg;

    @FXML
    private DatePicker time;

}
