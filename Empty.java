
package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;


public class Empty implements builder {

    @Override
    public void draw(Graphics g) 
    {
          Image img = ImageStore.getSingleton().empty;
               g.drawImage(img, 0, 0, null);
    }

    @Override
    public int colision() 
    {
      return 1;
    }

    @Override
    public String tybe() 
    {
         return "Empty";
    }
}