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
import javafx.scene.control.TextField;
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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ClientMenuController extends Controller implements Initializable {

    private Stage stage;
    private Scene scene;

    @FXML
    private Label clientLabel;

    @FXML
    private Button aboutButton;

    @FXML
    private TextField addressText;

    @FXML
    private Label boldLabel;

    @FXML
    private BorderPane border;

    @FXML
    private Label centerLabel;

    @FXML
    private Pane centerPane;

    @FXML
    private VBox centerVBox;

    @FXML
    private VBox contentBox;

    @FXML
    private TextField emailText;

    @FXML
    private TextField fNameText;

    @FXML
    private Button helpButton;

    @FXML
    private Button homeButton;

    @FXML
    private Label invalidLabel;

    @FXML
    private TextField lNameText;

    @FXML
    private VBox leftColumn;

    @FXML
    private ImageView logoImage;

    @FXML
    private Label mainLogo;

    @FXML
    private HBox menuHBox;

    @FXML
    private ImageView mouthpieceIcon;

    @FXML
    private Label optionLabel;

    @FXML
    private TextField phoneText;

    @FXML
    private ImageView profileImage;

    @FXML
    private Pane rightPane;

    @FXML
    private Button settingsButton;

    @FXML
    private Button submitButton;

    @FXML
    private ToolBar toolBar;

    @FXML
    private Label topRightLabel;

    @FXML
    private VBox vBoxProfile;

    @FXML
    private Label versionLabel;

    @FXML
    void consultation(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Controller.class.getResource("Consultation.fxml"));
        Parent mainCallWindowFXML = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(mainCallWindowFXML, 900, 650, Color.TRANSPARENT);
        scene.getStylesheets().add("consultationStyle.css");
        stage.setScene(scene);
        stage.centerOnScreen();
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
    void returnHome(ActionEvent event) throws IOException {
        super.returnHome(event);
    }

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clientLabel.setText(Profile.getLastName() + ", " + Profile.getFirstName());
    }

    @FXML
    void editProfile(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Controller.class.getResource("EditProfile.fxml"));
        Parent mainCallWindowFXML = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(mainCallWindowFXML, 900, 650, Color.TRANSPARENT);
        scene.getStylesheets().add("editProfileStyle.css");
        stage.setScene(scene);
        stage.centerOnScreen();
    }
}