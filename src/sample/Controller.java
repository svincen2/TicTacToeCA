package sample;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class Controller {

    public static void markAsX(ActionEvent av) {
        Cell source = (Cell) av.getSource();
        if (source.isBlank()) {
            source.markAsX();
            source.setTextFill(Color.RED);
            source.setText("X");
            Cell opponentMove = source.getAutomaton().makeAMove();
            if (opponentMove != null) {
                opponentMove.setTextFill(Color.BLUE);
                opponentMove.setText("O");
            }
        }
    }
}
