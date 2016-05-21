package sp3ctrum;

/**
 *
 * @author Santiago Benoit
 */
public class Coordinates {
    public Coordinates(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
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
    private final int x, y, z;
}
