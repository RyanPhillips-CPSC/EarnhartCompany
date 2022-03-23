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

public class AssociateRecordsController implements Initializable {

    private Stage stage;
    private Scene scene;

    @FXML
    private TextArea textArea = new TextArea("Associate Records --------------------" +
            "----------------------------------------------------------\n\n");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        textArea.appendText("Associate Records --------------------" +
                "-----------------------------------------------------------\n\n");
        for (int i = 0; i < Main.getAssociates().size(); i++) {
            textArea.appendText(Main.getAssociates().get(i).getName() + "\nPhone -- " +
                    Main.getAssociates().get(i).getPhone() + "\nEmail -- " + Main.getAssociates().get(i).getEmail() + "\nAddress -- "
            + Main.getAssociates().get(i).getAddress() + "\nPosition -- " + Main.getAssociates().get(i).getAssociateTitle() + "\nUser ID -- "
            + Main.getAssociates().get(i).getUserID() + "\nPassword -- " + Main.getAssociates().get(i).getPassword());
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
