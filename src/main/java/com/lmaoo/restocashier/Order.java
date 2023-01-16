/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lmaoo.restocashier;

import java.util.ArrayList;

/**
 *
 * @author seifer
 */
public class Order {
    public ArrayList<Product> products;
    private double total = 0;
    
    Order(ArrayList<Product> products) {
        this.products = products;
    }
    
    public double getTotal() {
        total = 0;
        for (var p : products) {
            total += p.getTotalAmount();
        }
        
        return total;
    }
}
