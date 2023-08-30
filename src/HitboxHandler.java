import java.awt.*;
import java.util.ArrayList;

public class HitboxHandler {

    ArrayList<Rectangle> hitboxes = new ArrayList<>();

    public int AddHitbox(Rectangle rectangle) {
        hitboxes.add(rectangle);
        return hitboxes.indexOf(rectangle);
    }

    public int EditHitbox(int hitboxID, Rectangle rectangle) {
        hitboxes.add(hitboxID, rectangle);
        return hitboxID;
    }

    public Rectangle GetHitboxFromID(int hitboxID) {
        return hitboxes.get(hitboxID);
    }

    public void RemoveHitbox(int hitboxID) {
        hitboxes.remove(hitboxID);
    }

    public int CheckCollisions(int hitboxID) {
        for (int i = 0; i < hitboxes.size(); i++) {
            if (i != hitboxID && hitboxes.get(hitboxID).intersects(hitboxes.get(i))) {
                return i;
            }
        }
        return hitboxID;
    }
}
