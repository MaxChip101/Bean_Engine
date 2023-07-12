import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

public class KeyHandler implements KeyListener {

    public static Map<Integer, Boolean> keys;

    public KeyHandler() {
        keys = new HashMap<>();
    }

    public void registerKey(int keycode) {
        keys.put(keycode, false);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Main.keypressed = e.getKeyCode();
        Main.keyreleased = -1;
        int keyCode = e.getKeyCode();
        keys.put(keyCode, true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        Main.keyreleased = e.getKeyCode();
        Main.keypressed = -1;
        int keyCode = e.getKeyCode();
        keys.put(keyCode, false);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        Main.keytyped = String.valueOf(e.getKeyChar());
    }
}
