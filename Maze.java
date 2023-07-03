import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
public class Maze extends JPanel {
    private List<Drawable> items = new ArrayList<>();

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
        for(Drawable item: items){
            item.draw(g);
        }
    }
    Maze(Pacman pacman, Ghost ghost, List<PowerDot> powerDots){
        items.add(pacman);
        items.add(ghost);
        items.addAll(powerDots);
    }
}