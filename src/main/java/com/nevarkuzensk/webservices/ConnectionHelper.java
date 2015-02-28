/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nevarkuzensk.webservices;

import java.sql.*;
import org.postgresql.Driver;

public class ConnectionHelper {
    private Connection connection = null;
    
    public Connection getConnection()
    {
        String url = "jdbc:postgresql://localhost:5432/";
        try
        {
           Class.forName("org.postgresql.Driver");
           connection = DriverManager.getConnection(url, "postgres", "161913");
           
           if (connection != null) {
               System.out.println("Connecting to database...");
           }
        } catch(Exception e){
            System.out.println("Problem when connecting to the database 1");
        }
        
        return connection;
                
    }
    
    public void closeConnection(Connection connection)
    {
        try
        {
            connection.close();
        }catch(Exception e)
        {
            System.out.println("Problem to close the connection to the database");
        }
    }
}
