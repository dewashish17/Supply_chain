package com.example.supplychain;
//creating product table here  in java from database

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;

public class Product {
    public SimpleIntegerProperty pid;
    public SimpleStringProperty name;
    public SimpleDoubleProperty price;
    public SimpleIntegerProperty quantity;

    // Constructor initializing COlumns data
    public Product(int pid,String name,double price,int quantity)
    {
        this.pid=new SimpleIntegerProperty(pid);
        this.name=new SimpleStringProperty(name);
        this.price=new SimpleDoubleProperty(price);
        this.quantity=new SimpleIntegerProperty(quantity);

    }

    // getter for pid
    public int getPid(){
        //System.out.println("you are in getPid"+pid);
        return pid.get();
    }

    // getter for name
    public String getName(){
        //System.out.println("you are in getname"+name);
        return name.get(); }

    //getter for price
    public double getPrice(){
        //System.out.println("you are in pricePrice"+price);
        return price.get(); }

    // getter for quantity
    public int getQuantity(){
        //System.out.println("you are in getquantity"+quantity);
        return quantity.get();}

    //create a observable array list from database to product
    // and return this list to productDetail.java table.Setitem(obeservalelist) as a tableview
    // and further return the tableview pane into supply chain
    public static ObservableList<Product> getAllProducts(){

        String selectProducts="SELECT * FROM PRODUCT";

        return getProductList(selectProducts);
    }


    // to make search button functionable
    public static ObservableList<Product> getProductsByName(String productName){

        String selectProducts=String.format("SELECT * FROM product WHERE name like '%%%s%%'",productName.toLowerCase());
        return getProductList(selectProducts);

    }
    private static ObservableList<Product> getProductList(String query){
        DatabaseConnection dbCon=new DatabaseConnection();
        ObservableList<Product> data= FXCollections.observableArrayList();
        try{

            ResultSet rs=dbCon.getQueryTable(query);
            while(rs.next()){

                data.add(new Product(rs.getInt("pid"),rs.getString("name"),rs.getDouble("price")
                        ,rs.getInt("quantity")));

//                System.out.println(rs.getInt("pid")+" "+rs.getString("name")+" "+
//                        rs.getDouble("price")+" "+ rs.getInt("quantity"));
            }
            rs.close();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return data;
    }


}
