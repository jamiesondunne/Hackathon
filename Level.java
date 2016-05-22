package sp3ctrum;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Santiago Benoit
 */
public class Level implements Serializable {
    
    public Level() {
        tiles = new ArrayList<>();
    }
    
    public void setWidth(int width) {
        this.width = width;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }
    
    public void setDepth(int depth) {
        this.depth = depth;
    }
    
    public void setStartColor(PaintColor color) {
        startColor = color;
    }
    
    public void setRedPosition(int x, int y, int z) {
        redX = x;
        redY = y;
        redZ = z;
    }
    
    public void setBluePosition(int x, int y, int z) {
        blueX = x;
        blueY = y;
        blueZ = z;
    }
    
    public void setYellowPosition(int x, int y, int z) {
        yellowX = x;
        yellowY = y;
        yellowZ = z;
    }
    
    public void addTile(Tile tile) {
        tiles.add(tile);
    }
    
    public void removeTile(Tile tile) {
        tiles.remove(tile);
    }
    
    public boolean tileIsAt(int x, int y, int z) {
        return getTile(x, y, z) != null;
    }
    
    public Tile getTile(int x, int y, int z) {
        for (Tile tile : tiles) {
            if (tile.getX() == x && tile.getY() == y && tile.getZ() == z) {
                return tile;
            }
        }
        return null;
    }
    
    public PaintColor getStartColor() {
        return startColor;
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public int getDepth() {
        return depth;
    }
    
    private int width, height, depth;
    private PaintColor startColor;
    private final ArrayList<Tile> tiles;
    private int redX, redY, redZ, yellowX, yellowY, yellowZ, blueX, blueY, blueZ;
}
