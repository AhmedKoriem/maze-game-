package control;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.Frame;
import model.Empty;
import model.weapon;

public class keylistners implements KeyListener {

    Frame frame;
    weapon w;
    Empty E;
    int l_x;
    int l_y;
    int oldx;
    int oldy;
    public long S;
    Color Color;
    int T ;

    public keylistners(Frame frame) {
        this.frame = frame;
        l_x = 0;
        l_y = 0;
        oldx = 0;
        oldy = 0;
        S = 0;
        T = 10;
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        switch (ke.getKeyCode()) {
            case (KeyEvent.VK_RIGHT):
                if (l_x != 29) {
                    l_x++;
                    if (board.getSingleton().getBuilder()[l_y][l_x].colision() == 1) {
                        frame.p.setAnim("right");
                        frame.p.setPanel(frame.blocks[l_y][l_x]);
                        frame.repaintt(l_y, l_x - 1);
                    }
                    if (board.getSingleton().getBuilder()[l_y][l_x].colision() == 2) {
                        oldy = l_y;
                        oldx = l_x;
                        l_y = 0;
                        l_x = 0;
                        frame.p.setAnim("forward");
                        frame.p.setPanel(frame.blocks[l_y][l_x]);
                        frame.repaintt(oldy, oldx - 1);
                        frame.dispose();
                        frame.score("YOU LOST :,(  SCORE = " + S);
                    }
                    if (board.getSingleton().getBuilder()[l_y][l_x].colision() == 3) {
                        frame.p.setAnim("right");
                        frame.p.setPanel(frame.blocks[l_y][l_x]);
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(keylistners.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        frame.repaintt(l_y, l_x - 1);
                        if ("Gift1".equals(board.getSingleton().getBuilder()[l_y][l_x].tybe())) {
                            S = S + 10 - ((System.currentTimeMillis() - board.getSingleton().time) / 1000);
                            board.getSingleton().time = System.currentTimeMillis();
                        }
                        if ("Gift2".equals(board.getSingleton().getBuilder()[l_y][l_x].tybe())) {
                            S = S + 20 - ((System.currentTimeMillis() - board.getSingleton().time) / 1000);
                            board.getSingleton().time = System.currentTimeMillis();
                        }
                        frame.score.setText("Score : " + S);
                        board.getSingleton().getBuilder()[l_y][l_x] = new Empty();
                    }
                    if (board.getSingleton().getBuilder()[l_y][l_x].colision() == 4) {

                        l_x--;
                        frame.p.setAnim("right");
                        frame.p.setPanel(frame.blocks[l_y][l_x]);
                    }
                    if (board.getSingleton().getBuilder()[l_y][l_x].colision() == 5) {
                        oldy = l_y;
                        oldx = l_x;
                        frame.p.setAnim("forward");
                        frame.p.setPanel(frame.blocks[l_y][l_x]);
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(keylistners.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        frame.blocks[oldy][oldx - 1].repaint();
                        S = S + 5;
                        frame.score.setText("Final Score : " + S);
                        frame.dispose();
                        frame.score("YOU WIN ! SCORE =  " + S);
                    }
                }
                break;

            case (KeyEvent.VK_LEFT):
                if (l_x != 0) {
                    l_x--;
                    if (board.getSingleton().getBuilder()[l_y][l_x].colision() == 1) {
                        frame.p.setAnim("left");
                        frame.p.setPanel(frame.blocks[l_y][l_x]);
                         try {
                            Thread.sleep(20);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(keylistners.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        frame.repaintt(l_y, l_x + 1);
                    }
                    if (board.getSingleton().getBuilder()[l_y][l_x].colision() == 2) {
                        oldy = l_y;
                        oldx = l_x;
                        l_y = 0;
                        l_x = 0;
                        frame.p.setAnim("forward");
                        frame.p.setPanel(frame.blocks[l_y][l_x]);
                        frame.blocks[oldy][oldx + 1].repaint();
                        frame.dispose();
                        frame.score("YOU LOST :,(  SCORE = " + S);
                    }
                    if (board.getSingleton().getBuilder()[l_y][l_x].colision() == 3) {
                        frame.p.setAnim("left");
                        frame.p.setPanel(frame.blocks[l_y][l_x]);
                         try {
                            Thread.sleep(20);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(keylistners.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        frame.repaintt(l_y, l_x + 1);
                        if ("Gift1".equals(board.getSingleton().getBuilder()[l_y][l_x].tybe())) {
                            S = S + 10 - ((System.currentTimeMillis() - board.getSingleton().time) / 1000);
                            board.getSingleton().time = System.currentTimeMillis();
                        }
                        if ("Gift2".equals(board.getSingleton().getBuilder()[l_y][l_x].tybe())) {
                            S = S + 20 - ((System.currentTimeMillis() - board.getSingleton().time) / 1000);
                            board.getSingleton().time = System.currentTimeMillis();
                        }
                        frame.score.setText("Score : " + S);
                        board.getSingleton().getBuilder()[l_y][l_x] = new Empty();
                    }
                    if (board.getSingleton().getBuilder()[l_y][l_x].colision() == 4) {
                        l_x++;
                        frame.p.setAnim("left");
                        frame.p.setPanel(frame.blocks[l_y][l_x]);
                    }
                    if (board.getSingleton().getBuilder()[l_y][l_x].colision() == 5) {
                        oldy = l_y;
                        oldx = l_x;
                        l_y = 0;
                        l_x = 0;
                        frame.p.setAnim("forward");
                        frame.p.setPanel(frame.blocks[l_y][l_x]);
                         try {
                            Thread.sleep(20);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(keylistners.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        frame.repaintt(oldy, oldx + 1);
                        S = S + 5;
                        frame.score.setText("Final Score : " + S);
                        frame.dispose();
                        frame.score("YOU WIN ! SCORE =  " + S);
                    }
                }
                break;
            case (KeyEvent.VK_UP):
                if (l_y != 0) {
                    l_y--;
                    if (board.getSingleton().getBuilder()[l_y][l_x].colision() == 1) {
                        frame.p.setAnim("back");
                        frame.p.setPanel(frame.blocks[l_y][l_x]);
                         try {
                            Thread.sleep(20);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(keylistners.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        frame.blocks[l_y + 1][ l_x].repaint();
                    }
                    if (board.getSingleton().getBuilder()[l_y][l_x].colision() == 2) {
                        oldy = l_y;
                        oldx = l_x;
                        l_y = 0;
                        l_x = 0;
                        frame.p.setAnim("forward");
                        frame.p.setPanel(frame.blocks[l_y][l_x]);
                         try {
                            Thread.sleep(20);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(keylistners.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        frame.repaintt(oldy + 1, oldx);
                        frame.dispose();
                        frame.score("YOU LOST :,(  SCORE = " + S);
                    }
                    if (board.getSingleton().getBuilder()[l_y][l_x].colision() == 3) {
                        frame.p.setAnim("back");
                        frame.p.setPanel(frame.blocks[l_y][l_x]);
                         try {
                            Thread.sleep(20);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(keylistners.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        frame.repaintt(l_y + 1, l_x);
                        if ("Gift1".equals(board.getSingleton().getBuilder()[l_y][l_x].tybe())) {
                            S = S + 10 - ((System.currentTimeMillis() - board.getSingleton().time) / 1000);
                            board.getSingleton().time = System.currentTimeMillis();
                        }
                        if ("Gift2".equals(board.getSingleton().getBuilder()[l_y][l_x].tybe())) {
                            S = S + 20 - ((System.currentTimeMillis() - board.getSingleton().time) / 1000);
                            board.getSingleton().time = System.currentTimeMillis();
                        }
                        frame.score.setText("Score : " + S);
                        board.getSingleton().getBuilder()[l_y][l_x] = new Empty();
                    }
                    if (board.getSingleton().getBuilder()[l_y][l_x].colision() == 4) {
                        l_y++;
                        frame.p.setAnim("back");
                        frame.p.setPanel(frame.blocks[l_y][l_x]);
                    }
                    if (board.getSingleton().getBuilder()[l_y][l_x].colision() == 5) {
                        oldy = l_y;
                        oldx = l_x;
                        l_y = 0;
                        l_x = 0;
                        frame.p.setAnim("forward");
                        frame.p.setPanel(frame.blocks[l_y][l_x]);
                         try {
                            Thread.sleep(20);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(keylistners.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        frame.repaintt(oldy + 1, oldx);
                        S = S + 5;
                        frame.score.setText("final Score : " + S);
                        frame.dispose();
                        frame.score("YOU WIN ! SCORE =  " + S);
                    }
                }
                break;
            case (KeyEvent.VK_DOWN):
                if (l_y != 29) {
                    l_y++;
                    if (board.getSingleton().getBuilder()[l_y][l_x].colision() == 1) {
                        frame.p.setAnim("forward");
                        frame.p.setPanel(frame.blocks[l_y][l_x]);
                         try {
                            Thread.sleep(20);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(keylistners.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        frame.blocks[l_y - 1][l_x].repaint();
                    }
                    if (board.getSingleton().getBuilder()[l_y][l_x].colision() == 2) {
                        oldy = l_y;
                        oldx = l_x;
                        l_y = 0;
                        l_x = 0;
                        frame.p.setAnim("forward");
                        frame.p.setPanel(frame.blocks[l_y][l_x]);
                         try {
                            Thread.sleep(20);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(keylistners.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        frame.repaintt(oldy - 1, oldx);
                        frame.dispose();
                        frame.score("YOU LOST :,(  SCORE = " + S);
                    }
                    if (board.getSingleton().getBuilder()[l_y][l_x].colision() == 3) {
                        frame.p.setAnim("forward");
                        frame.p.setPanel(frame.blocks[l_y][l_x]);
                         try {
                            Thread.sleep(20);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(keylistners.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        frame.repaintt(l_y - 1, l_x);
                        if ("Gift1".equals(board.getSingleton().getBuilder()[l_y][l_x].tybe())) {
                            S = S + 10 - ((System.currentTimeMillis() - board.getSingleton().time) / 1000);
                            board.getSingleton().time = System.currentTimeMillis();
                        }
                        if ("Gift2".equals(board.getSingleton().getBuilder()[l_y][l_x].tybe())) {
                            S = S + 20 - ((System.currentTimeMillis() - board.getSingleton().time) / 1000);
                            board.getSingleton().time = System.currentTimeMillis();
                        }
                        frame.score.setText("Score : " + S);
                        board.getSingleton().getBuilder()[l_y][l_x] = new Empty();
                    }
                    if (board.getSingleton().getBuilder()[l_y][l_x].colision() == 4) {
                        l_y--;
                        frame.p.setAnim("forward");
                        frame.p.setPanel(frame.blocks[l_y][l_x]);
                    }
                    if (board.getSingleton().getBuilder()[l_y][l_x].colision() == 5) {
                        oldy = l_y;
                        oldx = l_x;
                        l_y = 0;
                        l_x = 0;
                        frame.p.setAnim("forward");
                        frame.p.setPanel(frame.blocks[l_y][l_x]);
                        frame.repaintt(oldy - 1, oldx);
                        S = S + 5;
                        frame.score.setText("final Score : " + S);
                        frame.dispose();
                        frame.score("YOU WIN ! SCORE =  " + S);
                    }
                }
                break;

            case (KeyEvent.VK_ESCAPE):
                frame.F.dispose();
                break;

            case (KeyEvent.VK_S): 
            {
                if (T >0)
                {
                    try {
                        w = new weapon(l_y+1,l_x,0,frame);
                    } catch (IOException ex) {
                        Logger.getLogger(keylistners.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    w.move();
                    T--;
                }
                break;
            }
            case (KeyEvent.VK_D):
            {
             if (T >0)
                {
                    try {
                        w = new weapon(l_y,l_x+1,1,frame);
                    } catch (IOException ex) {
                        Logger.getLogger(keylistners.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    w.move();
                    T--;   
                }
             break;
            }
            case (KeyEvent.VK_W):
            {
             if (T >0)
                {
                    try {
                        w = new weapon(l_y-1,l_x,2,frame);
                    } catch (IOException ex) {
                        Logger.getLogger(keylistners.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    w.move();
                    T--;   
                }
              break;
            }
            case (KeyEvent.VK_A):
            {
             if (T >0)
                {
                    try {
                        w = new weapon(l_y,l_x-1,3,frame);
                    } catch (IOException ex) {
                        Logger.getLogger(keylistners.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    w.move();
                    T--;   
                }

            }    
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

}
