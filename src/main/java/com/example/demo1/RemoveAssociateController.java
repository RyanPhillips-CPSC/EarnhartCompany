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

public class RemoveAssociateController extends Controller implements Initializable {

    private Stage stage;
    private Scene scene;

    @FXML
    private Button removeAssociateButton;

    @FXML
    private ImageView myImageView;

    @FXML
    private ListView<String> associateList;

    /**
     * Displays associate names in a ListView
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        removeAssociateButton.setStyle("-fx-background-color: blue");
        removeAssociateButton.setDisable(true);
        handleItemClicks();

        try {
            Image logo = new Image(String.valueOf(getClass().getResource("/Images/logo.png")));
            myImageView.setImage(logo);
            myImageView.setVisible(true);
        } catch (Exception e) {
            System.out.println("Image Not Found");
        }

        for (int i = 0; i < Main.getAssociates().size(); i++){
            associateList.getItems().add(Main.getAssociates().get(i).getName() + ",    " + Main.getAssociates().get(i).phone
            + ",    " + Main.getAssociates().get(i).getEmail());
        }
    }

    /**
     * Removes the selected associate from the associates ArrayList, the associate table, and switches
     * back to the main menu scene.
     */
    public void handleItemClicks() {
        associateList.setOnMouseClicked(event -> {
            String selectedName = associateList.getSelectionModel().getSelectedItem();
            int indexOf = selectedName.indexOf(",");
            selectedName = selectedName.substring(0,indexOf);
            String host = "jdbc:mysql://localhost:3306/clientInfo";
            String user = "root";
            String password = "aTundeAdjuah_22!";

            //remove from ArrayList, then from table
            for (int i = 0; i < Main.getAssociates().size(); i ++) {
                if (selectedName.equals(Main.getAssociates().get(i).getName())) {
                    Main.getAssociates().remove(i);
                }
            }

            try {
                Connection connection = DriverManager.getConnection(host,user,password);
                PreparedStatement preparedStatement = connection.prepareStatement("delete from associate where Name = '"+selectedName+"'");
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
            scene.getStylesheets().add("style.css");
            stage.setScene(scene);
            stage.setTitle("Main Menu");
            stage.show();
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
