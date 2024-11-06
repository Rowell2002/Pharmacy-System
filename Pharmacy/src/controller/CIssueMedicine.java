/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import model.MIssueMedicine;
import java.sql.*;
import model.MCustomers;

/**
 *
 * @author chethanarowell
 */
public class CIssueMedicine {
    public ResultSet searchCustomer(String first)
    {
        MIssueMedicine csearch=new MIssueMedicine();
        return csearch.searchCustomer(first);
    }
    
    public ResultSet searchMedicine(String medicine_name)
    {
        MIssueMedicine msearch=new MIssueMedicine();
        return msearch.searchMedicine(medicine_name);
    }
    
    public void addBill(int bill_id, String id, String name, String medicine, int price, int quantity, int tot)
    {
        MIssueMedicine m1=new MIssueMedicine();
        m1.addBill(bill_id, id, name, medicine, price, quantity, tot);
    }
    
    public void showReport()
    {
        MIssueMedicine r1=new MIssueMedicine();
        r1.showReport();
    }
    
    public void salesReport()
    {
        MIssueMedicine s1=new MIssueMedicine();
        s1.salesReport();
    }
    
    
}
