
package control;

import model.Bomb1;
import model.Bomb2;
import model.Gift1;
import model.builder;
import model.Gift2;
import model.Empty;
import model.Gate;
import model.Stone;
import model.Tree;
import java.awt.Point;
import java.util.Random;

public class board 
{
    public long time = System.currentTimeMillis();
    
    public static board B = null;
    private builder[][] builder;

    private board() {

    }

    public static board getSingleton() {
        if (B == null) {
            B = new board();
        }
        return B;
    }

    public void initializeBoard() {
        setBuilder(new builder[30][30]);

        Random r = new Random();
        Point position = new Point(0, 0);
        int Counter = 0;
        
        while (position.x != 29 || position.y != 29) {
            int z = r.nextInt(4);

            switch (z) {
                case 0:
                    if (position.y != 29) 
                    {
                        position.y++;
                        Counter++;
                        builder[position.y][position.x] = new Empty();
                        break;
                    }
                case 1: 
                    if (position.x != 29) 
                    {
                        position.x++;
                        Counter++;
                        builder[position.y][position.x] = new Empty();
                        break;
                    }
                case 2: 
                    if (position.y != 0) 
                    {
                        position.y--;
                        Counter++;
                        builder[position.y][position.x] = new Empty();
                        break;
                    }
                case 3:
                    if (position.x != 0)
                    {
                        position.x--;
                        Counter++;
                        builder[position.y][position.x] = new Empty();
                        break;
                    }

            }

            if (Counter > 200) 
            {
                builder = new builder[30][30];
                position = new Point(0, 0);
                Counter = 0;
            }

        }

        builder[0][0] = new Empty();
        builder[29][29] = new Gate();

        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                if (builder[i][j] != null) {
                    continue;
                }
                int z = r.nextInt(7);
                switch (z) {
                    case 0:
                        builder[i][j] = new Empty();
                        break;
                    case 1:
                        builder[i][j] = new Stone();
                        break;
                    case 2:
                        builder[i][j] = new Tree();
                        break;
                    case 3:
                        builder[i][j] = new Bomb1();
                        break;
                    case 4:
                        builder[i][j] = new Bomb2();
                        break;
                    case 5:
                        builder[i][j] = new Gift1();
                        break;
                    case 6:
                        builder[i][j] = new Gift2();
                        break;
                   
                }

            }
        }
 
    }

    /**
     * @return the builder
     */
    public builder[][] getBuilder() {
        return builder;
    }

    /**
     * @param builder the builder to set
     */
    public void setBuilder(builder[][] builder) {
        this.builder = builder;
    }

    
}


