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
    
    public void addTile(Tile tile) {
        tiles.add(tile);
    }
    
    public void removeTile(Tile tile) {
        tiles.remove(tile);
    }
    
    public boolean tileIsAt(Coordinates coords) {
        return getTile(coords) != null;
    }
    public Tile getTile(Coordinates coords) {
        for (Tile tile : tiles) {
            if (tile.getCoords().equals(coords)) {
                return tile;
            }
        }
        return null;
    }
    
    public PaintColor getStartColor() {
        return startColor;
    }
    
    private int width, height, depth;
    private PaintColor startColor;
    private final ArrayList<Tile> tiles;
}
