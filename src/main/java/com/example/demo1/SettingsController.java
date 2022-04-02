package com.example.demo1;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SettingsController implements Initializable {

    @FXML
    private MenuBar exitMenu;

    @FXML
    private ImageView myImageView;

    /**
     * Returns to the Main Menu
     * @param event
     * @throws IOException
     */
    @FXML
    void returnToMain(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
        Parent mainCallWindowFXML = loader.load();
        Stage stage = (Stage) exitMenu.getScene().getWindow();
        Scene scene = new Scene (mainCallWindowFXML, 600, 400, Color.TRANSPARENT);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
    }

    /**
     * Sets ImageView and creates close button
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        exitMenu.setOnMouseClicked(e -> Platform.exit());

        try {
            Image logo = new Image(String.valueOf(getClass().getResource("/Images/logo.png")));
            myImageView.setImage(logo);
            myImageView.setVisible(true);
        } catch (Exception e) {
            System.out.println("Image Not Found");
        }
    }
}
