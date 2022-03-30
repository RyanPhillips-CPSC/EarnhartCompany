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

public class RemoveProductController implements Initializable {

    private Stage stage;
    private Scene scene;

    @FXML
    private ListView<String> productList;

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
        for (int i = 0; i < Main.getItems().size(); i++){
            productList.getItems().add(Main.getItems().get(i).getName());
        }
    }

    /**
     * Removes the selected associate from the associates  ArrayLists, rewrites the .txt file, then switches
     * back to the main menu scene.
     */
    public void handleItemClicks() {
        productList.setOnMouseClicked(event -> {
            String selectedName = productList.getSelectionModel().getSelectedItem();
            for (int i = 0; i < Main.getItems().size(); i++) {
                if (Main.getItems().get(i).getName().equals(selectedName)) { Main.getItems().remove(i); }
            }
            for (int j = 0; j < Main.getItems().size(); j++) {
                try {
                    if (j == 0) Main.getItems().get(j).rewriteItem();//do not append on the first one, restart file
                    else Main.getItems().get(j).writeItem();//append from 2nd on
                }
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
