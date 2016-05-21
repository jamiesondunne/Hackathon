package com.sp3ctrum;

/**
 *
 * @author Santiago Benoit
 */
public class Tile {
    public Tile(Coordinates coords, boolean paintable) {
        this.coords = coords;
        this.paintable = paintable;
        if (paintable) {
            currentColor = new ColorWhite();
        } else {
            currentColor = new ColorBlack();
        }
    }
    
    public void playerTouch() {
        getColor().playerTouch();
    }
    
    public void setColor(PaintColor color) {
        currentColor = color;
    }
    
    public Coordinates getCoords() {
        return coords;
    }
    
    public boolean isPaintable() {
        return paintable;
    }
    
    public PaintColor getColor() {
        return currentColor;
    }
    
    private final Coordinates coords;
    private final boolean paintable;
    private PaintColor currentColor;
}
