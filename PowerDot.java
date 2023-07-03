import java.awt.*;

public class PowerDot implements Drawable{
    private int positionX;
    private int positionY;

    public PowerDot(int i, int j){
        positionX = i;
        positionY = j;
    }

    public void draw(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(positionX, positionY, 20, 20);
    }
}
