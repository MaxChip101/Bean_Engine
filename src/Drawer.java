import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Drawer extends JPanel implements ActionListener {

    public void Begin() {
        Timer timer = new Timer(1000 / Main.FRAME_RATE, this);
        timer.start();
    }

    int camX = 0;

    int camY = 0;

    public int[][][] objects = new int[256][4][3];

    public BufferedImage[] decals = new BufferedImage[256];

    public String[] strings = new String[256];

    public int[][][] UIObjects = new int[256][4][3];

    public BufferedImage[] UIDecals = new BufferedImage[256];

    public String[] UIStrings = new String[256];

    public void CreateObj(int objid, int X, int Y, int width_X2, int height_Y2, int shape, int red, int green, int blue) {
        objects[objid][0][0] = X;
        objects[objid][0][1] = Y;
        objects[objid][1][0] = width_X2;
        objects[objid][1][1] = height_Y2;
        objects[objid][2][0] = red;
        objects[objid][2][1] = green;
        objects[objid][2][2] = blue;
        objects[objid][3][0] = shape;
    }

    public void ChangeDecal(int objid, String imgDir) {
        BufferedImage image;
        try {
            image = ImageIO.read(new File(imgDir));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        decals[objid] = image;
    }

    public void ChangeStringObj(int objid, String string) {
        strings[objid] = string;
    }

    public void CreateUIObj(int UIObjID, int X, int Y, int width_X2, int height_Y2, int shape, int red, int green, int blue) {
        UIObjects[UIObjID][0][0] = X;
        UIObjects[UIObjID][0][1] = Y;
        UIObjects[UIObjID][1][0] = width_X2;
        UIObjects[UIObjID][1][1] = height_Y2;
        UIObjects[UIObjID][2][0] = red;
        UIObjects[UIObjID][2][1] = green;
        UIObjects[UIObjID][2][2] = blue;
        UIObjects[UIObjID][3][0] = shape;
    }

    public void ChangeUIDecal(int UIObjID, String imgDir) {
        BufferedImage image;
        try {
            image = ImageIO.read(new File(imgDir));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        UIDecals[UIObjID] = image;
    }

    public void ChangeUIString(int UIObjID, String string) {
        UIStrings[UIObjID] = string;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (int i = 0; i < objects.length; i++) {
            g2.setColor(new Color(objects[i][2][0], objects[i][2][1], objects[i][2][2]));
            switch (objects[i][3][0]) {
                case 0 ->
                        g2.drawOval(objects[i][0][0] - camX, objects[i][0][1] - camY, objects[i][1][0], objects[i][1][1]);
                case 1 ->
                        g2.drawImage(decals[i], objects[i][0][0] - camX, objects[i][0][1] - camY, objects[i][1][0], objects[i][1][1], null);
                case 2 ->
                        g2.drawLine(objects[i][0][0] - camX, objects[i][0][1] - camY, objects[i][1][0], objects[i][1][1]);
                case 3 ->
                        g2.drawString(strings[i], objects[i][0][0] - camX, objects[i][0][1] - camY);
                case 4 ->
                        g2.drawRect(objects[i][0][0] - camX, objects[i][0][1] - camY, objects[i][1][0], objects[i][1][1]);
                case 5 ->
                        g2.fillOval(objects[i][0][0] - camX, objects[i][0][1] - camY, objects[i][1][0], objects[i][1][1]);
                case 6 ->
                        g2.fillRect(objects[i][0][0] - camX, objects[i][0][1] - camY, objects[i][1][0], objects[i][1][1]);
            }
        }

        for (int i = 0; i < UIObjects.length; i++) {
            g2.setColor(new Color(UIObjects[i][2][0], UIObjects[i][2][1], UIObjects[i][2][2]));
            switch (UIObjects[i][3][0]) {
                case 0 ->
                        g2.drawOval(UIObjects[i][0][0], UIObjects[i][0][1], UIObjects[i][1][0], UIObjects[i][1][1]);
                case 1 ->
                        g2.drawImage(UIDecals[i], UIObjects[i][0][0], UIObjects[i][0][1], UIObjects[i][1][0], UIObjects[i][1][1], null);
                case 2 ->
                        g2.drawLine(UIObjects[i][0][0], UIObjects[i][0][1], UIObjects[i][1][0], UIObjects[i][1][1]);
                case 3 ->
                        g2.drawString(UIStrings[i], UIObjects[i][0][0], UIObjects[i][0][1]);
                case 4 ->
                        g2.drawRect(UIObjects[i][0][0], UIObjects[i][0][1], UIObjects[i][1][0], UIObjects[i][1][1]);
                case 5 ->
                        g2.fillOval(UIObjects[i][0][0], UIObjects[i][0][1], UIObjects[i][1][0], UIObjects[i][1][1]);
                case 6 ->
                        g2.fillRect(UIObjects[i][0][0], UIObjects[i][0][1], UIObjects[i][1][0], UIObjects[i][1][1]);
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        repaint();
        Main.update();
    }
}