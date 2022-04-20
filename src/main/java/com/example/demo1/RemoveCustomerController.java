package com.example.demo1;

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
import javafx.scene.image.Image;
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

public class RemoveCustomerController extends Controller implements Initializable {

    private Stage stage;
    private Scene scene;

    @FXML
    private Button removeCustomerButton;

    @FXML
    private ImageView myImageView;

    @FXML
    private ListView<String> customerList;

    /**
     * Displays customer names inside a ListView
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        removeCustomerButton.setStyle("-fx-background-color: blue");
        removeCustomerButton.setDisable(true);

        handleItemClicks();
        for (int i = 0; i < Main.getCustomers().size(); i++){
            customerList.getItems().add(Main.getCustomers().get(i).getName() + ",    " + Main.getCustomers().get(i).getPhone()
            + ",    " + Main.getCustomers().get(i).getEmail());
        }

        try {
            Image logo = new Image(String.valueOf(getClass().getResource("/Images/logo.png")));
            myImageView.setImage(logo);
            myImageView.setVisible(true);
        } catch (Exception e) {
            System.out.println("Image Not Found");
        }
    }

    /**
     * Removes the selected customer from the ArrayList and deletes their row on the client table
     */
    public void handleItemClicks() {
        customerList.setOnMouseClicked(event -> {
            String selectedName = customerList.getSelectionModel().getSelectedItem();
            int indexOf = selectedName.indexOf(",");
            selectedName = selectedName.substring(0,indexOf);
            String host = "jdbc:mysql://localhost:3306/clientInfo";
            String user = "root";
            String password = "aTundeAdjuah_22!";

            //remove from ArrayList, then from table
            for (int i = 0; i < Main.getCustomers().size(); i ++) {
                if (selectedName.equals(Main.getCustomers().get(i).getName())) {
                    Main.getCustomers().remove(i);
                }
            }

            try {
                Connection connection = DriverManager.getConnection(host, user, password);
                PreparedStatement preparedStatement = connection.prepareStatement("delete from client where Name = '"+selectedName+"'");
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                System.out.println("ERROR -- CANNOT CONNECT TO DATABASE");
            }

            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
            } catch (IOException e) {
                Platform.exit();
            }
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root, 602, 432, Color.TRANSPARENT);
            scene.getStylesheets().add("menuStyle.css");
            stage.setScene(scene);
            stage.setTitle("Associate Portal");
            stage.show();
            stage.centerOnScreen();
        });
    }

    @FXML
    void helpDisplay(ActionEvent event) throws IOException {
        super.helpDisplay(myImageView);
    }

    @FXML
    void exit (ActionEvent event) throws IOException {
        super.exit(myImageView);
    }

    @FXML
    void newAssociate(ActionEvent event) throws IOException {
        super.newAssociate(event);
    }

    @FXML
    void newCustomer(ActionEvent event) throws IOException {
        super.newCustomer(event);
    }

    @FXML
    void newProduct(ActionEvent event) throws IOException {
        super.newProduct(event);
    }

    @FXML
    void customerRecords(ActionEvent event) throws IOException {
        super.customerRecords(event);
    }

    @FXML
    void productRecords(ActionEvent event) throws IOException {
        super.productRecords(event);
    }

    @FXML
    void associateRecords(ActionEvent event) throws IOException {
        super.associateRecords(event);
    }

    @FXML
    void removeAssociate(ActionEvent event) throws IOException {
        super.removeAssociate(event);
    }

    @FXML
    void removeCustomer(ActionEvent event) throws IOException {
        super.removeCustomer(event);
    }

    @FXML
    void removeProduct(ActionEvent event) throws IOException {
        super.removeProduct(event);
    }
}
