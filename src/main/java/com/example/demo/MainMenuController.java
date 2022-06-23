package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController extends Controller implements Initializable {

    private Stage stage;
    private Scene scene;

    @FXML
    private Button homeButton;

    @FXML
    private ImageView mouthpieceIcon;

    @FXML
    void entered(MouseEvent event) {
        ImageView imageView = (ImageView) event.getSource();
        imageView.setStyle("-fx-opacity: .5");
    }

    @FXML
    void exited(MouseEvent event) {
        ImageView imageView = (ImageView) event.getSource();
        imageView.setStyle("-fx-opacity: 1");
    }

    @FXML
    void helpScene(ActionEvent event) throws IOException {
        super.helpScene(mouthpieceIcon);
    }

    @FXML
    void aboutScene(ActionEvent event) throws IOException {
        super.aboutScene(mouthpieceIcon);
    }

    @FXML
    void newClient(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Controller.class.getResource("NewProfile.fxml"));
        Parent mainCallWindowFXML = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(mainCallWindowFXML, 900, 650, Color.TRANSPARENT);
        scene.getStylesheets().add("ProfileStyle.css");
        stage.setScene(scene);
        stage.centerOnScreen();
    }

    @FXML
    void returnHome(ActionEvent event) throws IOException {
        super.returnHome(event);
    }

    @FXML
    void select(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Controller.class.getResource("SelectScene.fxml"));
        Parent mainCallWindowFXML = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(mainCallWindowFXML, 900, 650, Color.TRANSPARENT);
        scene.getStylesheets().add("selectStyle.css");
        stage.setScene(scene);
        stage.centerOnScreen();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        homeButton.setDisable(true);
        homeButton.setStyle("-fx-background-color: blue");
    }
}