package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    private Automaton ca = new Automaton();

    @Override
    public void start(Stage primaryStage) throws Exception{
        GridPane root = new GridPane();
        root.setHgap(10.0);
        root.setVgap(10.0);
        root.setAlignment(Pos.CENTER);
        root.getStyleClass().add("root");
        root.add(createBoard(), 0, 0);
        primaryStage.setTitle("Tic Tac Toe CA");
        Scene scene = new Scene(root, 300, 275);
        scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
        primaryStage.setScene(scene);

        // Make a first move.
//        Cell firstMove = ca.makeAMove();
//        firstMove.setTextFill(Color.BLUE);
//        firstMove.setText("O");

        primaryStage.show();
    }

    private GridPane createBoard() {
        GridPane board = new GridPane();
        board.setHgap(10.0);
        board.setVgap(10.0);
        board.setAlignment(Pos.CENTER);
        board.getStyleClass().add("board");
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                board.add(ca.getCell(i, j), i, j);
            }
        }
        return board;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
