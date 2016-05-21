package sp3ctrum;

import java.io.BufferedInputStream;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Santiago Benoit
 */
public class Util {
    public static synchronized void playSound(String path, float gainAmount, float panAmount) throws LineUnavailableException, UnsupportedAudioFileException, IOException {
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(new BufferedInputStream(GUI.class.getResourceAsStream(path)));
        Clip clip = AudioSystem.getClip();
        clip.open(audioIn);
        clip.start();
        clip.addLineListener((LineEvent event) -> {
            LineEvent.Type type = event.getType();
            if (type == LineEvent.Type.STOP) {
                clip.close();
            }
        });
    }
}
