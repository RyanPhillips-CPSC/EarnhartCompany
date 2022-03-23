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
import java.util.ResourceBundle;

public class RemoveCustomerController implements Initializable {

    private Stage stage;
    private Scene scene;

    @FXML
    private ListView<String> customerList;

    @FXML
    void exit(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600,400);
        stage.setScene(scene);
        stage.setTitle("Main Menu");
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        handleItemClicks();
        for (int i = 0; i < Main.getCustomers().size(); i++){
            customerList.getItems().add(Main.getCustomers().get(i).getName());
        }
    }

    /**
     * Removes the selected associate from the associates  ArrayLists, rewrites the .txt file, then switches
     * back to the main menu scene.
     */
    public void handleItemClicks() {
        customerList.setOnMouseClicked(event -> {
            String selectedName = customerList.getSelectionModel().getSelectedItem();
            for (int i = 0; i < Main.getCustomers().size(); i++) {
                if (Main.getCustomers().get(i).getName().equals(selectedName)) { Main.getCustomers().remove(i); }
            } //Iterate though customers and remove the selected customer
            for (int j = 0; j < Main.getCustomers().size(); j++) {
                try {
                    if (j == 0) Main.getCustomers().get(j).rewriteCustomer();//do not append on the first one, restart file
                    else Main.getCustomers().get(j).writeCustomer();//append from 2nd on
                } //rewrite the first customer, then append the rest
                catch (IOException e) { e.printStackTrace(); }
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
