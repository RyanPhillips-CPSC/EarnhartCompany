package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SettingsController extends Controller implements Initializable {

    @FXML
    private ImageView myImageView;

    /**
     * Returns to the Main Menu
     * @param event
     * @throws IOException
     */
    @FXML
    void returnToMain(ActionEvent event) throws IOException {

        if (!Main.isLoggedIn()) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
            Parent mainCallWindowFXML = loader.load();
            Stage stage = (Stage) myImageView.getScene().getWindow();
            Scene scene = new Scene(mainCallWindowFXML, 600, 400, Color.TRANSPARENT);
            scene.getStylesheets().add("style.css");
            stage.setScene(scene);
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
            Parent mainCallWindowFXML = loader.load();
            Stage stage = (Stage) myImageView.getScene().getWindow();
            Scene scene = new Scene(mainCallWindowFXML, 600, 400, Color.TRANSPARENT);
            scene.getStylesheets().add("style.css");
            stage.setScene(scene);
        }
    }

    /**
     * Sets ImageView and creates close button
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            Image logo = new Image(String.valueOf(getClass().getResource("/Images/logo.png")));
            myImageView.setImage(logo);
            myImageView.setVisible(true);
        } catch (Exception e) {
            System.out.println("Image Not Found");
        }
    }

    /**
     * Displays information related to the current Scene without closing the current Stage
     * @param event
     */
    @FXML
    void helpDisplay(ActionEvent event) throws IOException {
        super.helpDisplay(myImageView);
    }
}
