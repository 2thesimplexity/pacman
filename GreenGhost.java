import java.awt.*;

public class GreenGhost implements Drawable{
    private int positionX = 400;
    private int positionY = 80;

    public void draw(Graphics g){
        g.setColor(Color.GREEN);
        if(positionX == 400){
            positionX = 0;
        }else{
            positionX += 20;
        }
        if(positionX > 400) positionX = 400;
        if(positionX < 0) positionX = 0;
        g.fillRect(positionX, positionY, 20, 20);
    }
}
