
package maze.game;

import control.board;
import view.Frame;

public class MazeGame {


    public static void main(String[] args) 
    {
      board.getSingleton().initializeBoard();
      Frame frame = new Frame();
      frame.run();
    }
}
