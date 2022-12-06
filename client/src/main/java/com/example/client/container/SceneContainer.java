package com.example.client.container;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneContainer {
    private static FXMLLoader fxmlLoader;
    public static void changeScene(String url, ActionEvent event) {
        fxmlLoader = new FXMLLoader(SceneContainer.class.getResource(url));

        Parent root=null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static FXMLLoader getFxmlLoader() {
        return fxmlLoader;
    }
}
