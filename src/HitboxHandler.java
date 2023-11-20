import java.awt.*;
import java.util.ArrayList;

public class HitboxHandler {

    public ArrayList<BeanObj> objects;

    HitboxHandler() {
        objects = new ArrayList<>();
    }

    public BeanObj CheckCollisions(BeanObj object) {
        for (int i = 0; i < objects.size(); i++) {
            if (objects.get(i) != object && object.hitbox.intersects(objects.get(i).hitbox)) {
                return objects.get(i);
            }
        }
        return object;
    }
}
