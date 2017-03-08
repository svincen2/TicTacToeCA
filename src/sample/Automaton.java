package sample;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by sean on 3/4/17.
 */
public class Automaton {

    private Cell[][] cells;

    public Automaton() {
        cells = new Cell[3][3];
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                cells[i][j] = new Cell(this, new Point(i, j));
            }
        }
    }

    private List<Cell> evaluate() {
        List<Cell> evaluated = new ArrayList<>();
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (cells[i][j].isBlank()) {
//                    System.out.println("\nCell: " + cells[i][j]);
                    calcCellValue(i, j);
                    evaluated.add(cells[i][j]);
                }
            }
        }
        return evaluated;
    }

    public Cell makeAMove() {
        List<Cell> choices = evaluate();
        if (choices.isEmpty()) {
//            System.out.println("Empty");
            return null;
        }
        Collections.sort(choices);
        Cell bestChoice = choices.get(0);
        bestChoice.markAsO();
        return bestChoice;
    }

    private void calcCellValue(int x, int y) {
        Cell cell = cells[x][y];
        cell.evaluate(cells);
    }

    public Cell getCell(int x, int y) {
        return cells[x][y];
    }
}
