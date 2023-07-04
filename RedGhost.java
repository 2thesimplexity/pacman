import java.awt.*;

public class RedGhost implements Drawable{
    private int positionX = 300;
    private int positionY = 400;

    public void draw(Graphics g){
        g.setColor(Color.RED);
        if(positionY == 400){
            positionY = 0;
        }else{
            positionY += 20;
        }

        if(positionY > 400) positionY = 400;
        if(positionY < 0) positionY = 0;
        g.fillRect(positionX, positionY, 20, 20);
    }
}
