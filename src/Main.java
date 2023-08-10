import javax.swing.*;
import java.awt.*;

public class Main {

    // Instancing the dependencies
    static JFrame frame = new JFrame();
    static Drawer draw = new Drawer();
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


    // Main function
    public static void main(String[] args){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(draw);
        frame.addKeyListener(key);
        frame.addMouseListener(mouse);
        frame.addMouseMotionListener(mouse);
        Image icon = Toolkit.getDefaultToolkit().getImage("res/img/icon.jpg");
        frame.setIconImage(icon);
        start();
        draw.Begin();
        frame.setSize(ScreenWidth, ScreenHeight);
        frame.setResizable(FrameResizable);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    public static void start(){
        frame.setTitle("Engine");
        ScreenWidth = 1000;
        ScreenHeight = 1000;
        FrameResizable = true;
        draw.ChangeDecal(0, "res/img/icon.jpg");
        draw.ChangeUIString(1, "This is UI");
        draw.CreateObj(0, 475, 475, 100, 100, 1, 255, 0, 0);
        draw.CreateObj(1, 400, 400, 100, 100, 5, 0, 255, 0);
        draw.CreateObj(2, 700, 300, 100, 100, 5, 0, 15, 255);
        draw.CreateUIObj(0, 700, 300, 100, 100, 6, 100, 15, 255);
        draw.CreateUIObj(1, 725, 325, 0, 0, 3, 0, 0, 0);
        draw.CreateUIObj(2, 50, 500, 25, 100, 6, 0, 0, 0);
        key.registerKey(65);
        key.registerKey(68);
        key.registerKey(87);
        key.registerKey(83);
        key.registerKey(37);
        key.registerKey(38);
        key.registerKey(39);
        key.registerKey(40);
        audio.registerSound(0, "res/audio/Mario64underwater.wav");
        audio.playSound(0);
    }

    public static void update() {

        if (key.keys.get(65)) {
            draw.objects[0][0] -= 10;
        }
        if (key.keys.get(68)) {
            draw.objects[0][0] += 10;
        }
        if (key.keys.get(87)) {
            draw.objects[0][1] -= 10;
        }
        if (key.keys.get(83)) {
            draw.objects[0][1] += 10;
        }

        if (key.keys.get(37)) {
            draw.camX -= 10;
        }
        if (key.keys.get(39)) {
            draw.camX += 10;
        }
        if (key.keys.get(38)) {
            draw.camY -= 10;
        }
        if (key.keys.get(40)) {
            draw.camY += 10;
        }
        draw.UIObjects[2][1] = mouseY - 75;

    }
}
