
package view;

import control.board;
import java.awt.Graphics;
import javax.swing.JPanel;


public class BlockPanel extends JPanel
{

    int i;
    int j;
    
    public BlockPanel(int i , int j ) 
    {    
        this.i = i;
        this.j = j;
    }
    
    
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        board.getSingleton().getBuilder()[i][j].draw(g);    
    }
    
}
