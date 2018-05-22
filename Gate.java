
package model;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;


public class Gate implements builder
{
    Image img;
    @Override
    public void draw(Graphics G) 
    {
         Graphics2D g = (Graphics2D) G;
         
               Image img = ImageStore.getSingleton().Gate;
               g.drawImage(img, 0, 0, null);
           
    }

    @Override
    public int colision() 
    {
        return 5;
    }

    @Override
    public String tybe() 
    {
         return "Gate";
    }
    
}
