/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp3ctrum;

/**
 *
 * @author Julian
 */
public abstract class PaintColor {
    private String color;
    private int ingredientNum;
    private final PaintColor[] ingredients;
    public PaintColor()
    { 
        this.ingredients = new PaintColor[2];
    }
    public final void setColorHex(String hex)
    {
        color = hex;
    }
    public final String getColorHex()
    {
        return color;
    }
    public abstract void playerTouch();
    
    public abstract void initialize();
}
