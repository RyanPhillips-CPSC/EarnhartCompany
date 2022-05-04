package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelpSceneController extends Controller implements Initializable {

    @FXML
    private Label versionLabel;

    @FXML
    private VBox leftColumn;

    @FXML
    private Pane rightPane;

    @FXML
    private ToolBar toolBar;

    @FXML
    private ImageView logoImage;

    @FXML
    private Label optionLabel;

    @FXML
    private BorderPane border;

    @FXML
    private Pane centerPane;

    @FXML
    private VBox centerVBox;

    @FXML
    private VBox clientHBox;

    @FXML
    private Button helpButton;

    @FXML
    private Button homeButton;

    @FXML
    private ImageView imageButton1;

    @FXML
    private ImageView imageButton2;

    @FXML
    private ImageView imageButton3;

    @FXML
    private Label mainLogo;

    @FXML
    private HBox menuHBox;

    @FXML
    private ImageView mouthpieceIcon;

    @FXML
    private Label nameLabel;

    @FXML
    private Label nameLabel2;

    @FXML
    private VBox ordersHBox;

    @FXML
    private HBox otherHBox;

    @FXML
    private VBox productHBox;

    @FXML
    private Button settingsButton;

    @FXML
    private Label topRightLabel;

    @FXML
    void helpScene(ActionEvent event) throws IOException {
        super.helpScene(mouthpieceIcon);
    }

    @FXML
    void returnHome(ActionEvent event) throws IOException {
        super.returnHome(event);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        homeButton.setDisable(false);
        homeButton.setStyle("-fx-background-color: white");
        helpButton.setDisable(true);
        helpButton.setStyle("-fx-background-color: blue");
    }
}