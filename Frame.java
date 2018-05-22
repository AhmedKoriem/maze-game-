
package view;

import control.board;
import model.player;
import control.keylistners;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frame extends JFrame
{
   public  JFrame F;
   public  JFrame f1;
   public  JPanel j;
   public  JPanel Panel ;
   public  JPanel boardPanel;
   public  BlockPanel [][] blocks = new BlockPanel[30][30];
   public  JLabel score;
   public  keylistners K ;
   public  player p;
    
    public Frame()
    {
        F = new JFrame();
        f1 = new JFrame();
        score = new JLabel("Score : 0 ");
        Panel = new JPanel();
        boardPanel = new JPanel();
        K = new keylistners(this);
        j = new JPanel(); 
    }
    
    public void run()
    {

        Panel.setBackground(Color.GREEN);
        boardPanel.setLayout(new GridLayout(30, 30));
         
        for (int  i = 0 ; i < 30 ; i++)
        {
            for ( int j = 0 ; j < 30 ; j++)
            {
                blocks[i][j] = new BlockPanel(i, j);
                boardPanel.add(blocks[i][j]);
            }
        }
        Panel.add(score);
        F.add(boardPanel, BorderLayout.CENTER);
        F.setBackground(Color.white);
        F.add(Panel, BorderLayout.NORTH);
        F.addKeyListener(K);
        F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        F.setResizable(false);
        F.setSize(800, 750);
        F.setLocationRelativeTo(null);
        F.setTitle("Maze Game B2aa :D");
        F.setVisible(true);
        intialize();
        p = new player();
        p.setPanel(blocks[0][0]);
        p.draw();
        

        
    }

    public void intialize() {
        for (int i = 0 ; i < 30 ; i++)
        {
            for (int j = 0 ; j < 30 ; j++)
            {
                blocks[i][j].repaint();
            }
        }
    }
    
    public void repaintt(int i,int j)
    {
        blocks[i][j].getGraphics().dispose();
        blocks[i][j].repaint();
    }
    
    public void score (String s)
    {
        j.add(new JLabel(s), BorderLayout.CENTER);
        j.setLocation(50, 50);
        f1.add(j,BorderLayout.CENTER);
        f1.setSize(300, 200);
        f1.setLocationRelativeTo(null);
        f1.setResizable(false);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setVisible(true);
    }
    
}


