import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.ArrayList;

public class GraphicsHandler extends JPanel implements ActionListener {

    public void Begin() {
        Timer timer = new Timer(1000 / Main.FRAME_RATE, this);
        timer.start();
    }

    int camX = 0;
    int camY = 0;

    public ArrayList<int[]> objects = new ArrayList<>();

    public ArrayList<BufferedImage> decals = new ArrayList<>();

    public ArrayList<String> strings = new ArrayList<>();

    public ArrayList<Font> fonts = new ArrayList<>();

    public ArrayList<int[]> UIObjects = new ArrayList<>();

    public int CreateObj(Rectangle rect, String shape, int resourceID, int rotaion, int rotationOffsetX, int rotationOffsetY, int line_thickness, Color rgba) {

        int[] tempArray = new int[14];
        tempArray[0] = rect.x;
        tempArray[1] = rect.y;
        tempArray[2] = rect.width;
        tempArray[3] = rect.height;
        tempArray[4] = rgba.getRed();
        tempArray[5] = rgba.getGreen();
        tempArray[6] = rgba.getBlue();
        tempArray[7] = rgba.getAlpha();
        tempArray[8] = line_thickness;
        tempArray[9] = rotaion;
        tempArray[10] = rotationOffsetX;
        tempArray[11] = rotationOffsetY;

        tempArray[13] = resourceID;

        switch (shape) {
            case "circle" -> tempArray[12] = 0;
            case "image" -> tempArray[12] = 1;
            case "line" -> tempArray[12] = 2;
            case "string" -> tempArray[12] = 3;
            case "rectangle" -> tempArray[12] = 4;
            case "fillcirc" -> tempArray[12] = 5;
            case "fillrect" -> tempArray[12] = 6;
        }

        objects.add(tempArray);
        return objects.indexOf(tempArray);
    }

    public void EditObj(int objid, Rectangle rect, String shape, int resourceID, int rotaion, int rotationOffsetX, int rotationOffsetY, int line_thickness, Color rgba) {

        int[] tempArray = new int[14];
        tempArray[0] = rect.x;
        tempArray[1] = rect.y;
        tempArray[2] = rect.width;
        tempArray[3] = rect.height;
        tempArray[4] = rgba.getRed();
        tempArray[5] = rgba.getGreen();
        tempArray[6] = rgba.getBlue();
        tempArray[7] = rgba.getAlpha();
        tempArray[8] = line_thickness;
        tempArray[9] = rotaion;
        tempArray[10] = rotationOffsetX;
        tempArray[11] = rotationOffsetY;

        tempArray[13] = resourceID;

        switch (shape) {
            case "circle" -> tempArray[12] = 0;
            case "image" -> tempArray[12] = 1;
            case "line" -> tempArray[12] = 2;
            case "string" -> tempArray[12] = 3;
            case "rectangle" -> tempArray[12] = 4;
            case "fillcirc" -> tempArray[12] = 5;
            case "fillrect" -> tempArray[12] = 6;
        }

        objects.set(objid, tempArray);
    }

    public int[] GetObjById(int objid) {
        return objects.get(objid);
    }

    public void DeleteObj(int objid) {
        objects.remove(objid);
    }

    public int AddDecal(String imgDir) {
        BufferedImage image;
        try {
            image = ImageIO.read(new File(imgDir));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        decals.add(image);
        return decals.indexOf(image);
    }

    public void EditDecal(int recourseID, String imgDir) {
        BufferedImage image;
        try {
            image = ImageIO.read(new File(imgDir));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        decals.set(recourseID, image);
    }

    public void DeleteDecal(int recourseID) {
        decals.remove(recourseID);
    }

    public int AddString(String string, String font, int style, int size) {
        strings.add(string);
        Font newfont = new Font(font, style, size);
        fonts.add(newfont);
        return strings.indexOf(string);
    }

    public void EditString(int recourseID, String string, String font, int style, int size) {
        strings.set(recourseID, string);
        Font newfont = new Font(font, style, size);
        fonts.add(newfont);
    }

    public void DeleteString(int recourseID) {
        strings.remove(recourseID);
        fonts.remove(recourseID);
    }


    public int CreateUIObj(Rectangle rect, String shape, int resourceID, int rotaion, int rotationOffsetX, int rotationOffsetY, int line_thickness, Color rgba) {

        int[] tempArray = new int[14];
        tempArray[0] = rect.x;
        tempArray[1] = rect.y;
        tempArray[2] = rect.width;
        tempArray[3] = rect.height;
        tempArray[4] = rgba.getRed();
        tempArray[5] = rgba.getGreen();
        tempArray[6] = rgba.getBlue();
        tempArray[7] = rgba.getAlpha();
        tempArray[8] = line_thickness;
        tempArray[9] = rotaion;
        tempArray[10] = rotationOffsetX;
        tempArray[11] = rotationOffsetY;

        tempArray[13] = resourceID;

        switch (shape) {
            case "circle" -> tempArray[12] = 0;
            case "image" -> tempArray[12] = 1;
            case "line" -> tempArray[12] = 2;
            case "string" -> tempArray[12] = 3;
            case "rectangle" -> tempArray[12] = 4;
            case "fillcirc" -> tempArray[12] = 5;
            case "fillrect" -> tempArray[12] = 6;
        }

        UIObjects.add(tempArray);
        return UIObjects.indexOf(tempArray);

    }

    public void EditUIObj(int UIObjID, Rectangle rect, String shape, int resourceID, int rotaion, int rotationOffsetX, int rotationOffsetY, int line_thickness, Color rgba) {

        int[] tempArray = new int[14];
        tempArray[0] = rect.x;
        tempArray[1] = rect.y;
        tempArray[2] = rect.width;
        tempArray[3] = rect.height;
        tempArray[4] = rgba.getRed();
        tempArray[5] = rgba.getGreen();
        tempArray[6] = rgba.getBlue();
        tempArray[7] = rgba.getAlpha();
        tempArray[8] = line_thickness;
        tempArray[9] = rotaion;
        tempArray[10] = rotationOffsetX;
        tempArray[11] = rotationOffsetY;

        tempArray[13] = resourceID;

        switch (shape) {
            case "circle" -> tempArray[12] = 0;
            case "image" -> tempArray[12] = 1;
            case "line" -> tempArray[12] = 2;
            case "string" -> tempArray[12] = 3;
            case "rectangle" -> tempArray[12] = 4;
            case "fillcirc" -> tempArray[12] = 5;
            case "fillrect" -> tempArray[12] = 6;
        }

        objects.set(UIObjID, tempArray);
    }

    public int[] GetUIObjById(int UIObjId) {
        return UIObjects.get(UIObjId);
    }

    public void DeleteUIObj(int UIObjID) {
        UIObjects.remove(UIObjID);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        AffineTransform originalTransform = g2.getTransform();

        // draws object graphics
        for (int i = 0; i < objects.size(); i++) {
            // sets the color of the object to the color to draw
            g2.setColor(new Color(objects.get(i)[4], objects.get(i)[5], objects.get(i)[6], objects.get(i)[7]));
            // sets the thickness of the line
            Stroke LineStroke = new BasicStroke(objects.get(i)[8]);
            g2.setStroke(LineStroke);

            // sets rotation
            AffineTransform tx = new AffineTransform();
            tx.concatenate(g2.getTransform());
            double objrotation = Math.toRadians(objects.get(i)[9]);
            tx.rotate(objrotation, objects.get(i)[0] - camX, objects.get(i)[1] - camY);
            tx.translate(-objects.get(i)[10] , -objects.get(i)[11]);
            g2.setTransform(tx);

            switch (objects.get(i)[12]) {
                case 0 ->
                        g2.drawOval(objects.get(i)[0] - camX, objects.get(i)[1] - camY, objects.get(i)[2], objects.get(i)[3]);
                case 1 ->
                        g2.drawImage(decals.get(objects.get(i)[13]), objects.get(i)[0] - camX, objects.get(i)[1] - camY, objects.get(i)[2], objects.get(i)[3], null);
                case 2 ->
                        g2.drawLine(objects.get(i)[0] - camX, objects.get(i)[1] - camY, objects.get(i)[2] - camX, objects.get(i)[3] - camY);
                case 3 -> {
                    g2.setFont(fonts.get(i));
                    g2.drawString(strings.get(objects.get(i)[13]), objects.get(i)[0] - camX, objects.get(i)[1] - camY);
                }
                case 4 ->
                        g2.drawRect(objects.get(i)[0] - camX, objects.get(i)[1] - camY, objects.get(i)[2], objects.get(i)[3]);
                case 5 ->
                        g2.fillOval(objects.get(i)[0] - camX, objects.get(i)[1] - camY, objects.get(i)[2], objects.get(i)[3]);
                case 6 ->
                        g2.fillRect(objects.get(i)[0] - camX, objects.get(i)[1] - camY, objects.get(i)[2], objects.get(i)[3]);
            }
            g2.setTransform(originalTransform);

        }

        // draws UI components
        for (int i = 0; i < UIObjects.size(); i++) {
            // sets the color of the object to the color to draw
            g2.setColor(new Color(UIObjects.get(i)[4], UIObjects.get(i)[5], UIObjects.get(i)[6], UIObjects.get(i)[7]));
            // sets the thickness of the line
            Stroke LineStroke = new BasicStroke(UIObjects.get(i)[8]);
            g2.setStroke(LineStroke);

            // sets rotation
            AffineTransform transform = new AffineTransform();
            double objrotation = Math.toRadians(UIObjects.get(i)[9]);
            transform.rotate(objrotation, UIObjects.get(i)[0], UIObjects.get(i)[1]);
            transform.translate(-UIObjects.get(i)[10], -UIObjects.get(i)[11]);
            g2.setTransform(transform);

            switch (UIObjects.get(i)[12]) {
                case 0 ->
                        g2.drawOval(UIObjects.get(i)[0], UIObjects.get(i)[1], UIObjects.get(i)[2], UIObjects.get(i)[3]);
                case 1 ->
                        g2.drawImage(decals.get(UIObjects.get(i)[13]), UIObjects.get(i)[0], UIObjects.get(i)[1], UIObjects.get(i)[2], UIObjects.get(i)[3], null);
                case 2 ->
                        g2.drawLine(UIObjects.get(i)[0], UIObjects.get(i)[1], UIObjects.get(i)[2], UIObjects.get(i)[3]);
                case 3 -> {
                    g2.setFont(fonts.get(UIObjects.get(i)[13]));
                    g2.drawString(strings.get(UIObjects.get(i)[13]), UIObjects.get(i)[0], UIObjects.get(i)[1]);
                }
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
