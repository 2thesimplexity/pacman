import java.awt.*;

public class GreenGhost implements Drawable{
    private int positionX = 400;
    private int positionY = 80;
    private GreenSoundPlayer soundPlayer;

    public GreenGhost() {
        soundPlayer = new GreenSoundPlayer();
        soundPlayer.startSoundPlayback();
    }
    class GreenSoundPlayer {
        private static final String AUDIO_FILE_PATH = "/Users/eeshanmishra/IdeaProjects/Pac-Man/src/24.wav";

        public void startSoundPlayback() {
            Timer timer = new Timer();
            timer.schedule(new GreenSoundPlayer.PlaySoundTask(), 0, 60000); // Schedule the task to run every minute
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
