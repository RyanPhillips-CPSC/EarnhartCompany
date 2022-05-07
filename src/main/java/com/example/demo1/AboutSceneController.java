package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AboutSceneController extends Controller implements Initializable {

    @FXML
    private Button aboutButton;

    @FXML
    private ImageView mouthpieceIcon;


    @FXML
    void helpScene(ActionEvent event) throws IOException {
        super.helpScene(mouthpieceIcon);
    }

    @FXML
    void aboutScene(ActionEvent event) throws IOException {
        super.aboutScene(mouthpieceIcon);
    }

    @FXML
    void returnHome(ActionEvent event) throws IOException {
        super.returnHome(event);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        aboutButton.setDisable(true);
        aboutButton.setStyle("-fx-background-color: blue");
    }
}