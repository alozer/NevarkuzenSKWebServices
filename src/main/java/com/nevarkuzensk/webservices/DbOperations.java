/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nevarkuzensk.webservices;

import java.sql.*;

/**
 *
 * @author ali
 */
public class DbOperations {
    public ResultSet getTeams(Connection connection)
    {
        ResultSet rs = null;
        Statement s = null;
        try
        {
            s = connection.createStatement();
            
            rs = s.executeQuery("SELECT team_id, name  FROM teams");
        }catch(Exception e)
        {
            System.out.println("Problem in searching the database 1");
        }
        return rs;
    }
}
