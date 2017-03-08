package sample;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.emptyList;

/**
 * Created by sean on 3/4/17.
 */
public class Neighborhood {

    private Path horizontalPath;
    private Path verticalPath;
    private Path downwardDiagonalPath;
    private Path upwardDiagonalPath;


    public Neighborhood(Cell homeCell) {
        Point origin = homeCell.getLocation();
        horizontalPath = new HorizontalPath(origin);
        verticalPath = new VerticalPath(origin);
        downwardDiagonalPath = new DownwardDiagonalPath(origin);
        upwardDiagonalPath = new UpwardDiagonalPath(origin);
    }


    public List<Point> getHorizontal() {
        return getWithoutCheck(horizontalPath);
    }

    public List<Point> getVertical() {
        return getWithoutCheck(verticalPath);
    }

    private List<Point> getWithoutCheck(Path p) {
        Point first = p.nextPosition();
        Point second = p.nextPosition();

        // Need to consume a position to back to origin.
        p.nextPosition();
        return Arrays.asList(first, second);
    }


    public List<Point> getDownwardDiagonal() {
        return getWithCheck(downwardDiagonalPath);
    }

    public List<Point> getUpwardDiagonal() {
        return getWithCheck(upwardDiagonalPath);
    }

    private List<Point> getWithCheck(Path p) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < 2; ++i) {
            if (p.nextPositionIsInvalid()) {
                return Collections.<Point>emptyList();
            }
            points.add(p.nextPosition());
        }

        // Consume next position to get to origin.
        p.nextPosition();
        return points;
    }


}
