package com.example.demo1;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.TextAlignment;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SettingsController implements Initializable {

    private Popup helpPopup;

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
        if (helpPopup != null) { helpPopup.hide();}

        if (!Main.isLoggedIn()) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
            Parent mainCallWindowFXML = loader.load();
            Stage stage = (Stage) exitMenu.getScene().getWindow();
            Scene scene = new Scene(mainCallWindowFXML, 600, 400, Color.TRANSPARENT);
            scene.getStylesheets().add("style.css");
            stage.setScene(scene);
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
            Parent mainCallWindowFXML = loader.load();
            Stage stage = (Stage) exitMenu.getScene().getWindow();
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
        exitMenu.setOnMouseClicked(e -> Platform.exit());

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
        if (helpPopup == null) {
            Popup popup = new Popup();
            popup.setX(100);
            popup.setY(200);
            Label label = new Label("The Farmhouse Company Data Manager software\n" +
                    "provides ease of access to sensitive clientele and\n " +
                    "employee information. It allows for effortless\n" +
                    "storage and modification of company records.\n\n" +
                    "Please speak to management regarding any questions\nor contact our developer team:\n\n");
            label.setTextAlignment(TextAlignment.CENTER);
            label.setTextFill(Paint.valueOf("white"));
            label.setStyle("-fx-label-padding: 10 10 10 10");
            Label label2 = new Label("        rphillip@mail.umw.edu\n" +
                    "        jhewitt2@mail.umw.edu\n" +
                    "        jvogtli@mail.umw.edu");
            label2.setTextAlignment(TextAlignment.CENTER);
            label2.setTextFill(Paint.valueOf("blue"));
            label2.setStyle("-fx-label-padding: 30 0 20 60");

            VBox vBox = new VBox(label, label2);
            popup.getContent().add(vBox);
            helpPopup = popup;
            helpPopup.show(exitMenu.getScene().getWindow());
        }
    }
}
