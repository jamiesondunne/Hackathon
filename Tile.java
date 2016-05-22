package sp3ctrum;

/**
 *
 * @author Santiago Benoit
 */
public class Tile {
    public Tile(int x, int y, int z, boolean paintable) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.paintable = paintable;
        if (paintable) {
            currentColor = new ColorWhite();
        } else {
            currentColor = new ColorGray();
        }
    }
    
    public void playerTouch() {
        getPaintColor().playerTouch();
    }
    
    public void setPaintColor(PaintColor color) {
        currentColor = color;
        color.initialize();
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public int getZ() {
        return z;
    }
    
    public boolean isPaintable() {
        return paintable;
    }
    
    public PaintColor getPaintColor() {
        return currentColor;
    }
    
    private final int x, y, z;
    private final boolean paintable;
    private PaintColor currentColor;
}
