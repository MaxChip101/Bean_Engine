import java.awt.*;
import java.awt.image.BufferedImage;

public class BeanObj {

    // Graphics

        // scene variables
        public int scene;

        // layer variables
        public int zindex;

        //

        // shape variables
        public Rectangle bounds;
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
            scene = 0;
            zindex = 0;
            bounds = new Rectangle(0, 0, 0, 0);
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

        public int getZindex() { return zindex; }

}
