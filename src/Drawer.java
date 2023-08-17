import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.ArrayList;

public class Drawer extends JPanel implements ActionListener {

    public void Begin() {
        Timer timer = new Timer(1000 / Main.FRAME_RATE, this);
        timer.start();
    }

    int camX = 0;
    int camY = 0;

    public ArrayList<int[]> objects = new ArrayList<>();

    public ArrayList<BufferedImage> decals = new ArrayList<>();

    public ArrayList<String> strings = new ArrayList<>();

    public ArrayList<int[]> UIObjects = new ArrayList<>();

    public ArrayList<BufferedImage> UIDecals = new ArrayList<>();

    public ArrayList<String> UIStrings = new ArrayList<>();

    public void CreateObj(int objid, int X, int Y, int width_X2, int height_Y2, int shape, int line_thickness, int red, int green, int blue) {

        int[] tempArray = new int[9];
        tempArray[0] = X;
        tempArray[1] = Y;
        tempArray[2] = width_X2;
        tempArray[3] = height_Y2;
        tempArray[4] = red;
        tempArray[5] = green;
        tempArray[6] = blue;
        tempArray[7] = shape;
        tempArray[8] = line_thickness;

        objects.add(objid, tempArray);
    }

    public void DeleteObj(int objid) {
        objects.remove(objid);
    }

    public void AddDecal(int objid, String imgDir) {
        BufferedImage image;
        try {
            image = ImageIO.read(new File(imgDir));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        decals.add(objid, image);
    }

    public void DeleteDecal(int objid) {
        decals.remove(objid);
    }

    public void AddString(int objid, String string) {
        strings.add(objid, string);
    }

    public void DeleteString(int objid) {
        strings.remove(objid);
    }

    public void CreateUIObj(int UIObjId, int X, int Y, int width_X2, int height_Y2, int shape, int line_thickness, int red, int green, int blue) {
        int[] tempArray = new int[9];
        tempArray[0] = X;
        tempArray[1] = Y;
        tempArray[2] = width_X2;
        tempArray[3] = height_Y2;
        tempArray[4] = red;
        tempArray[5] = green;
        tempArray[6] = blue;
        tempArray[7] = shape;
        tempArray[8] = line_thickness;

        UIObjects.add(UIObjId, tempArray);

    }

    public void DeleteUIObj(int UIObjID) {
        UIObjects.remove(UIObjID);
    }

    public void AddUIDecal(int UIObjID, String imgDir) {
        BufferedImage image;
        try {
            image = ImageIO.read(new File(imgDir));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        UIDecals.add(UIObjID, image);
    }

    public void DeleteUIDecal(int UIObjId) {
        UIDecals.remove(UIObjId);
    }

    public void AddUIString(int UIObjID, String string) {
        UIStrings.add(UIObjID, string);
    }

    public void DeleteUIString(int UIObjId) {
        UIStrings.remove(UIObjId);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (int i = 0; i < objects.size(); i++) {
            // sets the color of the object to the color to draw
            g2.setColor(new Color(objects.get(i)[4], objects.get(i)[5], objects.get(i)[6]));
            // sets the thickness of the line
            Stroke LineStroke = new BasicStroke(objects.get(i)[8]);
            g2.setStroke(LineStroke);
            switch (objects.get(i)[7]) {
                case 0 ->
                        g2.drawOval(objects.get(i)[0] - camX, objects.get(i)[1] - camY, objects.get(i)[2], objects.get(i)[3]);
                case 1 ->
                        g2.drawImage(decals.get(i), objects.get(i)[0] - camX, objects.get(i)[1] - camY, objects.get(i)[2], objects.get(i)[3], null);
                case 2 ->
                        g2.drawLine(objects.get(i)[0] - camX, objects.get(i)[1] - camY, objects.get(i)[2], objects.get(i)[3]);
                case 3 ->
                        g2.drawString(strings.get(i), objects.get(i)[0] - camX, objects.get(i)[1] - camY);
                case 4 ->
                        g2.drawRect(objects.get(i)[0] - camX, objects.get(i)[1] - camY, objects.get(i)[2], objects.get(i)[3]);
                case 5 ->
                        g2.fillOval(objects.get(i)[0] - camX, objects.get(i)[1] - camY, objects.get(i)[2], objects.get(i)[3]);
                case 6 ->
                        g2.fillRect(objects.get(i)[0] - camX, objects.get(i)[1] - camY, objects.get(i)[2], objects.get(i)[3]);
            }
        }

        for (int i = 0; i < UIObjects.size(); i++) {
            // sets the color of the object to the color to draw
            g2.setColor(new Color(UIObjects.get(i)[4], UIObjects.get(i)[5], UIObjects.get(i)[6]));
            // sets the thickness of the line
            Stroke LineStroke = new BasicStroke(UIObjects.get(i)[8]);
            g2.setStroke(LineStroke);
            switch (UIObjects.get(i)[7]) {
                case 0 ->
                        g2.drawOval(UIObjects.get(i)[0], UIObjects.get(i)[1], UIObjects.get(i)[2], UIObjects.get(i)[3]);
                case 1 ->
                        g2.drawImage(UIDecals.get(i), UIObjects.get(i)[0], UIObjects.get(i)[1], UIObjects.get(i)[2], UIObjects.get(i)[3], null);
                case 2 ->
                        g2.drawLine(UIObjects.get(i)[0], UIObjects.get(i)[1], UIObjects.get(i)[2], UIObjects.get(i)[3]);
                case 3 ->
                        g2.drawString(UIStrings.get(i), UIObjects.get(i)[0], UIObjects.get(i)[1]);
                case 4 ->
                        g2.drawRect(UIObjects.get(i)[0], UIObjects.get(i)[1], UIObjects.get(i)[2], UIObjects.get(i)[3]);
                case 5 ->
                        g2.fillOval(UIObjects.get(i)[0], UIObjects.get(i)[1], UIObjects.get(i)[2], UIObjects.get(i)[3]);
                case 6 ->
                        g2.fillRect(UIObjects.get(i)[0], UIObjects.get(i)[1], UIObjects.get(i)[2], UIObjects.get(i)[3]);
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        repaint();
        Main.update();
    }
}
