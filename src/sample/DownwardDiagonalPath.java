package sample;

import java.awt.*;

/**
 * Created by sean on 3/4/17.
 */
public class DownwardDiagonalPath extends Path {

    private Point current;

    public DownwardDiagonalPath(Point start) {
        current = start;
    }

    @Override
    public Point peekNextPosition() {
//        System.out.println("Curr X: " + current.x);
//        System.out.println("Curr Y: " + current.y);
        int nextX = (current.x + 1) % 3;
        int nextY = (current.y + 1) % 3;
//        System.out.println("Next X: " + nextX);
//        System.out.println("Next Y: " + nextY);
        boolean wrapsInX = nextX < current.x;
        boolean wrapsInY = nextY < current.y;
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
