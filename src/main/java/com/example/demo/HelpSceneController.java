package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelpSceneController extends Controller implements Initializable {

    @FXML
    private Button helpButton;

    @FXML
    private ImageView mouthpieceIcon;

    @FXML
    void helpScene(ActionEvent event) throws IOException {
        super.helpScene(mouthpieceIcon);
    }

    @FXML
    void returnHome(ActionEvent event) throws IOException {
        super.returnHome(event);
    }

    @FXML
    void aboutScene(ActionEvent event) throws IOException {
        super.aboutScene(mouthpieceIcon);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        helpButton.setDisable(true);
        helpButton.setStyle("-fx-background-color: blue");
    }
}