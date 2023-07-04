import java.awt.*;

public class BlueGhost implements Drawable{
    private int positionX = 400;
    private int positionY = 400;
    private BlueSoundPlayer soundPlayer;

    public BlueGhost() {
        soundPlayer = new BlueSoundPlayer();
        soundPlayer.startSoundPlayback();
    }
    
    class BlueSoundPlayer {
        //Add your own absolute file path for the .wav file
        private static final String AUDIO_FILE_PATH = "/Users/eeshanmishra/IdeaProjects/Pac-Man/src/9.wav";

        public void startSoundPlayback() {
            Timer timer = new Timer();
            timer.schedule(new BlueSoundPlayer.PlaySoundTask(), 0, 45000); // Schedule the task to run every minute
        }

        class PlaySoundTask extends TimerTask {
            @Override
            public void run() {
                try {
                    File audioFile = new File(AUDIO_FILE_PATH);
                    AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioStream);
                    clip.start();
                } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void draw(Graphics g){
        g.setColor(Color.BLUE);
        if (Math.random() >0.5)
            if (Math.random() >0.5)
                positionX += 20;
            else
                positionX -= 20;

        else
        if (Math.random() >0.5)
            positionY += 20;
        else
            positionY -= 20;



        if(positionX > 400) positionX = 400;
        if(positionY > 400) positionY = 400;
        if(positionX < 0) positionX = 0;
        if(positionY < 0) positionY = 0;
        g.fillRect(positionX, positionY, 20, 20);
    }
}
