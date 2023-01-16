/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lmaoo.restocashier;

import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author seifer
 */
public class ProductButton extends JButton {
    public ProductButton(String label) {
        super(label);
        setBorder(new EmptyBorder(0, 0, 0, 0));
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        
    }

}
