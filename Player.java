package hackathonproject;

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
    private int z;
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
    public void setZ(int z)
    {
        this.z = z;
    }
    public int getX()
    {
        return x;
    }
    public int getY(int y)
    {
        return y;
    }
    public int getZ(int z)
    {
        return z;
    }
    
    
}
