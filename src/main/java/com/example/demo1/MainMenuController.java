package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController extends Controller implements Initializable {

    private Stage stage;
    private Scene scene;

    @FXML
    private HBox updateHBox;

    @FXML
    private HBox hBox1;

    @FXML
    private HBox hBox2;

    @FXML
    private Label versionLabel;

    @FXML
    private VBox leftColumn;

    @FXML
    private Pane rightPane;

    @FXML
    private ToolBar toolBar;

    @FXML
    private VBox centralVBox;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        homeButton.setDisable(true);
        homeButton.setStyle("-fx-background-color: blue");
    }
}