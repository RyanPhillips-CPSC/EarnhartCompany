package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProductRecordsController extends Controller implements Initializable {

    private Stage stage;
    private Scene scene;

    @FXML
    ImageView backgroundImageView;

    @FXML
    private ImageView myImageView;

    @FXML
    private TextArea textArea = new TextArea("Product Records --------------------" +
            "----------------------------------------------------------\n\n");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image logo = new Image(String.valueOf(getClass().getResource("/Images/Group Project Logo.png")));
        myImageView.setImage(logo);
        myImageView.setVisible(true);

        textArea.setOpacity(.90);

        Image background = new Image(String.valueOf(getClass().getResource("/Images/ModernFurniture4.png")));
        backgroundImageView.setImage(background);
        backgroundImageView.setVisible(true);

        textArea.appendText("Product Records --------------------" +
                "-----------------------------------------------------------\n\n");
        for (int i = 0; i < Main.getItems().size(); i++) {
            textArea.appendText(Main.getItems().get(i).getName() + "\nSku -- " +
                    Main.getItems().get(i).getSku() + "\nPrice -- " + Main.getItems().get(i).getsPrice() + "\n");
            textArea.appendText("\n----------------------------------------------------" +
                    "-----------------------------------------------\n");
        }
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
