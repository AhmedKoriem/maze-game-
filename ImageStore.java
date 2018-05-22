
package model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;


public class ImageStore {
    
    private static ImageStore I;
    
    Image tree;
    Image stone;
    Image bomb1;
    Image bomb2;
    Image Gift1;
    Image Gift2;
    Image Gate;
    Image empty;
    
    private ImageStore()
    {
        
        try {
            tree = ImageIO.read(new File("icons/tree.png"));
            stone = ImageIO.read(new File("icons/stone.png"));
            bomb1 = ImageIO.read(new File("icons/Bomb1.png"));
            bomb2 = ImageIO.read(new File("icons/bomb2.png"));
            Gift1 = ImageIO.read(new File("icons/Gift1.png"));
            Gift2 = ImageIO.read(new File("icons/Gift2.png"));
            empty = ImageIO.read(new File("icons/grass.jpg"));
            Gate = ImageIO.read(new File("icons/Gate.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(ImageStore.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    
    public static ImageStore getSingleton()
    {
        if (I == null)
            I = new ImageStore();
        return I;
    }
    
    
    
    
}
