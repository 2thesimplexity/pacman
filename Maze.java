import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;

public class Maze extends JPanel {
    private Drawable[] items = new Drawable[3];

    public void paintComponent (Graphics g){
        super.paintComponent(g);
        g.setColor((Color.LIGHT_GRAY));
        g.drawRect(0, 0, 500, 500);
        for(int i = 0; i<500; i = i+10){
            g.drawLine(i,0, i, 500);
        }
        for(int i = 0; i<500; i = i+10){
            g.drawLine(0,i, 500, i);
        }
        for(int i = 0; i<items.length; i++){
            items[i].draw(g);
        }
    }
    Maze(Pacman pacman, Ghost ghost, PowerDot powerDot){
        items[0] = pacman;
        items[1] = ghost;
        items[2] = powerDot;
    }
    
}
