package sample;

import java.awt.*;

/**
 * Created by sean on 3/4/17.
 */
public class HorizontalPath extends Path {

    private Point current;

    public HorizontalPath(Point start) {
        current = new Point(start);
    }

    public Point nextPosition() {
        current.move((current.x + 1) % 3, current.y);
        return current.getLocation();
    }
}
