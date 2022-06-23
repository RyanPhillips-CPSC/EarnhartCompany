package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConsultationController extends Controller implements Initializable {

    private Stage stage;
    private Scene scene;

    @FXML
    private Label clientLabel;

    @FXML
    private Label invalidLabel;

    @FXML
    private TextArea mainTextArea;

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
        clientLabel.setText(Profile.getLastName() + ", " + Profile.getFirstName());
        invalidLabel.setVisible(false);
    }

    @FXML
    void submit(ActionEvent event) throws SQLException, IOException {
        String jdbcURL = "jdbc:h2:C:/Users/ryanp/Desktop/EarnhartLLC - Copy/datab/default;OLD_INFORMATION_SCHEMA=TRUE";
        String username = "";
        String password = "";

        String x = mainTextArea.getText();

        if (x.equals("")) {
            invalidLabel.setVisible(true);
        } else {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            PreparedStatement preparedStatementOne = connection.prepareStatement("SET SCHEMA TWO");
            preparedStatementOne.execute();
            PreparedStatement statement = connection.prepareStatement("UPDATE CLIENTPROFILE SET consultation = '" + x + "' WHERE email = '" + Profile.getEmail() + "'");
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
