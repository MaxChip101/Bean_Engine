import java.awt.*;
import java.awt.image.BufferedImage;

public class BeanObj {

    // Graphics
    // scene variables
    public int scene;

    // layer variables
    public int zindex;

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


    // Hitbox

    // Hitbox
    public Rectangle hitbox;

    public int getZindex() {
        return zindex;
    }

}
