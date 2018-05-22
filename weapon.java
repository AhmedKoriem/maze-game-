
package model;

import control.board;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import view.Frame;


public class weapon {

    int i;
    int j;
    Image img;
    int direction;
    Frame f;

    public weapon(int i, int j, int direction, Frame f) throws IOException {
        this.f = f;
        this.i = i;
        this.j = j;
        this.direction = direction;

        switch (direction) 
        {
            case 0:
                img = ImageIO.read(new File("icons/down.png"));
                break;
            case 1:
                img = ImageIO.read(new File("icons/right.png"));
                break;
            case 2:
                img = ImageIO.read(new File("icons/up.png"));
                break;
            case 3:
                img = ImageIO.read(new File("icons/left.png"));
                break;
        }
    }

    public void move() 
    {
        switch (direction) 
        {

            case (0):
            {
                while (i < 30) 
                {
                    
                    f.blocks[i][j].getGraphics().drawImage(img, 0, 0, null);

                    if (board.getSingleton().getBuilder()[i][j].colision() == 2) 
                    {
                        board.getSingleton().getBuilder()[i][j] = new Empty();
                        f.blocks[i][j].repaint();
                        break;
                    }
                    else if("stone".equals(board.getSingleton().getBuilder()[i][j].tybe()))
                    {
                        board.getSingleton().getBuilder()[i][j] = new Empty();
                        f.blocks[i][j].repaint();

                        break;
                    }

                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(weapon.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    f.blocks[i][j].repaint();
                    i++;
                }
                break;
            }
            case (1):
            {
                while (j < 30) 
                {
                    
                    f.blocks[i][j].getGraphics().drawImage(img, 0, 0, null);
                    
                    if (board.getSingleton().getBuilder()[i][j].colision() == 2) 
                    {
                        board.getSingleton().getBuilder()[i][j] = new Empty();
                        f.blocks[i][j].repaint();

                        break;
                    }
                    if(board.getSingleton().getBuilder()[i][j].tybe() == "stone")
                    {
                        board.getSingleton().getBuilder()[i][j] = new Empty();
                        f.blocks[i][j].repaint();

                        break;
                    }

                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(weapon.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
                    f.blocks[i][j].repaint();
                    j++;
                }
                break;
            }
            case(2):
            {
                while (i >= 0) 
                {
                    
                    f.blocks[i][j].getGraphics().drawImage(img, 0, 0, null);
                    
                    if (board.getSingleton().getBuilder()[i][j].colision() == 2) 
                    {
                        board.getSingleton().getBuilder()[i][j] = new Empty();
                        f.blocks[i][j].repaint();

                        break;
                    }
                    if(board.getSingleton().getBuilder()[i][j].tybe() == "stone")
                    {
                        board.getSingleton().getBuilder()[i][j] = new Empty();
                        f.blocks[i][j].repaint();

                        break;
                    }

                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(weapon.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
                    f.blocks[i][j].repaint();
                    i--;
                }
                break;
            }
            case(3):
            {
                while (j >= 0) 
                {
                    
                    f.blocks[i][j].getGraphics().drawImage(img, 0, 0, null);
                    
                    if (board.getSingleton().getBuilder()[i][j].colision() == 2) 
                    {
                        board.getSingleton().getBuilder()[i][j] = new Empty();
                        f.blocks[i][j].repaint();

                        break;
                    }
                    if(board.getSingleton().getBuilder()[i][j].tybe() == "stone")
                    {
                        board.getSingleton().getBuilder()[i][j] = new Empty();
                        f.blocks[i][j].repaint();

                        break;
                    }

                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(weapon.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
                    f.blocks[i][j].repaint();
                    j--;
                }
                break;
            }
                
        }

    }

}
