package com.example.demo1;

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
import java.sql.*;
import java.util.ResourceBundle;

public class EditConsultationController extends Controller implements Initializable {

    private Stage stage;
    private Scene scene;

    @FXML
    private Label invalidLabel;

    @FXML
    private TextArea mainTextArea;

    @FXML
    private Label clientLabel;

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

    @FXML
    void clientMenu(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Controller.class.getResource("ClientMenu.fxml"));
        Parent mainCallWindowFXML = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(mainCallWindowFXML, 900, 650, Color.TRANSPARENT);
        scene.getStylesheets().add("clientMenuStyle.css");
        stage.setScene(scene);
        stage.centerOnScreen();
    }

    public void setMainTextArea() {
        clientLabel.setText(Profile.getLastName() + ", " + Profile.getFirstName());

        String consultation = "";
        String email = "";

        String host = "jdbc:mysql://localhost:3306/theearnhartcompany";
        String user = "Ryan";
        String password = "aTundeAdjuah_22!";

        try {
            Connection connection = DriverManager.getConnection(host, user, password);
            PreparedStatement statement = connection.prepareStatement("select Consultation from clientprofile where Email = '" + Profile.getEmail() + "'");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                consultation = ("" + resultSet.getObject("Consultation"));
            }
        } catch (SQLException e) {
            System.out.println("" + e + "");
        }

        if (!(consultation.equals("null"))) {
            mainTextArea.setText(consultation);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        invalidLabel.setVisible(false);
        clientLabel.setText(Profile.getLastName() + ", " + Profile.getFirstName());
        setMainTextArea();
    }

    @FXML
    void submit(ActionEvent event) throws SQLException, IOException {
        String host = "jdbc:mysql://localhost:3306/theearnhartcompany";
        String user = "Ryan";
        String password = "aTundeAdjuah_22!";
        String newText = mainTextArea.getText().strip();

        if (mainTextArea.equals("")) {
            invalidLabel.setVisible(true);
        } else {
            Connection connection = DriverManager.getConnection(host, user, password);
            PreparedStatement statement = connection.prepareStatement("update clientprofile set Consultation = '" + newText + "' where Email = '" + Profile.getEmail() + "'");
            statement.executeUpdate();
        }
        clientMenu(event);
    }
}
