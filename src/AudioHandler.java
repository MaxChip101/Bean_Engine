import java.io.*;
import javax.sound.sampled.*;
import java.util.ArrayList;

public class AudioHandler {

    ArrayList<AudioInputStream> stream = new ArrayList<>();
    AudioFormat format;
    DataLine.Info info;
    ArrayList<Clip> clip = new ArrayList<>();

    public void AddSound(int SoundId, String path) {
        try {
            stream.add(SoundId, AudioSystem.getAudioInputStream(new File(path)));
            format = stream.get(SoundId).getFormat();
            info = new DataLine.Info(Clip.class, format);
            clip.add(SoundId, (Clip) AudioSystem.getLine(info));
        }
        catch (Exception e) {
                e.printStackTrace();
            }
    }

    public void RemoveSound(int SoundId) {
        stream.remove(SoundId);
        clip.remove(SoundId);
    }

    public void playSound(int SoundId) {
        try {
            clip.get(SoundId).open(stream.get(SoundId));
            clip.get(SoundId).start();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stopSound(int SoundId) {
        try {
            clip.get(SoundId).stop();
            clip.get(SoundId).close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
