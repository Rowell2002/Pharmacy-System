/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author chethanarowell
 */
public class MAddMedicine {
    public void addMedicine(int id, String name, String distributors, int price, String medicine_type, int quantity, Date expire_date)
    {
        try
        {
            SimpleDateFormat x=new SimpleDateFormat("yyyy-MM-dd");
            String dob_new=x.format(expire_date);
        
            Statement st=MDbConnection.createConnection().createStatement();
            System.out.print(dob_new);
            
            int count=st.executeUpdate("insert into medicine values('"+id+"','"+name+"','"+distributors+"','"+price+"','"+medicine_type+"','"+quantity+"','"+dob_new+"')");
            
        if(count>0)
        {
            JOptionPane.showMessageDialog(null, "Registerd", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage()); //to get the error message
        }
    }
    
    
    
    
        
}

