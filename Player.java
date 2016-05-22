package hackathonproject;

import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;


/**
 *
 * @author Julian
 */
public class Player implements Serializable{
    private int x;
    private int y;
    private int tileZ;
    private int tileX;
    private int tileY;
    PaintColor equipped;
    Level level;
    public Player()
    {
        try
        {
            File levelFile = new File("levels" + levelNumber);
            FileInputStream fileInput = new FileInputStream(levelFile);
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);
            level = (Level) objectInput.readObject();
        }catch(Exception e){}
        if(level.getStartColor() instanceof ColorBlue)
        {
        		equipped = new ColorBlue();
        } 
      else if(level.getStartColor() instanceof ColorYellow)
      {
        equipped = new ColorYellow();
      }
      else if(level.getStartColor() instanceof ColorRed)
      {
        equipped = new ColorRed();
      }
        
    }
    public int getChangeX(int mouseX)
    {
        return(mouseX - this.x);
    }
    public int getChangeY(int mouseY)
    {
        return(mouseY - this.y);
    }
    public double getSlope(int mouseX, int mouseY)
    { 
        return((double)(getChangeY(mouseY)/getChangeX(mouseX)));
    }
    public void setX(int x)
    {
        this.x = x;
    }
    public void setY(int y)
    {
        this.y = y;
    }
    public void setTileX(int tileX)
    {
        this.tileX = tileX;
    }
    public void setTileY(int tileY)
    {
        this.tileY = tileY;
    }
    public void setTileZ(int tileZ)
    {
        this.tileZ = tileZ;
    }
    public int getX()
    {
        return x;
    }
    public int getY(int y)
    {
        return y;
    }
    public int getTileX()
    {
        return tileX;
    }
    public int getTileY()
    {
        return tileY;
    }
    public int getTileZ()
    {
        return tileZ;
    }
    
    public void moveLeft()
    {
        setX(x - 8);
    }
    public void moveRight()
    {
        setX(x + 8);
    }
    public void moveForward()
    {
        setTileZ(tileZ + 1);
    }
    public void moveBackward()
    {
        setTileZ(tileZ - 1);
    }
}
