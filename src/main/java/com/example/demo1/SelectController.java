package com.example.demo1;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;

import javax.xml.transform.Result;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.ResourceBundle;

public class SelectController extends Controller implements Initializable {

    Hashtable identifiers = new Hashtable<>();
    private static ArrayList<String> names = new ArrayList<>();
    private Stage stage;
    private Scene scene;

    @FXML
    private ListView<String> listView;

    @FXML
    private TextField searchBar;

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

    @FXML
    void enter(KeyEvent event) throws SQLException {
        switch (event.getCode()) {
            case ENTER:
                names.clear();
                listView.getItems().clear();
                displayNames();
                break;
        }
    }

    private void displayNames() throws SQLException {
        boolean results = false;

        String host = "jdbc:mysql://localhost:3306/theearnhartcompany";
        String user = "Ryan";
        String password = "aTundeAdjuah_22!";

        String userText = searchBar.getText();
        String firstName = "";
        String lastName = "";
        String name = "";
        String id = "";

        Connection connection = DriverManager.getConnection(host, user, password);
        PreparedStatement statement = connection.prepareStatement("select * from clientprofile where FName <> 'null'");
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            firstName = ("" + resultSet.getObject("FName"));
            lastName = ("" + resultSet.getObject("LName"));
            id = ("" + resultSet.getObject("ClientID"));
            name = lastName + ", " + firstName;

            if (name.contains(userText)) {
                results = true;
                identifiers.put(name,id);
                listView.getItems().add(name);
            }
        }

        if (results) {
            for (int i = 0; i < names.size(); i++) {
                listView.getItems().add(names.get(i));
            }
        }
    }

    @FXML
    void select(MouseEvent event) {

        String selectedName = listView.getSelectionModel().getSelectedItem();
        String clientID = (String) identifiers.get(selectedName);

        if (selectedName == null) {
            //DO NOTHING
        } else {
            String host = "jdbc:mysql://localhost:3306/theearnhartcompany";
            String user = "Ryan";
            String password = "aTundeAdjuah_22!";

            String firstName = "";
            String lastName = "";
            String phone = "";
            String email = "";
            String address = "";
            String consultation = "";
            String cID = Profile.getClientID();

            try {
                Connection connection = DriverManager.getConnection(host, user, password);
                PreparedStatement preparedStatement = connection.prepareStatement("select * from clientprofile where clientID = '" + clientID + "'");
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    phone = ("" + resultSet.getObject("Phone"));
                    email = ("" + resultSet.getObject("Email"));
                    address = ("" + resultSet.getObject("Address"));
                    firstName = ("" + resultSet.getObject("FName"));
                    lastName = ("" + resultSet.getObject("LName"));
                    consultation = ("" + resultSet.getObject("Consultation"));
                    cID = ("" + resultSet.getObject("ClientID"));
                }

                Profile.setPhone(phone);
                Profile.setAddress(address);
                Profile.setEmail(email);
                Profile.setFirstName(firstName);
                Profile.setLastName(lastName);
                Profile.setConsultation(consultation);
                Profile.setClientID(cID);

            } catch (SQLException e) {
                System.out.println("ERROR -- CANNOT CONNECT TO DATABASE");
            }

            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("ClientMenu.fxml"));
            } catch (IOException e) {
                Platform.exit();
            }
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root, 900, 650, Color.TRANSPARENT);
            scene.getStylesheets().add("clientMenuStyle.css");
            stage.setScene(scene);
            stage.setTitle("The Earnhart Company");
            stage.show();
            stage.centerOnScreen();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        helpButton.setDisable(true);
        helpButton.setStyle("-fx-background-color: blue");
    }
}