import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BeanTools {

    public static Font loadCustomFont(String path, float size) {
        try {
            return Font.createFont(Font.TRUETYPE_FONT, new File(path)).deriveFont(size);
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static BufferedImage loadImage(String path) {
        File file = new File(path);
        try {
            BufferedImage image = ImageIO.read(file);
            return image;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
