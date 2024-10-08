package com.example.project2scenebuilder;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
//extra imports ADD COMMENTS
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//import for switching fxml files
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloController {
    //top buttons for login and reporting
    @FXML private TextField password;
    @FXML private Button login;
    @FXML private Button inventory;
    @FXML private Button reports;

    //containers
    @FXML private Button bowl;
    @FXML private Button plate;
    @FXML private Button biggerPlate;
    @FXML private Button aLaCarte;

    //sides
    @FXML private Button chowMein;
    @FXML private Button friedRice;
    @FXML private Button whiteRice;
    @FXML private Button superGreensSide;

    //entrees
    @FXML private Button bourbonChicken;
    @FXML private Button orangeChicken;
    @FXML private Button blackPepperSteak;
    @FXML private Button honeyWalnutShrimp;
    @FXML private Button grilledTeriyakiChicken;
    @FXML private Button kungPaoChicken;
    @FXML private Button honeySesameChickenBreast;
    @FXML private Button beijingBeef;
    @FXML private Button mushroomChicken;
    @FXML private Button sweetfireChickenBreast;
    @FXML private Button stringBeanChickenBreast;
    @FXML private Button broccoliBeef;
    @FXML private Button blackPepperChicken;
    @FXML private Button superGreensEntree;

    //appetizer
    @FXML private Button chickenEggRoll;
    @FXML private Button veggieSpringRoll;
    @FXML private Button creamCheeseRangoon;
    @FXML private Button applePieRoll;

    //drink
    @FXML private Button drink;

    //other
    @FXML private Label time;
    @FXML private Button enter;
    @FXML private Button pay;
    @FXML private Label orderText;
    private String fetchDataFromDatabase() {
        StringBuilder name = new StringBuilder();
        Connection conn = null;
        try {
            // Log loading the driver
            System.out.println("Loading PostgreSQL JDBC Driver...");
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver loaded!");

            // Log establishing the connection
            System.out.println("Connecting to the database...");
            conn = DriverManager.getConnection(
                    "jdbc:postgresql://csce-315-db.engr.tamu.edu/csce331_62",
                    "csce331_62", "team62");
            System.out.println("Connection established!");

            // Log the SQL query execution
            String sqlStatement = "SELECT * FROM food";
            Statement stmt = conn.createStatement();
            System.out.println("Executing query: " + sqlStatement);
            ResultSet result = stmt.executeQuery(sqlStatement);

            // Log the results
            while (result.next()) {
                name.append(result.getString("food_name")).append("\n");
            }

            // Close resources
            stmt.close();
            result.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            name.append("Error accessing Database: ").append(e.getMessage());
        }
        return name.toString();
    }
    @FXML protected void onHelloButtonClick() {
        orderText.setText("Welcome to JavaFX Application!");
    }

    @FXML public void initialize() {

    }
    @ FXML public void loginButton(ActionEvent e) {
        orderText.setText(fetchDataFromDatabase());
    }
    @ FXML public void helloButton(ActionEvent e) {
        orderText.setText(orderText.getText()+" Hello World. ");
    }
    @ FXML public void clearButton(ActionEvent e) {
        orderText.setText("");
    }

}