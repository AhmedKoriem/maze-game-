

package model;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;


public class Stone extends wall
{
    
    Image img;

    @Override
    public void draw(Graphics G) 
    {
         Graphics2D g = (Graphics2D) G;
        
            img = ImageStore.getSingleton().stone;
            g.drawImage(img, 0, 0, null);

        
    }

    @Override
    public String tybe() 
    {
         return "stone";
    }
}
