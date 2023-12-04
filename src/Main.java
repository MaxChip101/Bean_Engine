import javax.swing.*;
import java.awt.*;

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
        frame.setResizable(FrameResizable);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    static BeanObj obj1 = new BeanObj();
    static void start() {
        frame.setSize(480, 360);
        frame.setTitle("Bean Engine");
        FrameResizable = true;
        graphics.setBackground(new Color(0, 0, 0));
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(false);
        graphics.currentScene = 0;

        // initializing object 1
        obj1.bounds = new Rectangle(50, 50, 50, 50);
        obj1.color = new Color(35, 255, 238, 255);
        obj1.rotation = 0;
        obj1.rotationOffset = new Point(0, 0);
        obj1.lineThickness = 10;
        obj1.shape  = "fillRect";
        obj1.scene = 0;
        graphics.objects.add(obj1);
    }

    static void update() {
        // moving object 1 right by 1 pixel evey frame
        obj1.bounds.x += 1;
    }

}
