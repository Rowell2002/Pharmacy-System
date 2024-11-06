/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.*;
import model.MAddMedicine;

/**
 *
 * @author chethanarowell
 */
public class CAddMedicine {
    public void addMedicine(int id, String name, String distributors, int price, String medicine_type, int quantity, Date expire_date)
    {
        MAddMedicine m1=new MAddMedicine();
        m1.addMedicine(id, name, distributors, price, medicine_type, quantity, expire_date);
        
    }  
    
    
}
