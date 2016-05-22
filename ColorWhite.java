/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp3ctrum;

import javafx.scene.paint.Color;

/**
 *
 * @author Julian
 */
public class ColorWhite extends PaintColor{
    
    public ColorWhite()
    {
        super();
        setColorHex("#FFFFFF");
    }
    @Override
    public void playerTouch()
    {
        GUI.player.collision = true;
    }
    @Override
    public void initialize() {
        
    }
}
