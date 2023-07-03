import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class Game extends JFrame implements ActionListener, KeyListener {

    private Maze maze;
    private Pacman pacman;
    private Ghost ghost;
    private List<PowerDot> powerDots;

    public Game() {
        pacman = new Pacman();
        ghost = new Ghost();
        powerDots = new ArrayList<>();
        for(int x = 40; x <= 400; x += 40){
            for(int y = 20; y <= 400; y += 40){
                powerDots.add(new PowerDot(x, y));
            }
        }
        maze = new Maze(pacman, ghost, powerDots);
        this.getContentPane().add(maze);
        this.addKeyListener(this);
    }

    public void startTimer(){
        Timer timer = new Timer(100, this);
        timer.start();
    }


    public void actionPerformed (ActionEvent e) {
            checkCollision();
            maze.repaint();
        }

        public void checkCollision(){
            for(int i = 0; i < powerDots.size(); i++){
                PowerDot dot = powerDots.get(i);
                if(dot.getPositionX() == pacman.getPositionX() && dot.getPositionY() == pacman.getPositionY()){
                    powerDots.remove(i);
                    maze.removeDot(dot);
                    break;
                }
            }
        }
    public static void main(String[] args) {
        Game win = new Game();
        win.setSize(500, 500);
        win.setVisible(true);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.startTimer();

    }

    @Override
    public void keyReleased (KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch( keyCode ) {
            case KeyEvent.VK_UP: pacman.up(); break;
            case KeyEvent.VK_DOWN: pacman .down() ; break;
            case KeyEvent.VK_LEFT: pacman. left(); break;
            case KeyEvent.VK_RIGHT: pacman.right(); break;
        }
    }


    @Override
    public void keyTyped (KeyEvent e) { }

    @Override
    public void keyPressed (KeyEvent e) { }
}
