import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AudioHandler {

    private Map<Integer, Clip> soundClips;

    public AudioHandler() {
        soundClips = new HashMap<>();
    }

    public int addSound(String path) {
        try {
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(path));
            AudioFormat audioFormat = inputStream.getFormat();
            DataLine.Info clipInfo = new DataLine.Info(Clip.class, audioFormat);
            Clip newClip = (Clip) AudioSystem.getLine(clipInfo);
            newClip.open(inputStream);

            int soundId = soundClips.size();
            soundClips.put(soundId, newClip);

            return soundId;
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to add sound: " + e.getMessage());
        }
    }

    public void removeSound(int soundId) {
        Clip clipToRemove = soundClips.get(soundId);
        if (clipToRemove != null) {
            clipToRemove.close();
            soundClips.remove(soundId);
        }
    }

    public void playSound(int soundId) {
        Clip clipToPlay = soundClips.get(soundId);
        if (clipToPlay != null && !clipToPlay.isActive()) {
            clipToPlay.setMicrosecondPosition(0);
            clipToPlay.start();
        }
    }

    public void stopSound(int soundId) {
        Clip clipToStop = soundClips.get(soundId);
        if (clipToStop != null && clipToStop.isActive()) {
            clipToStop.stop();
            clipToStop.setMicrosecondPosition(0);
        }
    }

    public void pauseSound(int soundId) {
        Clip clipToPause = soundClips.get(soundId);
        if (clipToPause != null && clipToPause.isActive()) {
            clipToPause.stop();
        }
    }

    public void unpauseSound(int soundId) {
        Clip clipToUnpause = soundClips.get(soundId);
        if (clipToUnpause != null && !clipToUnpause.isActive()) {
            clipToUnpause.start();
        }
    }

    public void seekToTimestamp(int SoundId, long timestampMicroseconds) {
        try {
            soundClips.get(SoundId).setMicrosecondPosition(timestampMicroseconds);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setVolume(int SoundId, float volume) {
        try {
            FloatControl gainControl = (FloatControl) soundClips.get(SoundId).getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(20f * (float) Math.log10(volume));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setPan(int SoundId, float pan) {
        try {
            FloatControl panControl = (FloatControl) soundClips.get(SoundId).getControl(FloatControl.Type.PAN);
            panControl.setValue(pan);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
