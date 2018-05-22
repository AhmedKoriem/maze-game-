
package model;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import javax.swing.JPanel;


public class player 
{
    public static final int R = 2;
    public static final int B = 3;
    private int M = B;
    private boolean Dir = true;
    private double x;
    private double y;
    private double lx;
    private double ly;
    private JPanel panel;
    private HashMap<String,int[]> moves;
    private BufferedImage[] images;
    private String Anim;
    private int frame;
    private int[] FrameSet;
    
    public player ()
    {
        moves = new HashMap<String, int[]>();
        iniSprite();
    }
    
     private void iniSprite() {
        BufferedImage img = image.loadImage("icons/mario.png");
        BufferedImage[] imgs = image.splitImage(img,6,4);
        this.images = imgs;
        Add("forward", new int[]{15,16,17});
        Add("back", new int[]{3,4,5});
        Add("left", new int[]{21,22,23});
        Add("right", new int[]{9,10,11});
        setM(this.R);
        setAnim("forward");  
    }
     
    public void draw() 
    {
       while (true) 
       {
            Graphics2D g = (Graphics2D) panel.getGraphics();
            drawPerson(g);
            panel.revalidate();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void Add(String N, int[] i) 
    {
         moves.put(N,i);
        setAnim(N);
        
    }

    private void setM(int m) 
    {
        if (m == R || m == B) {
            this.M = m;
        }
    }

    public void setAnim(String N) 
    {
        if (moves.containsKey(N)) 
        {
            Anim = N;
            FrameSet = moves.get(getAnim());
            frame = 0;
        }
    }

    private void drawPerson(Graphics2D g) 
    {
        setLocation(0, 0);
        g.clearRect((int) lx - 1, (int) ly - 1, getWidth() + 1, getHeight() + 1);
        int imgNum = FrameSet[frame];
        g.drawImage(images[imgNum], (int) x, (int) y, null);
        if (frame == FrameSet.length - 1) {
            if (M == B) {
                frame = 0;
            } else {
                Dir = false;
                frame--;
            }
        } else {
            if (M == B) {
                frame++;
            } else {
                if (frame == 0) {
                    Dir = true;
                }
                if (Dir) {
                    frame++;
                }
                if (!Dir) {
                    frame--;
                }
            }
        }
        lx = x;
        ly = y;
    }

    private void setLocation(double x, double y) 
    {
        this.x = x;
        this.y = y;
    }

   
    /**
     * @return the x
     */
    public double getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public double getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * @return the panel
     */
    public JPanel getPanel() {
        return panel;
    }

    /**
     * @param panel the panel to set
     */
    public void setPanel(JPanel panel) {
        this.panel = panel;
    }


    public String getAnim() {
        return Anim;
    }
    
      public int getWidth() {
        return images[0].getWidth();
    }


    public int getHeight() {
        return images[0].getHeight();
    }
    
}
