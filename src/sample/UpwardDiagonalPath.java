package sample;

import java.awt.*;

/**
 * Created by sean on 3/4/17.
 */
public class UpwardDiagonalPath extends Path {

    private Point current;

    public UpwardDiagonalPath(Point start) {
        current = start;
    }

    public Point peekNextPosition() {
        int nextX = (current.x + 1) % 3;
        int nextY = current.y - 1;
        boolean wrapsInX = false;
        boolean wrapsInY = false;
        if (nextX  < current.x) {
            wrapsInX = true;
        }
        if (nextY < 0) {
            nextY = 3 + nextY;
            wrapsInY = true;
        }
        boolean singleWrap = wrapsInX != wrapsInY;
        if (singleWrap) {
            return invalidPosition();
        } else {
            return new Point(nextX, nextY);
        }
    }

    public Point nextPosition() {
        current = peekNextPosition();
        return current.getLocation();
    }
}
