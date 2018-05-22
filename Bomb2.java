
package model;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;


public class Bomb2 extends Bomb
{
   Image img;
    public Bomb2() {
        img = ImageStore.getSingleton().bomb2;

    }
    @Override
    public void draw(Graphics G) 
    {
        Graphics2D g = (Graphics2D) G;
        
            g.drawImage(img, 0, 0, null);

       
    }

    @Override
    public String tybe() 
    {
         return "Bomb2";
    }
}
