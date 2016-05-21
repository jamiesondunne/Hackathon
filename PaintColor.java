/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackathonproject;

import javafx.scene.paint.Color;

/**
 *
 * @author Julian
 */
public abstract class PaintColor {
    private Color color;
    private int ingredientNum;
    private final PaintColor[] ingredients;
    public PaintColor()
    { 
        this.ingredients = new PaintColor[2];
    }
    public final void setColor(Color a)
    {
        color = a;
    }
    public final Color getColor()
    {
        return color;
    }
    public abstract void playerTouch();
    
    
}
