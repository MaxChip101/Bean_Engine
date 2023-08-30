import java.awt.*;
import java.awt.event.*;

public class MouseHandler extends MouseAdapter implements MouseMotionListener {

    Robot robot;

    {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

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
            int xcoor = point.x;
            int ycoor = point.y;
            robot.mouseMove(xcoor, ycoor); // Set the mouse cursor position
    }

    public void ClickMouse(int mouseButton) {
        switch (mouseButton) {
            case 0 :
                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                break;
            case 1 :
                robot.mousePress(InputEvent.BUTTON2_DOWN_MASK);
                robot.mouseRelease(InputEvent.BUTTON2_DOWN_MASK);
                break;
            case 2 :
                robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
                robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
                break;
        }

    }

    public void HoldMouse(int mouseButton) {
        switch (mouseButton) {
            case 0 :
                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                break;
            case 1 :
                robot.mousePress(InputEvent.BUTTON2_DOWN_MASK);
                break;
            case 2 :
                robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
                break;
        }
    }

    public void ReleaseMouse(int mouseButton) {
        switch (mouseButton) {
            case 0 :
                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                break;
            case 1 :
                robot.mouseRelease(InputEvent.BUTTON2_DOWN_MASK);
                break;
            case 2 :
                robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
                break;
        }
    }


}
