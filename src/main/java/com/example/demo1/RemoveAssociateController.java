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

public class RemoveAssociateController implements Initializable {

    private Stage stage;
    private Scene scene;

    @FXML
    private ListView<String> associateList;

    /**
     * Returns to the main menu
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
     * Displays associate names in a ListView
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        handleItemClicks();
        for (int i = 0; i < Main.getAssociates().size(); i++){
            associateList.getItems().add(Main.getAssociates().get(i).getName());
        }
    }

    /**
     * Removes the selected associate from the associates  ArrayLists, rewrites the .txt file, then switches
     * back to the main menu scene.
     */
    public void handleItemClicks() {
        associateList.setOnMouseClicked(event -> {
            String selectedName = associateList.getSelectionModel().getSelectedItem();
            for (int i = 0; i < Main.getAssociates().size(); i++) {
                if (Main.getAssociates().get(i).getName().equals(selectedName)) { Main.getAssociates().remove(i); }
            }
            for (int j = 0; j < Main.getAssociates().size(); j++) {
                try {
                    if (j == 0) Main.getAssociates().get(j).rewriteAssociate();//do not append on the first one, restart file
                    else Main.getAssociates().get(j).writeAssociate();//append from 2nd on
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
