import java.io.*;

import javax.sound.sampled.*;

public class AudioHandler {

    AudioInputStream[] stream = new AudioInputStream[256];
    AudioFormat format;
    DataLine.Info info;
    Clip[] clip = new Clip[256];

    public void registerSound(int SoundId, String path) {
        try {
            stream[SoundId] = AudioSystem.getAudioInputStream(new File(path));
            format = stream[SoundId].getFormat();
            info = new DataLine.Info(Clip.class, format);
            clip[SoundId] = (Clip) AudioSystem.getLine(info);
        }
        catch (Exception e) {
                e.printStackTrace();
            }
    }

    public void playSound(int SoundId) {
        try {
            clip[SoundId].open(stream[SoundId]);
            clip[SoundId].start();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stopSound(int SoundId) {
        try {
            clip[SoundId].stop();
            clip[SoundId].close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
