import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Comparator;

public class GraphicsHandler extends JPanel implements ActionListener {

    public static ArrayList<BeanObj> objects;

    public int currentScene;

    public void Begin() {
        Timer timer = new Timer(100 / Main.FRAME_RATE, this);
        timer.start();
    }

    GraphicsHandler() {
        objects = new ArrayList<>();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        AffineTransform originalTransform = g2.getTransform();
        objects.sort(Comparator.comparingInt(BeanObj::getZindex).reversed());
        // draws object graphics
        for (int i = 0; i < objects.size(); i++) {
            if (currentScene == objects.get(i).scene) {
                // sets the color of the object to the color to draw
                g2.setColor(objects.get(i).color);
                // sets the thickness of the line
                Stroke LineStroke = new BasicStroke(objects.get(i).lineThickness);
                g2.setStroke(LineStroke);

                // sets rotation
                AffineTransform tx = new AffineTransform();
                tx.concatenate(g2.getTransform());
                double objRotation = Math.toRadians(objects.get(i).rotation);
                double rotationX = objects.get(i).bounds.x + objects.get(i).bounds.width / 2.0; // Calculate the center X
                double rotationY = objects.get(i).bounds.y + objects.get(i).bounds.height / 2.0; // Calculate the center Y
                tx.rotate(objRotation, rotationX, rotationY);
                tx.translate(-objects.get(i).rotationOffset.x, -objects.get(i).rotationOffset.y);
                g2.setTransform(tx);

                switch (objects.get(i).shape) {
                    case "oval" -> g2.drawOval(objects.get(i).bounds.x, objects.get(i).bounds.y, objects.get(i).bounds.width, objects.get(i).bounds.height);
                    case "img" -> g2.drawImage(objects.get(i).image, objects.get(i).bounds.x, objects.get(i).bounds.y, objects.get(i).bounds.width, objects.get(i).bounds.height, null);
                    case "ln" -> g2.drawLine(objects.get(i).bounds.x, objects.get(i).bounds.y, objects.get(i).bounds.width, objects.get(i).bounds.height);
                    case "str" -> {
                        if (objects.get(i).font != null) {
                            g2.setFont(objects.get(i).font);
                        }
                        g2.drawString(objects.get(i).string, objects.get(i).bounds.x, objects.get(i).bounds.y);
                    }
                    case "rect" -> g2.drawRect(objects.get(i).bounds.x, objects.get(i).bounds.y, objects.get(i).bounds.width, objects.get(i).bounds.height);
                    case "fillOval" -> g2.fillOval(objects.get(i).bounds.x, objects.get(i).bounds.y, objects.get(i).bounds.width, objects.get(i).bounds.height);
                    case "fillRect" -> g2.fillRect(objects.get(i).bounds.x, objects.get(i).bounds.y, objects.get(i).bounds.width, objects.get(i).bounds.height);
                }
                g2.setTransform(originalTransform);
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        repaint();
        Main.update();
    }
}
