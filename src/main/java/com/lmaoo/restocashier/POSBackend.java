/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lmaoo.restocashier;

import java.util.ArrayList;

/**
 * @author Seifer
 */
public class POSBackend {
    private final ArrayList<Product> products = new ArrayList<>();
    
    // THIS DOESNT WORK!!!! JAVA IS SO BAD 
//    public POSBackend() {
//        try (InputStream stream = getClass().getClassLoader().getResourceAsStream("/main/resources/products.json")) {
//            var rdr = new InputStreamReader(stream);
//            Type type = new TypeToken<ArrayList<Product>>(){}.getType();
//            Gson g = new Gson();
//            products = g.fromJson(rdr, type);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    
    public POSBackend() {
        // hard code because java sucks balls
        products.add(new Product("Chickenjoy          ", 79));
        products.add(new Product("Big Mac               ", 140));
        products.add(new Product("KFC Fried Chicken", 169));
        products.add(new Product("Shackburger         ", 225));
        products.add(new Product("Whopper             ", 169));
        products.add(new Product("Baconator            ", 199));
        products.add(new Product("Blizzard               ", 95));
        products.add(new Product("6\" Turkey Breast Sub", 165));
        products.add(new Product("Original Blend Coffee", 70));
        products.add(new Product("Pizza Pepperoni", 315));
        products.add(new Product("Bacon Burger           ", 375));
        products.add(new Product("Original Legendary Burger", 495));
        products.add(new Product("Mocha Frappuccino", 170));
        products.add(new Product("Spicy Chicken       ", 189));
        products.add(new Product("Classic Buttery Jack", 225));
        products.add(new Product("Six Dollar Burger", 249));
        products.add(new Product("Roast Beef Sandwich", 149));
        products.add(new Product("Bacon Cheeseburger", 449));
        products.add(new Product("Sliders                  ", 99));
        products.add(new Product("Double-Double", 349));

    }
    
    public ArrayList<Product> getProducts() {
        return products;
    }
}
