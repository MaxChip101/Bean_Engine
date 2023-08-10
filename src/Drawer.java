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

    public int[][] objects = new int[4096][8];

    public BufferedImage[] decals = new BufferedImage[4096];

    public String[] strings = new String[4096];

    public int[][] UIObjects = new int[4096][8];

    public BufferedImage[] UIDecals = new BufferedImage[4096];

    public String[] UIStrings = new String[4096];

    public void CreateObj(int objid, int X, int Y, int width_X2, int height_Y2, int shape, int red, int green, int blue) {
        objects[objid][0] = X;
        objects[objid][1] = Y;
        objects[objid][2] = width_X2;
        objects[objid][3] = height_Y2;
        objects[objid][4] = red;
        objects[objid][5] = green;
        objects[objid][6] = blue;
        objects[objid][7] = shape;
    }

    public void DeleteObj(int objid) {
        objects[objid][0] = 0;
        objects[objid][1] = 0;
        objects[objid][2] = 0;
        objects[objid][3] = 0;
        objects[objid][4] = 0;
        objects[objid][5] = 0;
        objects[objid][6] = 0;
        objects[objid][7] = 0;
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
        UIObjects[UIObjID][0] = X;
        UIObjects[UIObjID][1] = Y;
        UIObjects[UIObjID][2] = width_X2;
        UIObjects[UIObjID][3] = height_Y2;
        UIObjects[UIObjID][4] = red;
        UIObjects[UIObjID][5] = green;
        UIObjects[UIObjID][6] = blue;
        UIObjects[UIObjID][7] = shape;
    }

    public void DeleteUIObj(int UIObjID) {
        UIObjects[UIObjID][0] = 0;
        UIObjects[UIObjID][1] = 0;
        UIObjects[UIObjID][2] = 0;
        UIObjects[UIObjID][3] = 0;
        UIObjects[UIObjID][4] = 0;
        UIObjects[UIObjID][5] = 0;
        UIObjects[UIObjID][6] = 0;
        UIObjects[UIObjID][7] = 0;
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
            g2.setColor(new Color(objects[i][4], objects[i][5], objects[i][6]));
            switch (objects[i][7]) {
                case 0 ->
                        g2.drawOval(objects[i][0] - camX, objects[i][1] - camY, objects[i][2], objects[i][3]);
                case 1 ->
                        g2.drawImage(decals[i], objects[i][0] - camX, objects[i][1] - camY, objects[i][2], objects[i][3], null);
                case 2 ->
                        g2.drawLine(objects[i][0] - camX, objects[i][1] - camY, objects[i][2], objects[i][3]);
                case 3 ->
                        g2.drawString(strings[i], objects[i][0] - camX, objects[i][1] - camY);
                case 4 ->
                        g2.drawRect(objects[i][0] - camX, objects[i][1] - camY, objects[i][2], objects[i][3]);
                case 5 ->
                        g2.fillOval(objects[i][0] - camX, objects[i][1] - camY, objects[i][2], objects[i][3]);
                case 6 ->
                        g2.fillRect(objects[i][0] - camX, objects[i][1] - camY, objects[i][2], objects[i][3]);
            }
        }

        for (int i = 0; i < UIObjects.length; i++) {
            g2.setColor(new Color(UIObjects[i][4], UIObjects[i][5], UIObjects[i][6]));
            switch (UIObjects[i][7]) {
                case 0 ->
                        g2.drawOval(UIObjects[i][0], UIObjects[i][1], UIObjects[i][2], UIObjects[i][3]);
                case 1 ->
                        g2.drawImage(UIDecals[i], UIObjects[i][0], UIObjects[i][1], UIObjects[i][2], UIObjects[i][3], null);
                case 2 ->
                        g2.drawLine(UIObjects[i][0], UIObjects[i][1], UIObjects[i][2], UIObjects[i][3]);
                case 3 ->
                        g2.drawString(UIStrings[i], UIObjects[i][0], UIObjects[i][1]);
                case 4 ->
                        g2.drawRect(UIObjects[i][0], UIObjects[i][1], UIObjects[i][2], UIObjects[i][3]);
                case 5 ->
                        g2.fillOval(UIObjects[i][0], UIObjects[i][1], UIObjects[i][2], UIObjects[i][3]);
                case 6 ->
                        g2.fillRect(UIObjects[i][0], UIObjects[i][1], UIObjects[i][2], UIObjects[i][3]);
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        repaint();
        Main.update();
    }
}
