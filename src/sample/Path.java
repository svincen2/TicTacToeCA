package sample;

import java.awt.*;

/**
 * Created by sean on 3/4/17.
 */
public abstract class Path {

    public abstract Point nextPosition();

    public Point peekNextPosition() {
        return new Point(0, 0);
    }

    public boolean nextPositionIsInvalid() {
        boolean invalid = peekNextPosition().equals(invalidPosition());
//        System.out.println ("Invalid: " + invalid);
        return invalid;
//        return peekNextPosition().equals(invalidPosition());
    }

    protected Point invalidPosition() {
        return new Point(-1, -1);
    }
}
