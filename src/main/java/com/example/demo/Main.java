package com.example.demo;

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

/**
 *
 */
public class Main extends Application {
    private static ArrayList<User> admins = new ArrayList();

    static {

        try {
            createDatabase();
            //resetSchema();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
    public static void main(String[] args) throws SQLException, IOException {
        collectAdmins();
        launch();
    }

    /**
     * Collects admin information from the H2 database and adds it to an ArrayList
     * @throws SQLException
     */
    private static void collectAdmins() throws SQLException {
        String jdbcURL = "jdbc:h2:C:/Users/ryanp/Desktop/EarnhartLLC - Copy/datab/default;OLD_INFORMATION_SCHEMA=TRUE";
        String username = "";
        String password = "";

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcURL, username, password);
        } catch (SQLException s) {
            s.printStackTrace();
        }

        PreparedStatement preparedStatementOne = connection.prepareStatement("SET SCHEMA TWO");
        preparedStatementOne.execute();
        PreparedStatement preparedStatementTwo = connection.prepareStatement("SELECT * FROM LOGIN WHERE username IS NOT NULL");
        ResultSet resultSet = preparedStatementTwo.executeQuery();

        String user;
        String pass;
        while (resultSet.next()) {
            user = (String) resultSet.getObject("username");
            pass = (String) resultSet.getObject("password");
            User u = new User(user,pass);
            admins.add(u);
        }
    }

    /**
     * METHOD FOR TESTING
     * @throws SQLException
     */
    private static void resetSchema() throws SQLException, IOException {
        String jdbcURL = "jdbc:h2:C:/Users/ryanp/Desktop/EarnhartLLC - Copy/datab/default;OLD_INFORMATION_SCHEMA=TRUE";
        String username = "";
        String password = "";

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcURL, username, password);
        } catch (SQLException s) {
            s.printStackTrace();
        }

        PreparedStatement preparedStatement = connection.prepareStatement("SET SCHEMA TWO");
        preparedStatement.execute();
        PreparedStatement preparedStatementTwo = connection.prepareStatement("DELETE FROM LOGIN WHERE username IS NOT NULL");
        preparedStatementTwo.executeUpdate();
        PreparedStatement preparedStatementThree = connection.prepareStatement("DROP TABLE LOGIN");
        preparedStatementThree.executeUpdate();
        PreparedStatement preparedStatementFour = connection.prepareStatement("DELETE FROM CLIENTPROFILE WHERE firstname IS NOT NULL");
        preparedStatementFour.executeUpdate();
        PreparedStatement preparedStatementFive = connection.prepareStatement("DROP TABLE CLIENTPROFILE");
        preparedStatementFive.executeUpdate();
        PreparedStatement preparedStatementSix = connection.prepareStatement("DELETE FROM ITEM WHERE name IS NOT NULL");
        preparedStatementSix.executeUpdate();
        PreparedStatement preparedStatementSeven = connection.prepareStatement("DROP TABLE ITEM");
        preparedStatementSeven.executeUpdate();
        PreparedStatement preparedStatementEight = connection.prepareStatement("DELETE FROM ORDERS WHERE orderID IS NOT NULL");
        preparedStatementEight.executeUpdate();
        PreparedStatement preparedStatementNine = connection.prepareStatement("DROP TABLE ORDERS");
        preparedStatementNine.executeUpdate();
        PreparedStatement preparedStatementTen = connection.prepareStatement("DROP SCHEMA TWO");
        preparedStatementTen.executeUpdate();
        connection.close();
        /*
        File fileOne = new File("src/main/resources/sqlReset.sql");
        ScriptRunner scriptRunner = new ScriptRunner(connection);
        Reader reader = new BufferedReader(new FileReader(fileOne));
        scriptRunner.runScript(reader);
        connection.close();
        reader.close();
         */
    }

        /**
         * Runs the SQL script to create a database
         */
        private static void createDatabase() throws SQLException, IOException {
            String jdbcURL = "jdbc:h2:C:/Users/ryanp/Desktop/EarnhartLLC - Copy/datab/default;OLD_INFORMATION_SCHEMA=TRUE";
            String username = "";
            String password = "";

            Connection connection = null;
            try {
                connection = DriverManager.getConnection(jdbcURL, username, password);
                System.out.println("Connected to H2 embedded database.");
            } catch (SQLException s) {
                s.printStackTrace();
            }

            PreparedStatement preparedStatement = connection.prepareStatement("CREATE SCHEMA TWO;");
            preparedStatement.execute();
            PreparedStatement preparedStatementSet = connection.prepareStatement("SET SCHEMA TWO");
            preparedStatementSet.execute();
            PreparedStatement preparedStatementTwo = connection.prepareStatement("CREATE TABLE LOGIN (" +
                    "username VARCHAR(100)," +
                    "password VARCHAR(100))");
            preparedStatementTwo.execute();
            PreparedStatement preparedStatementThree = connection.prepareStatement("INSERT INTO LOGIN VALUES (" +
                    "'jearnhartLLC','137562088')");
            preparedStatementThree.executeUpdate();
            PreparedStatement preparedStatementFour = connection.prepareStatement("CREATE TABLE CLIENTPROFILE (" +
                    "firstname VARCHAR(100)," +
                    "lastname VARCHAR(100)," +
                    "phone VARCHAR(100)," +
                    "email VARCHAR(100)," +
                    "address VARCHAR(100)," +
                    "consultation LONGTEXT," +
                    "clientID LONGTEXT)");
            preparedStatementFour.execute();
            PreparedStatement preparedStatementFive = connection.prepareStatement("INSERT INTO CLIENTPROFILE VALUES (" +
                    "'Ryan','Phillips','(540)-903-0781','ryanphillipsmusic41@gmail.com','7405 Stonegate Estates Dr', null, '0')");
            preparedStatementFive.executeUpdate();
            PreparedStatement preparedStatementSix = connection.prepareStatement("CREATE TABLE ITEM (" +
                    "name VARCHAR(200)," +
                    "price DOUBLE," +
                    "clientID LONGTEXT," +
                    "orderID LONGTEXT)");
            preparedStatementSix.execute();
            PreparedStatement preparedStatementSeven = connection.prepareStatement("CREATE TABLE ORDERS (" +
                    "orderID LONGTEXT," +
                    "price DOUBLE," +
                    "invoiceSent BOOLEAN," +
                    "invoicePaid BOOLEAN," +
                    "shipped BOOLEAN," +
                    "dateOfShipment VARCHAR(100)," +
                    "refunded BOOLEAN," +
                    "dateOfRefund VARCHAR(100)," +
                    "notes LONGTEXT," +
                    "acFileLocation VARCHAR(200))");
            preparedStatementSeven.execute();
            connection.close();
        }

    public static ArrayList<User> getAdmins() {
        return admins;
    }
}