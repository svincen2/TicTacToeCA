package sample;

import javafx.scene.control.Button;

import java.awt.Point;
import java.util.List;

/**
 * Created by sean on 3/4/17.
 */
public class Cell extends Button implements Comparable<Cell> {

    public enum State {
        BLANK, X, O
    }

    private Automaton parent;
    private Point location;
    private Neighborhood neighborhood;
    private State state;
    private int value;

    public Cell(Automaton ca, Point location) {
        parent = ca;
        this.location = location;
        neighborhood = new Neighborhood(this);
        state = State.BLANK;
        value = 0;
        getStyleClass().add("cell");
        setPrefHeight(64.0);
        setPrefWidth(64.0);
        setOnAction(Controller::markAsX);
    }

    public Point getLocation() {
        return location.getLocation();
    }

    public State getState() {
        return state;
    }

    public int getValue() {
        return value;
    }

    public boolean isBlank() {
        return state == State.BLANK;
    }

    public void markAsO() {
        state = State.O;
    }

    public void markAsX() {
        state = State.X;
    }

    public void evaluate(Cell[][] cells) {
        int newValue = 0;
//        System.out.println("\nHor");
        newValue += calcValue(neighborhood.getHorizontal(), cells);
//        System.out.println("\nVert");
        newValue += calcValue(neighborhood.getVertical(), cells);
//        System.out.println("\nDownward");
        newValue += (2 * calcValue(neighborhood.getDownwardDiagonal(), cells));
//        System.out.println("\nUpward");
        newValue += (2 * calcValue(neighborhood.getUpwardDiagonal(), cells));
//        System.out.println("\nVal: " + value);
        this.value = newValue;
//        setText("" + value);
    }

    private int calcValue(List<Point> locations, Cell[][] cells) {

//        for (Point p : locations) {
//            System.out.println(" -- Loc: " + p);
//        }
        int value = 0;

        if (locations.isEmpty()) {
            return value;
        }
        Cell first = cells[locations.get(0).x][locations.get(0).y];
        Cell second = cells[locations.get(1).x][locations.get(1).y];
        if (first.getState() == State.O && second.getState() == State.O) {
            value = 100;
        }
        else if (first.getState() == State.X && second.getState() == State.X) {
            value = 99;
        }
        else if (first.getState() == State.O || second.getState() == State.O) {
            value = 2;
        }
        else if (first.getState() == State.X || second.getState() == State.X) {
            value = 2;
        }
//        System.out.println("Value: " + value);
        return value;
    }

    public Automaton getAutomaton() {
        return parent;
    }

    @Override
    public int compareTo(Cell other) {
        return other.getValue() - getValue();
    }

    @Override
    public String toString() {
        return "Cell @ (" + getLocation().x + ", " + getLocation().y + ") -- State: " + getState();
    }
}
