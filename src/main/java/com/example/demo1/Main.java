package com.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

public class Main extends Application {

    private static ArrayList<Admin> admins = new ArrayList();

    /**
     * Sets important Stage properties and loads the initial Scene
     * @param stage
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 362, 549, Color.TRANSPARENT);
        stage.setTitle("The Earnhart Company");
        stage.setResizable(false);
        stage.setScene(scene);
        scene.getStylesheets().add("loginStyle.css");
        stage.getIcons().add(new Image(Objects.requireNonNull(Main.class.getResourceAsStream("/Images/windowIcon.png"))));
        stage.show();
        stage.centerOnScreen();
    }

    /**
     * Runs the GUI
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws ClassNotFoundException {
        associateAssignment();
        launch();
    }

    /**
     * Adds administrator login info to an ArrayList for easy access
     */
    public static void associateAssignment() throws ClassNotFoundException {
        String username, password;


        Class.forName("org.h2.Driver");
        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:./edaDB","test","test");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from login where userID <> 'null'");

            while (resultSet.next()) {
                username = ("" + resultSet.getObject("userID"));
                password = ( "" + resultSet.getObject("password"));
                Admin a = new Admin(username,password);
                admins.add(a);
            }
        } catch (SQLException s) {
            s.printStackTrace();
        }
    }

    public static ArrayList<Admin> getAdmins() {
        return admins;
    }
}