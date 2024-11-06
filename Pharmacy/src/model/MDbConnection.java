package model;

import java.sql.*;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;

public class MDbConnection 
{
    private static Connection con;
    public static Connection createConnection()
    {
        try
        {
            String dbpath="jdbc:mysql://localhost/Pharmacy";
            con=DriverManager.getConnection(dbpath,"root","");
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
        return con;
    }
}
