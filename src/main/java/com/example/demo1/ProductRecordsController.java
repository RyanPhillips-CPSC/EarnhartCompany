package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProductRecordsController implements Initializable {

    private Stage stage;
    private Scene scene;

    @FXML
    private TextArea textArea = new TextArea("Product Records --------------------" +
            "----------------------------------------------------------\n\n");


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        textArea.appendText("Product Records --------------------" +
                "-----------------------------------------------------------\n\n");
        for (int i = 0; i < Main.getItems().size(); i++) {
            textArea.appendText(Main.getItems().get(i).getName() + "\nSku -- " +
                    Main.getItems().get(i).getSku() + "\nPrice -- " + Main.getItems().get(i).getPrice() + "\n");
            textArea.appendText("\n----------------------------------------------------" +
                    "-----------------------------------------------\n");
        }
    }

    @FXML
    void exit(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600,400);
        stage.setScene(scene);
        stage.setTitle("Main Menu");
        stage.show();
    }
}
