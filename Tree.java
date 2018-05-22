package model;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

public class Tree extends wall {

    Image img;

    public Tree() {
        img = ImageStore.getSingleton().tree;

    }

    @Override
    public void draw(Graphics G) {
        Graphics2D g = (Graphics2D) G;

        g.drawImage(img, 0, 0, null);

    }

    @Override
    public String tybe() {
        return "tree";
    }
}
