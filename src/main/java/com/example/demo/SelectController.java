package com.example.demo;

import javafx.application.Platform;
import javafx.event.ActionEvent;
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

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Hashtable;
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

        String jdbcURL = "jdbc:h2:C:/Users/ryanp/Desktop/EarnhartLLC - Copy/datab/default;OLD_INFORMATION_SCHEMA=TRUE";
        String username = "";
        String password = "";

        String userText = searchBar.getText();
        String firstName = "";
        String lastName = "";
        String name = "";
        String id = "";

        Connection connection = DriverManager.getConnection(jdbcURL, username, password);
        PreparedStatement preparedStatementOne = connection.prepareStatement("SET SCHEMA TWO");
        preparedStatementOne.execute();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM CLIENTPROFILE WHERE firstname IS NOT NULL");
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            firstName = ("" + resultSet.getObject("firstname"));
            lastName = ("" + resultSet.getObject("lastname"));
            id = ("" + resultSet.getObject("clientID"));
            name = lastName + ", " + firstName;

            if (name.contains(userText)) {
                results = true;
                identifiers.put(name,id);
                listView.getItems().add(name);
            }
        }

        if (results) {
            for (String s : names) {
                listView.getItems().add(s);
            }
        }
    }

    @FXML
    void select(MouseEvent event) {

        String selectedName = listView.getSelectionModel().getSelectedItem();
        String clID = (String) identifiers.get(selectedName);

        boolean cont = true;
        int index = 0;
        while (cont) {
            if (clID.charAt(index) == ':') {
                cont = false;
            }
            index++;
        }
        String clientID = clID.substring(index + 2);
        int split = clientID.length();
        clientID = clientID.substring(0,split - 1);

        if (selectedName == null) {
            //DO NOTHING
        } else {
            String jdbcURL = "jdbc:h2:C:/Users/ryanp/Desktop/EarnhartLLC - Copy/datab/default;OLD_INFORMATION_SCHEMA=TRUE";
            String username = "";
            String password = "";

            String firstName = "";
            String lastName = "";
            String phone = "";
            String email = "";
            String address = "";
            String consultation = "";
            String cID = Profile.getClientID();

            try {
                Connection connection = DriverManager.getConnection(jdbcURL, username, password);
                PreparedStatement preparedStatementOne = connection.prepareStatement("SET SCHEMA TWO");
                preparedStatementOne.execute();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM CLIENTPROFILE WHERE clientID = '" + clientID + "'");
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    firstName = ("" + resultSet.getObject("firstname"));
                    lastName = ("" + resultSet.getObject("lastname"));
                    phone = ("" + resultSet.getObject("phone"));
                    email = ("" + resultSet.getObject("email"));
                    address = ("" + resultSet.getObject("address"));
                    consultation = ("" + resultSet.getObject("consultation"));
                    cID = ("" + resultSet.getObject("clientID"));
                }

                Profile.setPhone(phone);
                Profile.setAddress(address);
                Profile.setEmail(email);
                Profile.setFirstName(firstName);
                Profile.setLastName(lastName);
                Profile.setConsultation(consultation);
                Profile.setClientID(cID);
            } catch (SQLException e) {
                e.printStackTrace();
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