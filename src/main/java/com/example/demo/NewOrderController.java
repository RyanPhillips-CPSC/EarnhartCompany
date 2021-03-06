package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class NewOrderController extends Controller implements Initializable {

    private int itemQuantity;
    private boolean generated = false;
    private String updateOrderNumber;
    private Stage stage;
    private Scene scene;

    @FXML
    private TextField autoCAD;

    @FXML
    private Button generateButton;

    @FXML
    private Label clientLabel;

    @FXML
    private Label invalidLabel;

    @FXML
    private ComboBox<String> invoicePaid;

    @FXML
    private ComboBox<String> invoiceSent;

    @FXML
    private ImageView mouthpieceIcon;

    @FXML
    private Label orderNumber;

    @FXML
    private TextField refundDate;

    @FXML
    private ComboBox<String> refunded;

    @FXML
    private TextField shipDate;

    @FXML
    private ComboBox<String> shipped;

    @FXML
    private Button submitButton;

    @FXML
    private GridPane gridPane10;

    @FXML
    private GridPane gridPane11;

    @FXML
    private GridPane gridPane2;

    @FXML
    private GridPane gridPane3;

    @FXML
    private GridPane gridPane4;

    @FXML
    private GridPane gridPane5;

    @FXML
    private GridPane gridPane6;

    @FXML
    private GridPane gridPane7;

    @FXML
    private GridPane gridPane8;

    @FXML
    private GridPane gridPane9;

    @FXML
    private ComboBox<String> itemDropDown;

    @FXML
    private TextField priceText1;

    @FXML
    private TextField priceText10;

    @FXML
    private TextField priceText2;

    @FXML
    private TextField priceText3;

    @FXML
    private TextField priceText4;

    @FXML
    private TextField priceText5;

    @FXML
    private TextField priceText6;

    @FXML
    private TextField priceText7;

    @FXML
    private TextField priceText8;

    @FXML
    private TextField priceText9;

    @FXML
    private TextField itemText1;

    @FXML
    private TextField itemText10;

    @FXML
    private TextField itemText2;

    @FXML
    private TextField itemText3;

    @FXML
    private TextField itemText4;

    @FXML
    private TextField itemText5;

    @FXML
    private TextField itemText6;

    @FXML
    private TextField itemText7;

    @FXML
    private TextField itemText8;

    @FXML
    private TextField itemText9;


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

    @FXML
    void generateItems(ActionEvent event) throws SQLException {
        if (generated) {
            addItems(event);
        } else {
            if (itemDropDown.getSelectionModel().isEmpty()) {
                invalidLabel.setVisible(true);
            } else {
                String item = itemDropDown.getSelectionModel().getSelectedItem();
                itemQuantity = Integer.parseInt(item);

                switch (item) {
                    case "1":
                        gridPane11.setVisible(true);
                        break;
                    case "2":
                        gridPane11.setVisible(true);
                        gridPane2.setVisible(true);
                        break;
                    case "3":
                        gridPane11.setVisible(true);
                        gridPane2.setVisible(true);
                        gridPane3.setVisible(true);
                        break;
                    case "4":
                        gridPane11.setVisible(true);
                        gridPane2.setVisible(true);
                        gridPane3.setVisible(true);
                        gridPane4.setVisible(true);
                        break;
                    case "5":
                        gridPane11.setVisible(true);
                        gridPane2.setVisible(true);
                        gridPane3.setVisible(true);
                        gridPane4.setVisible(true);
                        gridPane5.setVisible(true);
                        break;
                    case "6":
                        gridPane11.setVisible(true);
                        gridPane2.setVisible(true);
                        gridPane3.setVisible(true);
                        gridPane4.setVisible(true);
                        gridPane5.setVisible(true);
                        gridPane6.setVisible(true);
                        break;
                    case "7":
                        gridPane11.setVisible(true);
                        gridPane2.setVisible(true);
                        gridPane3.setVisible(true);
                        gridPane4.setVisible(true);
                        gridPane5.setVisible(true);
                        gridPane6.setVisible(true);
                        gridPane7.setVisible(true);
                        break;
                    case "8":
                        gridPane11.setVisible(true);
                        gridPane2.setVisible(true);
                        gridPane3.setVisible(true);
                        gridPane4.setVisible(true);
                        gridPane5.setVisible(true);
                        gridPane6.setVisible(true);
                        gridPane7.setVisible(true);
                        gridPane8.setVisible(true);
                        break;
                    case "9":
                        gridPane11.setVisible(true);
                        gridPane2.setVisible(true);
                        gridPane3.setVisible(true);
                        gridPane4.setVisible(true);
                        gridPane5.setVisible(true);
                        gridPane6.setVisible(true);
                        gridPane7.setVisible(true);
                        gridPane8.setVisible(true);
                        gridPane9.setVisible(true);
                        break;
                    case "10":
                        gridPane11.setVisible(true);
                        gridPane2.setVisible(true);
                        gridPane3.setVisible(true);
                        gridPane4.setVisible(true);
                        gridPane5.setVisible(true);
                        gridPane6.setVisible(true);
                        gridPane7.setVisible(true);
                        gridPane8.setVisible(true);
                        gridPane9.setVisible(true);
                        gridPane10.setVisible(true);
                        break;
                }
                generated = true;
                generateButton.setText("Add");
                generateButton.setStyle("-fx-translate-x: 23");
                itemDropDown.setDisable(true);
            }
        }
    }

    private void addItems(ActionEvent event) throws SQLException {
        String host = "jdbc:mysql://localhost:3306/theearnhartcompany";
        String user = "Ryan";
        String password = "aTundeAdjuah_22!";

        Connection connection = null;
        PreparedStatement statement = null;
        boolean valid = false;
        boolean goodDouble = false;

        double p1 = 0;double p2 = 0;double p3 = 0;double p4 = 0;double p5 = 0;
        double p6 = 0;double p10 = 0;double p7 = 0;double p8 = 0;double p9 = 0;


        switch (itemQuantity) {
            case 1:
                try {
                    p1 = Double.parseDouble(priceText1.getText());
                    goodDouble = true;
                } catch (NumberFormatException i) {
                }
                break;
            case 2:
                p1 = Double.parseDouble(priceText1.getText());
                p2 = Double.parseDouble(priceText1.getText());
                goodDouble = true;
                break;
            case 3:
                p1 = Double.parseDouble(priceText1.getText());
                p2 = Double.parseDouble(priceText1.getText());
                p3 = Double.parseDouble(priceText1.getText());
                goodDouble = true;
                break;
            case 4:
                p1 = Double.parseDouble(priceText1.getText());
                p2 = Double.parseDouble(priceText1.getText());
                p3 = Double.parseDouble(priceText1.getText());
                p4 = Double.parseDouble(priceText1.getText());
                goodDouble = true;
                break;
            case 5:
                p1 = Double.parseDouble(priceText1.getText());
                p2 = Double.parseDouble(priceText1.getText());
                p3 = Double.parseDouble(priceText1.getText());
                p4 = Double.parseDouble(priceText1.getText());
                p5 = Double.parseDouble(priceText1.getText());
                goodDouble = true;
                break;
            case 6:
                p1 = Double.parseDouble(priceText1.getText());
                p2 = Double.parseDouble(priceText1.getText());
                p3 = Double.parseDouble(priceText1.getText());
                p4 = Double.parseDouble(priceText1.getText());
                p5 = Double.parseDouble(priceText1.getText());
                p6 = Double.parseDouble(priceText1.getText());
                goodDouble = true;
                break;
            case 7:
                p1 = Double.parseDouble(priceText1.getText());
                p2 = Double.parseDouble(priceText1.getText());
                p3 = Double.parseDouble(priceText1.getText());
                p4 = Double.parseDouble(priceText1.getText());
                p5 = Double.parseDouble(priceText1.getText());
                p6 = Double.parseDouble(priceText1.getText());
                p7 = Double.parseDouble(priceText1.getText());
                goodDouble = true;
                break;
            case 8:
                p1 = Double.parseDouble(priceText1.getText());
                p2 = Double.parseDouble(priceText1.getText());
                p3 = Double.parseDouble(priceText1.getText());
                p4 = Double.parseDouble(priceText1.getText());
                p5 = Double.parseDouble(priceText1.getText());
                p6 = Double.parseDouble(priceText1.getText());
                p7 = Double.parseDouble(priceText1.getText());
                p8 = Double.parseDouble(priceText1.getText());
                goodDouble = true;
                break;
            case 9:
                p1 = Double.parseDouble(priceText1.getText());
                p2 = Double.parseDouble(priceText1.getText());
                p3 = Double.parseDouble(priceText1.getText());
                p4 = Double.parseDouble(priceText1.getText());
                p5 = Double.parseDouble(priceText1.getText());
                p6 = Double.parseDouble(priceText1.getText());
                p7 = Double.parseDouble(priceText1.getText());
                p8 = Double.parseDouble(priceText1.getText());
                p9 = Double.parseDouble(priceText1.getText());
                goodDouble = true;
                break;
            case 10:
                p1 = Double.parseDouble(priceText1.getText());
                p2 = Double.parseDouble(priceText1.getText());
                p3 = Double.parseDouble(priceText1.getText());
                p4 = Double.parseDouble(priceText1.getText());
                p5 = Double.parseDouble(priceText1.getText());
                p6 = Double.parseDouble(priceText1.getText());
                p7 = Double.parseDouble(priceText1.getText());
                p8 = Double.parseDouble(priceText1.getText());
                p9 = Double.parseDouble(priceText1.getText());
                p10 = Double.parseDouble(priceText1.getText());
                goodDouble = true;
                break;
        }

        if (goodDouble) {
            switch (itemQuantity) {
                case 1:
                    if (!(itemText1.getText().equals("") || priceText1.getText().equals(""))) {
                        valid = true;
                    }
                    break;
                case 2:
                    if (!(itemText1.getText().equals("") || priceText1.getText().equals("") ||
                            itemText2.getText().equals("") || priceText2.getText().equals(""))) {
                        valid = true;
                    }
                    break;
                case 3:
                    if (!(itemText1.getText().equals("") || priceText1.getText().equals("") ||
                            itemText2.getText().equals("") || priceText2.getText().equals("") ||
                            itemText3.getText().equals("") || priceText3.getText().equals(""))) {
                        valid = true;
                    }
                    break;
                case 4:
                    if (!(itemText1.getText().equals("") || priceText1.getText().equals("") ||
                            itemText2.getText().equals("") || priceText2.getText().equals("") ||
                            itemText3.getText().equals("") || priceText3.getText().equals("") ||
                            itemText4.getText().equals("") || priceText4.getText().equals(""))) {
                        valid = true;
                    }
                    break;
                case 5:
                    if (!(itemText1.getText().equals("") || priceText1.getText().equals("") ||
                            itemText2.getText().equals("") || priceText2.getText().equals("") ||
                            itemText3.getText().equals("") || priceText3.getText().equals("") ||
                            itemText4.getText().equals("") || priceText4.getText().equals("") ||
                            itemText5.getText().equals("") || priceText5.getText().equals(""))) {
                        valid = true;
                    }
                    break;
                case 6:
                    if (!(itemText1.getText().equals("") || priceText1.getText().equals("") ||
                            itemText2.getText().equals("") || priceText2.getText().equals("") ||
                            itemText3.getText().equals("") || priceText3.getText().equals("") ||
                            itemText4.getText().equals("") || priceText4.getText().equals("") ||
                            itemText5.getText().equals("") || priceText5.getText().equals("") ||
                            itemText6.getText().equals("") || priceText6.getText().equals(""))) {
                        valid = true;
                    }
                    break;
                case 7:
                    if (!(itemText1.getText().equals("") || priceText1.getText().equals("") ||
                            itemText2.getText().equals("") || priceText2.getText().equals("") ||
                            itemText3.getText().equals("") || priceText3.getText().equals("") ||
                            itemText4.getText().equals("") || priceText4.getText().equals("") ||
                            itemText5.getText().equals("") || priceText5.getText().equals("") ||
                            itemText6.getText().equals("") || priceText6.getText().equals("") ||
                            itemText7.getText().equals("") || priceText7.getText().equals(""))) {
                        valid = true;
                    }
                    break;
                case 8:
                    if (!(itemText1.getText().equals("") || priceText1.getText().equals("") ||
                            itemText2.getText().equals("") || priceText2.getText().equals("") ||
                            itemText3.getText().equals("") || priceText3.getText().equals("") ||
                            itemText4.getText().equals("") || priceText4.getText().equals("") ||
                            itemText5.getText().equals("") || priceText5.getText().equals("") ||
                            itemText6.getText().equals("") || priceText6.getText().equals("") ||
                            itemText7.getText().equals("") || priceText7.getText().equals("") ||
                            itemText8.getText().equals("") || priceText8.getText().equals(""))) {
                        valid = true;
                    }
                    break;
                case 9:
                    if (!(itemText1.getText().equals("") || priceText1.getText().equals("") ||
                            itemText2.getText().equals("") || priceText2.getText().equals("") ||
                            itemText3.getText().equals("") || priceText3.getText().equals("") ||
                            itemText4.getText().equals("") || priceText4.getText().equals("") ||
                            itemText5.getText().equals("") || priceText5.getText().equals("") ||
                            itemText6.getText().equals("") || priceText6.getText().equals("") ||
                            itemText7.getText().equals("") || priceText7.getText().equals("") ||
                            itemText8.getText().equals("") || priceText8.getText().equals("") ||
                            itemText9.getText().equals("") || priceText9.getText().equals(""))) {
                        valid = true;
                    }
                    break;
                case 10:
                    if (!(itemText1.getText().equals("") || priceText1.getText().equals("") ||
                            itemText2.getText().equals("") || priceText2.getText().equals("") ||
                            itemText3.getText().equals("") || priceText3.getText().equals("") ||
                            itemText4.getText().equals("") || priceText4.getText().equals("") ||
                            itemText5.getText().equals("") || priceText5.getText().equals("") ||
                            itemText6.getText().equals("") || priceText6.getText().equals("") ||
                            itemText7.getText().equals("") || priceText7.getText().equals("") ||
                            itemText8.getText().equals("") || priceText8.getText().equals("") ||
                            itemText9.getText().equals("") || priceText9.getText().equals("") ||
                            itemText10.getText().equals("") || priceText10.getText().equals(""))) {
                        valid = true;
                    }
                    break;
            }
        }

        if ((valid) && (goodDouble)) {
            switch (itemQuantity) {

                case 1:
                    connection = DriverManager.getConnection(host, user, password);
                    statement = connection.prepareStatement("insert into items values ('" + itemText1.getText() + "', '" + p1 + "', '" + Profile.getClientID() + "', '" + updateOrderNumber + "')");
                    statement.executeUpdate();
                    break;
                case 2:
                    connection = DriverManager.getConnection(host, user, password);
                    statement = connection.prepareStatement("insert into items values ('" + itemText1.getText() + "', '" + p1 + "', '" + Profile.getClientID() + "', '" + updateOrderNumber + "')");
                    statement.executeUpdate();
                    statement = connection.prepareStatement("insert into items values ('" + itemText2.getText() + "', '" + p2 + "', '" + Profile.getClientID() + "', '" + updateOrderNumber + "')");
                    statement.executeUpdate();
                    break;
                case 3:
                    connection = DriverManager.getConnection(host, user, password);
                    statement = connection.prepareStatement("insert into items values ('" + itemText1.getText() + "', '" + p1 + "', '" + Profile.getClientID() + "', '" + updateOrderNumber + "')");
                    statement.executeUpdate();
                    statement = connection.prepareStatement("insert into items values ('" + itemText2.getText() + "', '" + p2 + "', '" + Profile.getClientID() + "', '" + updateOrderNumber + "')");
                    statement.executeUpdate();
                    statement = connection.prepareStatement("insert into items values ('" + itemText3.getText() + "', '" + p3 + "', '" + Profile.getClientID() + "', '" + updateOrderNumber + "')");
                    statement.executeUpdate();
                    break;
                case 4:
                    connection = DriverManager.getConnection(host, user, password);
                    statement = connection.prepareStatement("insert into items values ('" + itemText1.getText() + "', '" + p1 + "', '" + Profile.getClientID() + "', '" + updateOrderNumber + "')");
                    statement.executeUpdate();
                    statement = connection.prepareStatement("insert into items values ('" + itemText2.getText() + "', '" + p2 + "', '" + Profile.getClientID() + "', '" + updateOrderNumber + "')");
                    statement.executeUpdate();
                    statement = connection.prepareStatement("insert into items values ('" + itemText3.getText() + "', '" + p3 + "', '" + Profile.getClientID() + "', '" + updateOrderNumber + "')");
                    statement.executeUpdate();
                    statement = connection.prepareStatement("insert into items values ('" + itemText4.getText() + "', '" + p4 + "', '" + Profile.getClientID() + "', '" + updateOrderNumber + "')");
                    statement.executeUpdate();
                    break;
                case 5:
                    connection = DriverManager.getConnection(host, user, password);
                    statement = connection.prepareStatement("insert into items values ('" + itemText1.getText() + "', '" + p1 + "', '" + Profile.getClientID() + "', '" + updateOrderNumber + "')");
                    statement.executeUpdate();
                    statement = connection.prepareStatement("insert into items values ('" + itemText2.getText() + "', '" + p2 + "', '" + Profile.getClientID() + "', '" + updateOrderNumber + "')");
                    statement.executeUpdate();
                    statement = connection.prepareStatement("insert into items values ('" + itemText3.getText() + "', '" + p3 + "', '" + Profile.getClientID() + "', '" + updateOrderNumber + "')");
                    statement.executeUpdate();
                    statement = connection.prepareStatement("insert into items values ('" + itemText4.getText() + "', '" + p4 + "', '" + Profile.getClientID() + "', '" + updateOrderNumber + "')");
                    statement.executeUpdate();
                    statement = connection.prepareStatement("insert into items values ('" + itemText5.getText() + "', '" + p5 + "', '" + Profile.getClientID() + "', '" + updateOrderNumber + "')");
                    statement.executeUpdate();
                    break;
                case 6:
                    connection = DriverManager.getConnection(host, user, password);
                    statement = connection.prepareStatement("insert into items values ('" + itemText1.getText() + "', '" + p1 + "', '" + Profile.getClientID() + "', '" + updateOrderNumber + "')");
                    statement.executeUpdate();
                    statement = connection.prepareStatement("insert into items values ('" + itemText2.getText() + "', '" + p2 + "', '" + Profile.getClientID() + "', '" + updateOrderNumber + "')");
                    statement.executeUpdate();
                    statement = connection.prepareStatement("insert into items values ('" + itemText3.getText() + "', '" + p3 + "', '" + Profile.getClientID() + "', '" + updateOrderNumber + "')");
                    statement.executeUpdate();
                    statement = connection.prepareStatement("insert into items values ('" + itemText4.getText() + "', '" + p4 + "', '" + Profile.getClientID() + "', '" + updateOrderNumber + "')");
                    statement.executeUpdate();
                    statement = connection.prepareStatement("insert into items values ('" + itemText5.getText() + "', '" + p5 + "', '" + Profile.getClientID() + "', '" + updateOrderNumber + "')");
                    statement.executeUpdate();
                    statement = connection.prepareStatement("insert into items values ('" + itemText6.getText() + "', '" + p6 + "', '" + Profile.getClientID() + "', '" + updateOrderNumber + "')");
                    statement.executeUpdate();
                    break;
                case 7:
                    connection = DriverManager.getConnection(host, user, password);
                    statement = connection.prepareStatement("insert into items values ('" + itemText1.getText() + "', '" + p1 + "', '" + Profile.getClientID() + "', '" + updateOrderNumber + "')");
                    statement.executeUpdate();
                    statement = connection.prepareStatement("insert into items values ('" + itemText2.getText() + "', '" + p2 + "', '" + Profile.getClientID() + "', '" + updateOrderNumber + "')");
                    statement.executeUpdate();
                    statement = connection.prepareStatement("insert into items values ('" + itemText3.getText() + "', '" + p3 + "', '" + Profile.getClientID() + "', '" + updateOrderNumber + "')");
                    statement.executeUpdate();
                    statement = connection.prepareStatement("insert into items values ('" + itemText4.getText() + "', '" + p4 + "', '" + Profile.getClientID() + "', '" + updateOrderNumber + "')");
                    statement.executeUpdate();
                    statement = connection.prepareStatement("insert into items values ('" + itemText5.getText() + "', '" + p5 + "', '" + Profile.getClientID() + "', '" + updateOrderNumber + "')");
                    statement.executeUpdate();
                    statement = connection.prepareStatement("insert into items values ('" + itemText6.getText() + "', '" + p6 + "', '" + Profile.getClientID() + "', '" + updateOrderNumber + "')");
                    statement.executeUpdate();
                    statement = connection.prepareStatement("insert into items values ('" + itemText7.getText() + "', '" + p7 + "', '" + Profile.getClientID() + "', '" + updateOrderNumber + "')");
                    statement.executeUpdate();
                    break;
                case 8:
                    connection = DriverManager.getConnection(host, user, password);
                    statement = connection.prepareStatement("insert into items values ('" + itemText1.getText() + "', '" + p1 + "', '" + Profile.getClientID() + "', '" + updateOrderNumber + "')");
                    statement.executeUpdate();
                    statement = connection.prepareStatement("insert into items values ('" + itemText2.getText() + "', '" + p2 + "', '" + Profile.getClientID() + "', '" + updateOrderNumber + "')");
                    statement.executeUpdate();
                    statement = connection.prepareStatement("insert into items values ('" + itemText3.getText() + "', '" + p3 + "', '" + Profile.getClientID() + "', '" + updateOrderNumber + "')");
                    statement.executeUpdate();
                    statement = connection.prepareStatement("insert into items values ('" + itemText4.getText() + "', '" + p4 + "', '" + Profile.getClientID() + "', '" + updateOrderNumber + "')");
                    statement.executeUpdate();
                    statement = connection.prepareStatement("insert into items values ('" + itemText5.getText() + "', '" + p5 + "', '" + Profile.getClientID() + "', '" + updateOrderNumber + "')");
                    statement.executeUpdate();
                    statement = connection.prepareStatement("insert into items values ('" + itemText6.getText() + "', '" + p6 + "', '" + Profile.getClientID() + "', '" + updateOrderNumber + "')");
                    statement.executeUpdate();
                    statement = connection.prepareStatement("insert into items values ('" + itemText7.getText() + "', '" + p7 + "', '" + Profile.getClientID() + "', '" + updateOrderNumber + "')");
                    statement.executeUpdate();
                    statement = connection.prepareStatement("insert into items values ('" + itemText8.getText() + "', '" + p8 + "', '" + Profile.getClientID() + "', '" + updateOrderNumber + "')");
                    statement.executeUpdate();
                    break;
                case 9:
                    connection = DriverManager.getConnection(host, user, password);
                    statement = connection.prepareStatement("insert into items values ('" + itemText1.getText() + "', '" + p1 + "', '" + Profile.getClientID() + "', '" + updateOrderNumber + "')");
                    statement.executeUpdate();
                    statement = connection.prepareStatement("insert into items values ('" + itemText2.getText() + "', '" + p2 + "', '" + Profile.getClientID() + "', '" + updateOrderNumber + "')");
                    statement.executeUpdate();
                    statement = connection.prepareStatement("insert into items values ('" + itemText3.getText() + "', '" + p3 + "', '" + Profile.getClientID() + "', '" + updateOrderNumber + "')");
                    statement.executeUpdate();
                    statement = connection.prepareStatement("insert into items values ('" + itemText4.getText() + "', '" + p4 + "', '" + Profile.getClientID() + "', '" + updateOrderNumber + "')");
                    statement.executeUpdate();
                    statement = connection.prepareStatement("insert into items values ('" + itemText5.getText() + "', '" + p5 + "', '" + Profile.getClientID() + "', '" + updateOrderNumber + "')");
                    statement.executeUpdate();
                    statement = connection.prepareStatement("insert into items values ('" + itemText6.getText() + "', '" + p6 + "', '" + Profile.getClientID() + "', '" + updateOrderNumber + "')");
                    statement.executeUpdate();
                    statement = connection.prepareStatement("insert into items values ('" + itemText7.getText() + "', '" + p7 + "', '" + Profile.getClientID() + "', '" + updateOrderNumber + "')");
                    statement.executeUpdate();
                    statement = connection.prepareStatement("insert into items values ('" + itemText8.getText() + "', '" + p8 + "', '" + Profile.getClientID() + "', '" + updateOrderNumber + "')");
                    statement.executeUpdate();
                    statement = connection.prepareStatement("insert into items values ('" + itemText9.getText() + "', '" + p9 + "', '" + Profile.getClientID() + "', '" + updateOrderNumber + "')");
                    statement.executeUpdate();
                    break;
                case 10:
                    connection = DriverManager.getConnection(host, user, password);
                    statement = connection.prepareStatement("insert into items values ('" + itemText1.getText() + "', '" + p1 + "', '" + Profile.getClientID() + "', '" + updateOrderNumber + "')");
                    statement.executeUpdate();
                    statement = connection.prepareStatement("insert into items values ('" + itemText2.getText() + "', '" + p2 + "', '" + Profile.getClientID() + "', '" + updateOrderNumber + "')");
                    statement.executeUpdate();
                    statement = connection.prepareStatement("insert into items values ('" + itemText3.getText() + "', '" + p3 + "', '" + Profile.getClientID() + "', '" + updateOrderNumber + "')");
                    statement.executeUpdate();
                    statement = connection.prepareStatement("insert into items values ('" + itemText4.getText() + "', '" + p4 + "', '" + Profile.getClientID() + "', '" + updateOrderNumber + "')");
                    statement.executeUpdate();
                    statement = connection.prepareStatement("insert into items values ('" + itemText5.getText() + "', '" + p5 + "', '" + Profile.getClientID() + "', '" + updateOrderNumber + "')");
                    statement.executeUpdate();
                    statement = connection.prepareStatement("insert into items values ('" + itemText6.getText() + "', '" + p6 + "', '" + Profile.getClientID() + "', '" + updateOrderNumber + "')");
                    statement.executeUpdate();
                    statement = connection.prepareStatement("insert into items values ('" + itemText7.getText() + "', '" + p7 + "', '" + Profile.getClientID() + "', '" + updateOrderNumber + "')");
                    statement.executeUpdate();
                    statement = connection.prepareStatement("insert into items values ('" + itemText8.getText() + "', '" + p8 + "', '" + Profile.getClientID() + "', '" + updateOrderNumber + "')");
                    statement.executeUpdate();
                    statement = connection.prepareStatement("insert into items values ('" + itemText9.getText() + "', '" + p9 + "', '" + Profile.getClientID() + "', '" + updateOrderNumber + "')");
                    statement.executeUpdate();
                    statement = connection.prepareStatement("insert into items values ('" + itemText10.getText() + "', '" + p10 + "', '" + Profile.getClientID() + "', '" + updateOrderNumber + "')");
                    statement.executeUpdate();
                    break;
            }
            generateButton.setDisable(true);
            submitButton.setDisable(false);
        } else {
            invalidLabel.setVisible(true);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        submitButton.setDisable(true);

        itemQuantity = 0;
        gridPane2.setVisible(false);
        gridPane11.setVisible(false);
        gridPane3.setVisible(false);
        gridPane4.setVisible(false);
        gridPane5.setVisible(false);
        gridPane6.setVisible(false);
        gridPane7.setVisible(false);
        gridPane8.setVisible(false);
        gridPane9.setVisible(false);
        gridPane10.setVisible(false);

        itemDropDown.getItems().add("1");
        itemDropDown.getItems().add("2");
        itemDropDown.getItems().add("3");
        itemDropDown.getItems().add("4");
        itemDropDown.getItems().add("5");
        itemDropDown.getItems().add("6");
        itemDropDown.getItems().add("7");
        itemDropDown.getItems().add("8");
        itemDropDown.getItems().add("9");
        itemDropDown.getItems().add("10");
        clientLabel.setText(Profile.getLastName() + ", " + Profile.getFirstName());

        String orderID = "";
        invalidLabel.setVisible(false);

        File file = new File("C:\\Users\\ryanp\\Desktop\\EarnhartLLC - Copy\\orderID\\orderNumber.txt");
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            String s = String.valueOf(fileReader.read());
            orderID = s;
            Integer i = Integer.valueOf(s);
            i++;
            String y = String.valueOf(i);
            fileReader.close();
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(y);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int order = Integer.parseInt(orderID);
        order++;
        String newOrderID = String.valueOf(order);
        updateOrderNumber = newOrderID;

        orderNumber.setText("ORDER#" + newOrderID);
        invoiceSent.getItems().add("Yes");
        invoiceSent.getItems().add("No");
        invoicePaid.getItems().add("Yes");
        invoicePaid.getItems().add("No");
        shipped.getItems().add("Yes");
        shipped.getItems().add("No");
        refunded.getItems().add("Yes");
        refunded.getItems().add("No");
    }

    @FXML
    void submit(ActionEvent event) {
        if (invoicePaid.getSelectionModel().isEmpty() || invoiceSent.getSelectionModel().isEmpty() ||
                shipped.getSelectionModel().isEmpty() || refunded.getSelectionModel().isEmpty()) {
            invalidLabel.setVisible(true);
        } else {






        }
    }
}