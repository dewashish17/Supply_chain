package com.example.supplychain;
import  java.sql.*;


public class DatabaseConnection {
    // DB_URL="connector_name:database type:url:port"
    private static final String DB_URL="jdbc:mysql://localhost:3306/s_chain";
    private static final String USER="root";
    private static final String PASS="dewashish";

    public Statement getStatement(){
        Statement statement=null;
        Connection conn;
        try{
            conn=DriverManager.getConnection(DB_URL,USER,PASS);
            statement=conn.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
        return statement;
    }

    public ResultSet getQueryTable(String query) throws SQLException{
        Statement statement=getStatement();
        return statement.executeQuery(query);
    }

    public static void main(String[] args)
    {
        DatabaseConnection dbConn=new DatabaseConnection();
        try{
            String query="select * from product";
            ResultSet rs=dbConn.getQueryTable(query);
            while(rs.next()){
                System.out.println(rs.getInt("pid")+" "+rs.getString("name")+" "+
                        rs.getDouble("price")+" "+ rs.getInt("quantity")+" "+ rs.getString(1));
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }


    }
}
