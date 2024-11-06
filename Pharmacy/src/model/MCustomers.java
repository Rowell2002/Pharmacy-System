/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author chethanarowell
 */
public class MCustomers {
    public void addCustomer(String customer_id, String title, String first_name, String last_name, int age, int contact_number)
    {
        try
        {
//            SimpleDateFormat x=new SimpleDateFormat("yyyy-MM-dd");
//            String dob_new=x.format(expire_date);
        
            Statement st=MDbConnection.createConnection().createStatement();
            //System.out.print(dob_new);
            
            int count=st.executeUpdate("insert into customer values('"+customer_id+"','"+title+"','"+first_name+"','"+last_name+"','"+age+"','"+contact_number+"')");
            
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
