/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lmaoo.restocashier;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JButton;

/**
 *
 * @author seifer
 */
public class RoundedButton extends JButton {

    public RoundedButton(String label) {
        super(label);
        setContentAreaFilled(false);
        
        backgroundColor = new Color(3, 169, 244);
        backgroundColorHover = new Color(2, 136, 209);
        setContentAreaFilled(false);
    }
    
    private boolean mouseOver;
    private Color backgroundColor;
    private Color backgroundColorHover;
    private Color backgroundColorClicked;
    
    private int radius = 10;

    /**
     * @return the mouseOver
     */
    public boolean isMouseOver() {
        return mouseOver;
    }

    /**
     * @param mouseOver the mouseOver to set
     */
    public void setMouseOver(boolean mouseOver) {
        this.mouseOver = mouseOver;
    }

    /**
     * @return the backgroundColor
     */
    public Color getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * @param backgroundColor the backgroundColor to set
     */
    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    /**
     * @return the backgroundColorHover
     */
    public Color getBackgroundColorHover() {
        return backgroundColorHover;
    }

    /**
     * @param backgroundColorHover the backgroundColorHover to set
     */
    public void setBackgroundColorHover(Color backgroundColorHover) {
        this.backgroundColorHover = backgroundColorHover;
    }

    /**
     * @return the backgroundColorClicked
     */
    public Color getBackgroundColorClicked() {
        return backgroundColorClicked;
    }

    /**
     * @param backgroundColorClicked the backgroundColorClicked to set
     */
    public void setBackgroundColorClicked(Color backgroundColorClicked) {
        this.backgroundColorClicked = backgroundColorClicked;
    }

    /**
     * @return the radius
     */
    public int getRadius() {
        return radius;
    }

    /**
     * @param radius the radius to set
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }
    
    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D g = (Graphics2D)graphics;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        g.setColor(getBackground());
        g.fillRoundRect(2, 2, getWidth() - 4, getHeight() - 4, radius, radius);
        super.paintComponent(graphics);
    }
    
}

