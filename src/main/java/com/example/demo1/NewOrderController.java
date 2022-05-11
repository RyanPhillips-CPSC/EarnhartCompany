package com.example.demo1;

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

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class NewOrderController extends Controller implements Initializable {

    private int itemQuantity;
    private boolean generated = false;
    private String updateOrderNumber;
    private Stage stage;
    private Scene scene;

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
    void generateItems(ActionEvent event) {
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

    private void addItems(ActionEvent event) {

        //TODO -- create set in clientprofile and add items to it







        System.out.println(itemQuantity);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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

        submitButton.setDisable(true);

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

        String host = "jdbc:mysql://localhost:3306/theearnhartcompany";
        String user = "Ryan";
        String password = "aTundeAdjuah_22!";
        String orderID = "";
        invalidLabel.setVisible(false);

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(host, user, password);
            PreparedStatement statement = connection.prepareStatement("select ID from orderid");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                orderID = ("" + resultSet.getObject("ID"));
            }
        } catch (SQLException e) {
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
                shipped.getSelectionModel().isEmpty() || refunded.getSelectionModel().isEmpty() ||
                shipDate.getText().equals("") || refundDate.getText().equals("")) {
            invalidLabel.setVisible(true);
        } else {
            //TODO -- SUBMIT ORDER
        }
    }
}
