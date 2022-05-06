package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class ConsultationController extends Controller implements Initializable {

    private Stage stage;
    private Scene scene;

    @FXML
    private Label invalidLabel;

    @FXML
    private Label updateLabel;

    @FXML
    private TextArea mainTextArea;

    @FXML
    private Button aboutButton;

    @FXML
    private BorderPane border;

    @FXML
    private Pane centerPane;

    @FXML
    private VBox centerVBox;

    @FXML
    private Label clientLabel;

    @FXML
    private VBox contentBox;

    @FXML
    private ChoiceBox<String> dropDown;

    @FXML
    private Button helpButton;

    @FXML
    private Button homeButton;

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
    private ImageView profileImage;

    @FXML
    private Pane rightPane;

    @FXML
    private Button settingsButton;

    @FXML
    private ToolBar toolBar;

    @FXML
    private Label topRightLabel;

    @FXML
    private HBox updateHBox;

    @FXML
    private TextField updateText;

    @FXML
    private Label versionLabel;


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
        invalidLabel.setVisible(false);
    }

    @FXML
    void submit(ActionEvent event) throws SQLException, IOException {
        String host = "jdbc:mysql://localhost:3306/theearnhartcompany";
        String user = "Ryan";
        String password = "aTundeAdjuah_22!";

        String x = mainTextArea.getText();
        if (x.equals("")) {
            invalidLabel.setVisible(true);
        } else {
            Connection connection = DriverManager.getConnection(host, user, password);
            PreparedStatement statement = connection.prepareStatement("update clientprofile set Consultation = '" + x + "' where Email = '" + Profile.getEmail() + "'");
            statement.executeUpdate();
        }

        FXMLLoader loader = new FXMLLoader(Controller.class.getResource("ClientMenu.fxml"));
        Parent mainCallWindowFXML = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(mainCallWindowFXML, 900, 650, Color.TRANSPARENT);
        scene.getStylesheets().add("clientMenuStyle.css");
        stage.setScene(scene);
        stage.centerOnScreen();
    }
}
