import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseHandler extends MouseAdapter implements MouseMotionListener {

    // Not used
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        switch(e.getButton()) {
            case MouseEvent.BUTTON1 -> {
                Main.mouse1Down = true;
                Main.mouse1Released = false;
            }
            case MouseEvent.BUTTON2 -> {
                Main.mouse2Down = true;
                Main.mouse2Released = false;
            }
            case MouseEvent.BUTTON3 -> {
                Main.mouse3Down = true;
                Main.mouse3Released = false;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        switch(e.getButton()) {
            case MouseEvent.BUTTON1 -> {
                Main.mouse1Released = true;
                Main.mouse1Down = false;
            }
            case MouseEvent.BUTTON2 -> {
                Main.mouse2Released = true;
                Main.mouse2Down = false;
            }
            case MouseEvent.BUTTON3 -> {
                Main.mouse3Released = true;
                Main.mouse3Down = false;
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Point pos = e.getPoint();
        Main.mouseX = pos.x;
        Main.mouseY = pos.y;
    }
}
