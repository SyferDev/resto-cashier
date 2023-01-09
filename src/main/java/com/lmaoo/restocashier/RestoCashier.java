/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lmaoo.restocashier;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

/**
 *
 * @author Seifer
 */
public class RestoCashier extends JFrame {
    private POSBackend backend;
    private final ArrayList<Product> order = new ArrayList<>();
    
    private JButton btnOrder;
    private JPanel pnlOrder;
    private JPanel pnlProducts;
    
    public RestoCashier() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Resto Cashier");
        
        generateProductsPanel();
        generateOrderList();
        generateOrderButton();
 
         btnOrder.setText("Order");
 
         GroupLayout layout = new GroupLayout(getContentPane());
         getContentPane().setLayout(layout);
         layout.setHorizontalGroup(
             layout.createParallelGroup(GroupLayout.Alignment.LEADING)
             .addGroup(layout.createSequentialGroup()
                 .addContainerGap()
                 .addComponent(pnlProducts, GroupLayout.PREFERRED_SIZE, 900, GroupLayout.PREFERRED_SIZE)
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                     .addComponent(pnlOrder, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                     .addComponent(btnOrder, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
                 .addContainerGap())
         );
         layout.setVerticalGroup(
             layout.createParallelGroup(GroupLayout.Alignment.LEADING)
             .addGroup(layout.createSequentialGroup()
                 .addContainerGap()
                 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                     .addGroup(layout.createSequentialGroup()
                         .addComponent(pnlOrder, GroupLayout.PREFERRED_SIZE, 800, GroupLayout.PREFERRED_SIZE)
                         .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                         .addComponent(btnOrder, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
                     .addComponent(pnlProducts, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                 .addContainerGap())
         );
         
        pack();
    }
    
    final void generateOrderButton() {
        btnOrder = new JButton("Create Order");
        pnlOrder.add(btnOrder);
        
        // TODO open new window with order
    }
    
    /**
     * Author: Seifer Albacete
     * Description: Create Products panel (grid of buttons)
     */
    final void generateProductsPanel() {
        pnlProducts = new JPanel(); 
        pnlProducts.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 
        
        // Products panel
        GridLayout layout = new GridLayout(5, 5, 5, 5);
        pnlProducts.setLayout(layout);
        
        loadProducts();
    }
    
    final void generateOrderList() {
        pnlOrder = new JPanel();
        
        BoxLayout layout = new BoxLayout(pnlOrder, BoxLayout.Y_AXIS);
        pnlOrder.setLayout(layout);
        
        // idk ikaw na bahala LMAO
    }
    
    void loadProducts() {
        backend = new POSBackend(); // load data from json file
         
         var products = backend.getProducts();
         for (var product : products) {
             JButton productBtn = new JButton(product.getName());
             productBtn.addActionListener(e -> addToOrder(product));
             pnlProducts.add(productBtn);
         }
    }
    
    void addToOrder(Product product) {
        order.add(product);
        regeneratePanel(pnlOrder); // required to make things show
    }

    // helper functions
    final void regeneratePanel(JPanel panel) {
        panel.revalidate();
        panel.repaint();
        pack();
    }
    public static void main(String[] args) {
         EventQueue.invokeLater(() -> {
             new RestoCashier().setVisible(true);
         });
    }
}
