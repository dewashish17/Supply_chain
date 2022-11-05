package com.example.supplychain;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
//import javafx.scene.control.Button;
//import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class supplyChain extends Application {
    Button loginButton;
    Pane bodyPane;
    public static final int width=700,height=600, upperline=50;

    //calling another java file to store table pane in main pane
    ProductDetails productDetails =new ProductDetails();    // table Pane


    private Pane headerBar(){                  // search panel(header bar) inside main panel
        Pane topPane=new Pane();
        topPane.setPrefSize(width,upperline-10);

        //TextField
        TextField searchText=new TextField();                 // creating textField(search bar)
        searchText.setPromptText("please search here");       // prompt text over textField
        searchText.setTranslateX(100);
        //searchText.setTranslateY(10);

        //Search Button
        Button searchButton=new Button("Search");               // creating search button inside Pane
        searchButton.setTranslateX(260);
        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String search=searchText.getText();
                bodyPane.getChildren().clear();
                bodyPane.getChildren().add(productDetails.getProductsByName(search));


            }
        });
        //searchButton.setTranslateY(10);

        //Login Button
        loginButton =new Button("Login");               // creating login button inside Pane
        loginButton.setTranslateX(600);
        //adding action listener to loginButton
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("clicked");
            }
        });



        // adding controls into topPane
        topPane.getChildren().addAll(searchText,searchButton,loginButton); // adding login searchfield, search are adding to topPane panel
        topPane.setTranslateY(20);
        //topPane.getChildren().add(searchButton);
        //topPane.getChildren().add(loginButton);
        return topPane;
    }

    private GridPane loginPage(){   // for login page
        Label emailLabel=new Label("E-mail :");
        Label passLabel=new Label("Password :")
        TextField emailText=new TextField();
        emailText.setPromptText("Please enter email here");
        TextField passField =new TextField();
        passField.setPromptText("Please enter password here");
        Button localLoginButton=new Button("Login");
        Button clearButton=new Button("Clear");

        GridPane gridPane=new GridPane();



        return gridPane;

    }
    private Pane createContent()                 // main window panel
    {
        Pane root=new Pane();
        root.setPrefSize(width,height+upperline);

        bodyPane=new Pane();
        bodyPane.setPrefSize(width,height);
        bodyPane.setTranslateY(upperline);
        bodyPane.getChildren().add(productDetails.getAllProducts());
        root.getChildren().addAll(headerBar(), bodyPane);

        return root;

    }
    @Override
    public void start(Stage stage) throws IOException {
       // FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(createContent());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}