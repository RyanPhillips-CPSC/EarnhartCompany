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

        String jdbcURL = "jdbc:h2:C:/Users/ryanp/Desktop/EarnhartLLC - Copy/datab/default;OLD_INFORMATION_SCHEMA=TRUE";
        String username = "";
        String password = "";

        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            PreparedStatement preparedStatementOne = connection.prepareStatement("SET SCHEMA TWO");
            preparedStatementOne.execute();
            PreparedStatement statement = connection.prepareStatement("SELECT consultation FROM CLIENTPROFILE WHERE email = '" + Profile.getEmail() + "'");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                consultation = ("" + resultSet.getObject("consultation"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (consultation.contains("clob")) {
            boolean cont = true;
            int index = 0;
            while (cont) {
                if (consultation.charAt(index) == ':') {
                    cont = false;
                }
                index++;
            }
            consultation = consultation.substring(index + 2);
            int split =  consultation.length();
            consultation = consultation.substring(0, split - 1);
        }

        if (consultation.charAt(0) == '\'') {
            consultation = consultation.substring(1);
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
        String jdbcURL = "jdbc:h2:C:/Users/ryanp/Desktop/EarnhartLLC - Copy/datab/default;OLD_INFORMATION_SCHEMA=TRUE";
        String username = "";
        String password = "";
        String newText = mainTextArea.getText().strip();

        if (newText.equals("")) {
            newText = "null";
        }

        Connection connection = DriverManager.getConnection(jdbcURL, username, password);
        PreparedStatement preparedStatementOne = connection.prepareStatement("SET SCHEMA TWO");
        preparedStatementOne.execute();
        PreparedStatement statement = connection.prepareStatement("UPDATE CLIENTPROFILE SET consultation = '" + newText + "' WHERE email = '" + Profile.getEmail() + "'");
        statement.executeUpdate();

        clientMenu(event);
    }
}
