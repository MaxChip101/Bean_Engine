import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class BeanObj {

    // Graphics

        // scene variables
        public int scene;

        // layer variables
        public int zindex;

        // visibility variables
        public boolean visible;

        // shape variables
        public ArrayList<Point> points;
        public Polygon polygon = new Polygon();
        public String shape;

        // rotation variables
        public int rotation;
        public Point rotationOffset;

        // resource variables
        public String string;
        public Font font;
        public BufferedImage image;

        // color and line variables
        public Color color;
        public int lineThickness;

        BeanObj() {
            visible = true;
            scene = 0;
            zindex = 0;
            shape = "rect";
            rotation = 0;
            rotationOffset = new Point(0, 0);
            color = new Color(0, 0, 0, 0);
            lineThickness = 0;
            image = BeanTools.loadImage("res/img/null.png");
        }

    // Hitbox

        // Hitbox
        public Rectangle hitbox;

        // Callable Functions

        public int getZindex() { return zindex; }

        public void updatePoints() {
            polygon.npoints = points.size();
            for (int i = 0; i < points.size(); i++) {
                polygon.xpoints[i] = points.get(i).x;
                polygon.ypoints[i] = points.get(i).y;
            }
        }

}
