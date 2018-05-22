
package model;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;


public class Gift2 extends Gift
{
Image img;
    public Gift2() {
        img = ImageStore.getSingleton().Gift2;

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
          return "Gift2";
    }
}
