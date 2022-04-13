package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
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

public class RemoveProductController extends Controller implements Initializable {

    private Stage stage;
    private Scene scene;

    @FXML
    private Button removeProductButton;

    @FXML
    private ImageView myImageView;

    @FXML
    private ListView<String> itemList;

    /**
     * Displays customer names inside a ListView
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        removeProductButton.setStyle("-fx-background-color: blue");
        removeProductButton.setDisable(true);

        handleItemClicks();
        for (int i = 0; i < Main.getItems().size(); i++){
            itemList.getItems().add(Main.getItems().get(i).getName() + ",    " +
                    Main.getItems().get(i).getSku() + ",    " + Main.getItems().get(i).getsPrice());
        }
    }

    /**
     * Removes the selected customer from the ArrayList and deletes their row on the client table
     */
    public void handleItemClicks() {
        itemList.setOnMouseClicked(event -> {
            String selectedName = itemList.getSelectionModel().getSelectedItem();
            int indexOf = selectedName.indexOf(",");
            selectedName = selectedName.substring(0,indexOf);
            String host = "jdbc:mysql://localhost:3306/clientInfo";
            String user = "root";
            String password = "aTundeAdjuah_22!";

            //remove from ArrayList, then from table
            for (int i = 0; i < Main.getItems().size(); i ++) {
                if (selectedName.equals(Main.getItems().get(i).getName())) {
                    Main.getItems().remove(i);
                }
            }

            try {
                Connection connection = DriverManager.getConnection(host, user, password);
                PreparedStatement preparedStatement = connection.prepareStatement("delete from product where Name = '"+selectedName+"'");
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                System.out.println("ERROR -- CANNOT CONNECT TO DATABASE");
            }

            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root, 600,400, Color.TRANSPARENT);
            scene.getStylesheets().add("mainStyle.css");
            stage.setScene(scene);
            stage.setTitle("Main Menu");
            stage.show();
            stage.centerOnScreen();
        });
    }

    @FXML
    void settings(ActionEvent event) throws IOException {
        super.settings(myImageView);
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
