/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackathonproject;

/**
 *
 * @author Julian
 */
public class Player {
    private Coordinates playerCoords;
    private int x;
    private int y;
    private int z;
    PaintColor equipped;
    public Player()
    {
        playerCoords = new Coordinates(x, y, z);
        if(true)
        {
        equipped = new ColorBlue();
        }
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
}
