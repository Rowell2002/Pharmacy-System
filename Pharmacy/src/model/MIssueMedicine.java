/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.awt.event.WindowAdapter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author chethanarowell
 */
public class MIssueMedicine {
    ResultSet rst;
    public ResultSet searchCustomer(String first)
    {
        try
        {
            Statement st=MDbConnection.createConnection().createStatement();
            rst=st.executeQuery("select last_name, customer_id, age, contact_number from customer where first_name='"+first+"'");
            
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
        return rst;
    }
    
    public ResultSet searchMedicine(String medicine_name)
    {
        try
        {
            Statement st=MDbConnection.createConnection().createStatement();
            rst=st.executeQuery("select price, medicine_type from medicine where name='"+medicine_name+"'");
            
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
        return rst;
    }
    
    public void addBill(int bill_id, String id, String name, String medicine, int price, int quantity, int tot)
    {
        try
        {
//            SimpleDateFormat x=new SimpleDateFormat("yyyy-MM-dd");
//            String dob_new=x.format(expire_date);
        
            Statement st=MDbConnection.createConnection().createStatement();
            //System.out.print(dob_new);
            
            int count=st.executeUpdate("insert into bill values('"+bill_id+"','"+id+"','"+name+"','"+medicine+"','"+price+"','"+quantity+"','"+tot+"')");
            
        if(count>0)
        {
            JOptionPane.showMessageDialog(null, "Item saved", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage()); //to get the error message
        }
        
        try
        {
//            SimpleDateFormat x=new SimpleDateFormat("yyyy-MM-dd");
//            String dob_new=x.format(expire_date);
        
            Statement st=MDbConnection.createConnection().createStatement();
            //System.out.print(dob_new);
            
            int count=st.executeUpdate("insert into sales values('"+bill_id+"','"+id+"','"+name+"','"+medicine+"','"+price+"','"+quantity+"','"+tot+"')");
            
        
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage()); //to get the error message
        }
    }
    
    public void showReport()
    {
        try {
            Connection con = MDbConnection.createConnection(); //This uses the connection interface.

            JasperDesign jasperdesign = JRXmlLoader.load("/Users/chethanarowell/NetBeansProjects/Pharmacy/src/view/bills.jrxml");
            JRDesignQuery designquery = new JRDesignQuery();
            designquery.setText("SELECT * FROM bill");
            jasperdesign.setQuery(designquery);
            
            Map<String, Object> parameters= new HashMap<String, Object>();
            //parameters.put("finalTotalPrice", finalTotalPrice);
            //parameters.put("orderId", orderId);
            //parameters.put("customerName", customerName);
            
            //you enter report source to this functions parameters
            JasperReport report = JasperCompileManager.compileReport(jasperdesign);
            JasperPrint print = JasperFillManager.fillReport(report, parameters, con);
            JasperViewer.viewReport(print);
            
            try (Statement stmt = con.createStatement()) {
        stmt.executeUpdate("TRUNCATE TABLE bill");
            }
        } catch (Exception e) {
            System.err.println("Report Error: " + e.getMessage());
        }     
        
    }
    
    public void salesReport()
    {
        try {
            Connection con = MDbConnection.createConnection(); //This uses the connection interface.

            JasperDesign jasperdesign = JRXmlLoader.load("/Users/chethanarowell/NetBeansProjects/Pharmacy/src/view/sales.jrxml");
            JRDesignQuery designquery = new JRDesignQuery();
            designquery.setText("select b.medicine, b.quantity, m.distributors, m.medicine_type from sales as b, medicine as m where b.medicine=m.name order by b.quantity desc");
            jasperdesign.setQuery(designquery);
            
            Map<String, Object> parameters= new HashMap<String, Object>();
            //parameters.put("finalTotalPrice", finalTotalPrice);
            //parameters.put("orderId", orderId);
            //parameters.put("customerName", customerName);
            
            //you enter report source to this functions parameters
            JasperReport report = JasperCompileManager.compileReport(jasperdesign);
            JasperPrint print = JasperFillManager.fillReport(report, parameters, con);
            JasperViewer.viewReport(print);
        } catch (Exception e) {
            System.err.println("Report Error: " + e.getMessage());
        }
    }
    
    
}
