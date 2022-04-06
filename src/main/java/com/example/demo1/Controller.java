package com.example.demo1;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class Controller {

    private static Popup helpPopup;
    private static Stage stage;
    private static Scene scene;
    private static ImageView myImageView;

        /**
         * Returns to main menu
         * @param
         * @throws IOException
         */
        public  void exit() throws IOException {
            if (helpPopup != null) { helpPopup.hide(); }
            FXMLLoader loader = new FXMLLoader(Controller.class.getResource("MainMenu.fxml"));
            Parent mainCallWindowFXML = loader.load();
            stage = (Stage) myImageView.getScene().getWindow();
            scene = new Scene(mainCallWindowFXML, 600, 400, Color.TRANSPARENT);
            scene.getStylesheets().add("menuStyle.css");
            stage.setScene(scene);
            stage.centerOnScreen();
        }
    }

