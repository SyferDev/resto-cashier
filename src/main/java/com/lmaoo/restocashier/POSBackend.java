/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lmaoo.restocashier;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Seifer
 */
public class POSBackend {
    private final ArrayList<Product> products = new ArrayList<>();
    
    // THIS DOESNT WORK!!!! JAVA WONT LET ME READ MY PACKAGED JSON FILES WHEN BUILT
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
        products.add(new Product("Chickenjoy", ProductCategory.MEAL, 79));
        products.add(new Product("Big Mac", ProductCategory.MEAL, 140));
        products.add(new Product("KFC Fried Chicken", ProductCategory.MEAL, 169));
        products.add(new Product("Shackburger", ProductCategory.MEAL, 225));
        products.add(new Product("Whopper", ProductCategory.MEAL, 169));
        products.add(new Product("Baconator", ProductCategory.MEAL, 199));
        products.add(new Product("Blizzard", ProductCategory.DESSERT, 95));
        products.add(new Product("6\" Turkey Breast Sub", ProductCategory.MEAL, 165));
        products.add(new Product("Original Blend Coffee", ProductCategory.DRINK, 70));
        products.add(new Product("Pizza Pepperoni", ProductCategory.MEAL, 315));
        products.add(new Product("Bacon Burger", ProductCategory.MEAL, 375));
        products.add(new Product("Original Legendary Burger", ProductCategory.MEAL, 495));
        products.add(new Product("Mocha Frappuccino", ProductCategory.DRINK, 170));
        products.add(new Product("Spicy Chicken", ProductCategory.MEAL, 189));
        products.add(new Product("Classic Buttery Jack", ProductCategory.MEAL, 225));
        products.add(new Product("Six Dollar Burger", ProductCategory.MEAL, 249));
        products.add(new Product("Roast Beef Sandwich", ProductCategory.MEAL, 149));
        products.add(new Product("Bacon Cheeseburger", ProductCategory.MEAL, 449));
        products.add(new Product("Sliders", ProductCategory.MEAL, 99));
        products.add(new Product("Double-Double", ProductCategory.MEAL, 349));
    }
    
    public ArrayList<Product> getProducts() {
        Collections.sort(products, (Product p1, Product p2) -> {
            if (p1.getCategory().equals(p2.getCategory()))
                return p1.getName().compareTo(p2.getName());
            
            return p1.getCategory().compareTo(p2.getCategory());
        });
        
        return products;
    }
}
