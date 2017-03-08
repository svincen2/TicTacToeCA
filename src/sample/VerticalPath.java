package sample;

import java.awt.*;

/**
 * Created by sean on 3/4/17.
 */
public class VerticalPath extends Path {

    private Point current;

    public VerticalPath(Point start) {
        current = start;
    }

    public Point nextPosition() {
        current.move(current.x, (current.y + 1) % 3);
        return current.getLocation();
    }
}
