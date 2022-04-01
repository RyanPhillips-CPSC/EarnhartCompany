package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class RemoveCustomerController implements Initializable {

    private Stage stage;
    private Scene scene;

    @FXML
    private ListView<String> customerList;

    /**
     * Returns to main menu
     * @param event
     * @throws IOException
     */
    @FXML
    void exit(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600,400);
        stage.setScene(scene);
        stage.setTitle("Main Menu");
        stage.show();
    }

    /**
     * Displays customer names inside a ListView
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        handleItemClicks();
        for (int i = 0; i < Main.getCustomers().size(); i++){
            customerList.getItems().add(Main.getCustomers().get(i).getName());
        }
    }

    /**
     * Removes the selected customer from the ArrayList and deletes their row on the client table
     */
    public void handleItemClicks() {
        customerList.setOnMouseClicked(event -> {
            String selectedName = customerList.getSelectionModel().getSelectedItem();
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
                e.printStackTrace();
            }
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root, 600,400);
            stage.setScene(scene);
            stage.setTitle("Main Menu");
            stage.show();
        });
    }
}
