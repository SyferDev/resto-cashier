/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lmaoo.restocashier;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 *
 * @author Seifer
 */
public class POSBackend {
    private ArrayList<Product> products = new ArrayList<>();
    
    public POSBackend() {
        File productsJson = new File("products.json");
        
        if (productsJson.exists()) {
            try {
                FileReader rdr = new FileReader(productsJson);
                Type type = new TypeToken<ArrayList<Product>>(){}.getType();
                Gson g = new Gson();
                products = g.fromJson(rdr, type);
            }
            catch (JsonIOException | JsonSyntaxException | FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
    
    public ArrayList<Product> getProducts() {
        return products;
    }
}
