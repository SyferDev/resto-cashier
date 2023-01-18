/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lmaoo.restocashier;

/**
 *
 * @author Seifer
 */

public class Product {
    private String name;
    private final ProductCategory category;
    private double price;
    private int quantity = 1;

    public Product(String name, ProductCategory category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }
    
    public String getName() {
        return name;
    }

    public ProductCategory getCategory() {
        return category;
    }
    
    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalAmount() {
        return price * quantity;
    }
    
    
}
