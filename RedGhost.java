import java.awt.*;

public class RedGhost implements Drawable{
    private int positionX = 300;
    private int positionY = 400;
    private RedSoundPlayer soundPlayer;

    public RedGhost() {
        soundPlayer = new RedSoundPlayer();
        soundPlayer.startSoundPlayback();
    }

    class RedSoundPlayer {
        //Add your own absolute file path for the .wav file
        private static final String AUDIO_FILE_PATH = "/Users/eeshanmishra/IdeaProjects/Pac-Man/src/10.wav";

        public void startSoundPlayback() {
            Timer timer = new Timer();
            timer.schedule(new PlaySoundTask(), 0, 30000); // Schedule the task to run every minute
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
