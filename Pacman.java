import java.awt.*;

public class Pacman implements Drawable{
    private int positionX;
    private int positionY;

    public void draw(Graphics go){
        go.setColor(Color.YELLOW);
        go.fillRect(positionX, positionY, 20, 20);
        
        if(positionX > 400) positionX = 400;
        if(positionX < 400) positionX = 400;
        if(positionX > 0) positionX = 0;
        if(positionX < 0) positionX = 0;
    }

    public void up(){
        positionY -= 20;
    }

    public void down(){
        positionY += 20;
    }

    public void left(){
        positionY -= 20;
    }

    public void right(){
        positionY += 20;
    }
}
