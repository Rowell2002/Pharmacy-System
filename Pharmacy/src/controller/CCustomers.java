/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import model.MCustomers;

/**
 *
 * @author chethanarowell
 */
public class CCustomers {
    public void addCustomer(String customer_id, String title, String first_name, String last_name, int age, int contact_number)
    {
        MCustomers m1=new MCustomers();
        m1.addCustomer(customer_id, title, first_name, last_name, age, contact_number);
    }
}
