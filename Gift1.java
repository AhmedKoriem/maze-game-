
package model;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;


public class Gift1 extends Gift 
{
  Image img;
    public Gift1() {
        img = ImageStore.getSingleton().Gift1;

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
        return "Gift1";
    }
}
