import java.awt.*;
import java.awt.event.*;

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

    @Override
    public void mouseDragged(MouseEvent e) {
        Point pos = e.getPoint();
        Main.mouseX = pos.x;
        Main.mouseY = pos.y;
    }

    public void mouseWheelMoved(MouseWheelEvent e) {
        Main.scrollWheelRotation = e.getWheelRotation();
    }

    // Callable Functions

    public void MoveCursor(Point point) {
        try {
            Robot robot = new Robot();
            int xcoor = point.x;
            int ycoor = point.y;
            robot.mouseMove(xcoor, ycoor); // Set the mouse cursor position
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

}
