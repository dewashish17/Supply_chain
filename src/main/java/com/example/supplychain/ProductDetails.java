package com.example.supplychain;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

// display list of data in tabular format in ui
//introduce control->table view in ui
//         JAVA SWING  have jtable or jtableview
//         JAVAFX(new modern ui library) have tableview
 public class ProductDetails {
    public Pane getAllProducts(){
        TableView<Product> table=new TableView<>();

        //creating columns for tableview(a table)
        TableColumn pidCol=new TableColumn("pid");                          // pid columns
        pidCol.setCellValueFactory(new PropertyValueFactory<>("pid"));

        TableColumn nameCol=new TableColumn("name");                       // name columns
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn priceCol=new TableColumn("price");                       // price columns
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn quantityCol =new TableColumn("quantity");                     // quantity columns
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        // adding coulmns property in table
        table.getColumns().addAll(pidCol,nameCol,priceCol,quantityCol);

        // adding data into Table( tableview ) --> using obervableLis t
        // setItems take a list  and  assigning it to all the columns and rows
        // setItems take  obeservable list type of datatype as argument  (obervableList is just a kind of list)

//        ObservableList<Product> data = FXCollections.observableArrayList(
//          new Product(2,"abc",3456.0,2),
//                new Product(2,"pqr",346.0,6)
//
//        );
        ObservableList<Product> data=Product.getAllProducts(); // getting obervable list from Product.java

        table.setItems(data);

        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);  // to remove one extra column in ui
        table.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        table.setPrefSize(supplyChain.width-40,supplyChain.height-40);
        table.setTranslateX(20);
        table.setTranslateY(20);
        //creating a pane to show the table inside main window pane
        Pane tpane=new Pane();
        tpane.setPrefSize(supplyChain.width,supplyChain.height);
        tpane.getChildren().add(table);
//        tpane.setTranslateX(40);
//        tpane.setTranslateY(70);
        return tpane;

    }


    public Pane getProductsByName(String searchText){
        TableView<Product> table=new TableView<>();

        //creating columns for tableview(a table)
        TableColumn pidCol=new TableColumn("pid");                          // pid columns
        pidCol.setCellValueFactory(new PropertyValueFactory<>("pid"));

        TableColumn nameCol=new TableColumn("name");                       // name columns
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn priceCol=new TableColumn("price");                       // price columns
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn quantityCol =new TableColumn("quantity");                     // quantity columns
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        // adding coulmns property in table
        table.getColumns().addAll(pidCol,nameCol,priceCol,quantityCol);

        // adding data into Table( tableview ) --> using obervableLis t
        // setItems take a list  and  assigning it to all the columns and rows
        // setItems take  obeservable list type of datatype as argument  (obervableList is just a kind of list)

//        ObservableList<Product> data = FXCollections.observableArrayList(
//          new Product(2,"abc",3456.0,2),
//                new Product(2,"pqr",346.0,6)
//
//        );
        ObservableList<Product> data=Product.getProductsByName(searchText); // getting obervable list from Product.java

        table.setItems(data);

        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);  // to remove one extra column in ui
        table.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        table.setPrefSize(supplyChain.width-40,supplyChain.height-40);
        table.setTranslateX(20);
        table.setTranslateY(20);

        //creating a pane to show the table inside main window pane
        Pane tpane=new Pane();
        tpane.setPrefSize(supplyChain.width,supplyChain.height);
        tpane.getChildren().add(table);
        //tpane.setTranslateX(100);
       // tpane.setTranslateY(70);
        return tpane;

    }
}
