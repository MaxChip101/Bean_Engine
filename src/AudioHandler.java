import java.io.*;
import javax.sound.sampled.*;
import java.util.ArrayList;

public class AudioHandler {

    ArrayList<AudioInputStream> stream = new ArrayList<>();
    AudioFormat format;
    DataLine.Info info;
    ArrayList<Clip> clip = new ArrayList<>();
    ArrayList<Long> clipPositions = new ArrayList<>();

    public void AddSound(int SoundId, String path) {
        try {
            stream.add(SoundId, AudioSystem.getAudioInputStream(new File(path)));
            format = stream.get(SoundId).getFormat();
            info = new DataLine.Info(Clip.class, format);
            clip.add(SoundId, (Clip) AudioSystem.getLine(info));
            clipPositions.set(SoundId, 0L);
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

    public void pauseSound(int SoundId) {
        try {
            clipPositions.set(SoundId, clip.get(SoundId).getMicrosecondPosition());
            clip.get(SoundId).stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void unpauseSound(int SoundId) {
        try {
            clip.get(SoundId).setMicrosecondPosition(clipPositions.get(SoundId));
            clip.get(SoundId).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void seekToTimestamp(int SoundId, long timestampMicroseconds) {
        try {
            clip.get(SoundId).setMicrosecondPosition(timestampMicroseconds);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setVolume(int SoundId, float volume) {
        try {
            FloatControl gainControl = (FloatControl) clip.get(SoundId).getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(20f * (float) Math.log10(volume));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setPan(int SoundId, float pan) {
        try {
            FloatControl panControl = (FloatControl) clip.get(SoundId).getControl(FloatControl.Type.PAN);
            panControl.setValue(pan);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
