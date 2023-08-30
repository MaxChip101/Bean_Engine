import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Main {

    // Instancing the dependencies
    static JFrame frame = new JFrame();
    static GraphicsHandler graphics = new GraphicsHandler();
    static KeyHandler key = new KeyHandler();
    static AudioHandler audio = new AudioHandler();
    static MouseHandler mouse = new MouseHandler();

    // Key variables
    public static int keypressed = -1;
    public static int keyreleased = -1;
    public static String keytyped = "none";

    // Screen variables
    public static int ScreenWidth;
    public static int ScreenHeight;
    public static Boolean FrameResizable;

    // Frame rate
    public static final int FRAME_RATE = 120;

    // Mouse Variables
    public static boolean mouse1Down;
    public static boolean mouse1Released;

    public static boolean mouse2Down;
    public static boolean mouse2Released;

    public static boolean mouse3Down;
    public static boolean mouse3Released;

    public static int mouseX;
    public static int mouseY;

    public static int scrollWheelRotation;


    // Main function
    public static void main(String[] args){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(graphics);
        frame.addKeyListener(key);
        frame.addMouseListener(mouse);
        frame.addMouseMotionListener(mouse);
        Image icon = Toolkit.getDefaultToolkit().getImage("res/img/icon.jpg");
        frame.setIconImage(icon);
        start();
        graphics.Begin();
        frame.setSize(ScreenWidth, ScreenHeight);
        frame.setResizable(FrameResizable);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    static int obj1;
    static Rectangle rectangle1 = new Rectangle(500, 500, 50, 50);

    // BUILT-IN: calls on build
    public static void start(){
        frame.setTitle("Engine");
        ScreenWidth = 1600;
        ScreenHeight = 1000;
        FrameResizable = false;
        obj1 = graphics.CreateObj(rectangle1, "fillrect", 0, 25, 25, 0, new Color(0, 0, 0, 255));
        int obj2 = graphics.CreateObj(new Rectangle(600, 500, 50, 50), "fillrect", 0, 25, 25, 0, new Color(255, 0, 0, 255));
        key.registerKey(KeyEvent.VK_UP);
        key.registerKey(KeyEvent.VK_DOWN);
        key.registerKey(KeyEvent.VK_LEFT);
        key.registerKey(KeyEvent.VK_RIGHT);
    }

    static int rotation = 0;

    // BUILT-IN: updates every frame
    public static void update() {
        rotation += 1;
        graphics.EditObj(obj1, rectangle1, "fillrect", rotation, 25, 25, 0, new Color(0, 0, 0, 255));

        Cursor cursor = Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR);
        frame.setCursor(cursor);

        if (key.keys.get(KeyEvent.VK_UP)) {
            graphics.camY -= 5;
        }
        if (key.keys.get(KeyEvent.VK_DOWN)) {
            graphics.camY += 5;
        }
        if (key.keys.get(KeyEvent.VK_LEFT)) {
            graphics.camX -= 5;
        }
        if (key.keys.get(KeyEvent.VK_RIGHT)) {
            graphics.camX += 5;
        }

    }

}
