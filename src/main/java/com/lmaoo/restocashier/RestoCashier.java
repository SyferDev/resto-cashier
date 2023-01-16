/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lmaoo.restocashier;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

public class RestoCashier extends JFrame {
    private POSBackend backend;
//    private final ArrayList<Product> order = new ArrayList<>();
    private final Order order = new Order(new ArrayList<>());
    private double totalAmount = 0;
    
    private JButton btnOrder;
    private JPanel pnlOrder;
    private JPanel pnlProducts;
    private JTable table;
    DefaultTableModel model;
    private JTextField txtTotalAmount;
    private JLabel lblTotalAmount;
    
    public RestoCashier() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Resto Cashier");
        setBackground(Color.WHITE);
        
        generateProductsPanel();
        generateOrderList();
        generateOrderButton();
        updateTotalAmount();
 
        btnOrder.setText("Order");
         
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlProducts, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(pnlOrder, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOrder, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
                    .addComponent(pnlProducts, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
         
        pack();
    }
    
    final void generateOrderButton() {
        btnOrder = new JButton("Pay");
        
        pnlOrder.add(btnOrder);
        // TODO open new window with order
        
        btnOrder.addActionListener((ActionEvent arg0) -> {
            if (order.getTotal() <= 0) return;
            Payment pay = new Payment(order);
            pay.setVisible(true);
                                     
        });
    }
    
    final void generateProductsPanel() {
        pnlProducts = new JPanel(); 
        pnlProducts.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 
        
        // Products panel
        GridLayout layout = new GridLayout(5, 5, 5, 5);
        pnlProducts.setLayout(layout);

        loadProducts();
    }
    
    // Author: kyle
    final void generateOrderList() {
        pnlOrder = new JPanel();
        
        BoxLayout layout = new BoxLayout(pnlOrder, BoxLayout.Y_AXIS);
        pnlOrder.setLayout(layout);
        
        //create Table
        createTable();
        
        //textbox for total
        lblTotalAmount = new JLabel();
        lblTotalAmount.setText("Total Amount");
        lblTotalAmount.setHorizontalAlignment(SwingConstants.CENTER);
        JScrollPane sp = new JScrollPane(lblTotalAmount);
        
        txtTotalAmount = new JTextField();
        txtTotalAmount.setEditable(false);
        txtTotalAmount.setForeground(Color.RED);
        txtTotalAmount.setFont(new Font("Serif", Font.PLAIN, 25));
        txtTotalAmount.setHorizontalAlignment(SwingConstants.RIGHT);
        JScrollPane sp1 = new JScrollPane(txtTotalAmount);

        JButton btnDeleteRow = new JButton("Delete selected");
        btnDeleteRow.addActionListener(e -> deleteRow(table.getSelectedRow()));
        JScrollPane sp2 = new JScrollPane(btnDeleteRow);
        sp2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

        pnlOrder.add(sp);
        pnlOrder.add(sp1);
        pnlOrder.add(sp2);
        
    }
    
    public void createTable()
    {
        String[] columnNames = { "Product Name", "Qty", "Price", "Total Amount" };
        model = new DefaultTableModel(columnNames, 0);
        
        table = new JTable( model );
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //adding it to JScrollPane
        JScrollPane sp = new JScrollPane(table);
        pnlOrder.add(sp);
    }

    void loadProducts() {
        backend = new POSBackend(); // load data from json file
         
         var products = backend.getProducts();
         for (var product : products) {            
            JButton productBtn = new JButton(product.getName().trim());
            productBtn.addActionListener(e -> addToOrder(product));
            pnlProducts.add(productBtn);
         }
    }
    
    void addToOrder(Product product) {
        /*
        * Author: kyle chester
        */
        // (JSA) refactored cuz why not (70+ lines to less than 20)
        // (JSA) insane java filter LINQ style type beat LMAO wtf is this i miss javascript
        if (order.products.stream().filter(p -> p.getName().equals(product.getName())).findFirst().isPresent()) 
        {
            var index = order.products.indexOf(product);
            var prod = order.products.get(index);
            prod.setQuantity(prod.getQuantity() + 1);
            order.products.set(index, prod);
        }   
        else {
            order.products.add(product);
        }
        
        updateTotalAmount();
    }

    void deleteRow(int rowIndex) {
        if (rowIndex != -1) {     
            var row = order.products.stream().filter(p -> p.getName().equals(model.getValueAt(rowIndex, 0))).findFirst().get();
            order.products.remove(row);
            model.removeRow(rowIndex);
        }
        
        updateTotalAmount();
    }
    
    void updateTotalAmount() {
        totalAmount = 0;
        model.setRowCount(0); // clear the table
        for (int i = 0; i < order.products.size(); i++) {
            var p = order.products.get(i);
            Object[] row = { p.getName(), p.getQuantity(), p.getPrice(), p.getTotalAmount() };
            
            model.addRow(row);
            
            totalAmount += p.getTotalAmount();
        }
        txtTotalAmount.setText(String.valueOf(totalAmount));
    }
    
    public static void main(String[] args) {
        FlatLightLaf.setup();
        
        try {
            UIManager.setLookAndFeel( new FlatLightLaf() );
        } catch( UnsupportedLookAndFeelException ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        
        EventQueue.invokeLater(() -> {
           new RestoCashier().setVisible(true);
        });
    }
}