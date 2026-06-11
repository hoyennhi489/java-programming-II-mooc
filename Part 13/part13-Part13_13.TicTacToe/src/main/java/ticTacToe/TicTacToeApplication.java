package ticTacToe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TicTacToeApplication extends Application {

    private String turn;
    private boolean gameEnded;

    @Override
    public void start(Stage window) {

        this.turn = "X";
        this.gameEnded = false;

        BorderPane layout = new BorderPane();

        Label turnLabel = new Label("Turn: X");
        layout.setTop(turnLabel);

        GridPane grid = new GridPane();

        Button[][] buttons = new Button[3][3];

        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {

                Button button = new Button(" ");
                button.setFont(Font.font("Monospaced", 40));
                button.setMinSize(80, 80);

                final int r = row;
                final int c = column;

                button.setOnAction(event -> {

                    if (this.gameEnded) {
                        return;
                    }

                    if (!buttons[r][c].getText().equals(" ")) {
                        return;
                    }

                    buttons[r][c].setText(this.turn);

                    if (hasWinner(buttons)) {
                        turnLabel.setText("The end!");
                        this.gameEnded = true;
                        return;
                    }

                    if (this.turn.equals("X")) {
                        this.turn = "O";
                    } else {
                        this.turn = "X";
                    }

                    turnLabel.setText("Turn: " + this.turn);
                });

                buttons[row][column] = button;
                grid.add(button, column, row);
            }
        }

        layout.setCenter(grid);

        Scene scene = new Scene(layout);

        window.setScene(scene);
        window.show();
    }

    private boolean hasWinner(Button[][] buttons) {

        for (int row = 0; row < 3; row++) {
            if (!buttons[row][0].getText().equals(" ")
                    && buttons[row][0].getText().equals(buttons[row][1].getText())
                    && buttons[row][1].getText().equals(buttons[row][2].getText())) {
                return true;
            }
        }

        for (int column = 0; column < 3; column++) {
            if (!buttons[0][column].getText().equals(" ")
                    && buttons[0][column].getText().equals(buttons[1][column].getText())
                    && buttons[1][column].getText().equals(buttons[2][column].getText())) {
                return true;
            }
        }

        if (!buttons[0][0].getText().equals(" ")
                && buttons[0][0].getText().equals(buttons[1][1].getText())
                && buttons[1][1].getText().equals(buttons[2][2].getText())) {
            return true;
        }

        if (!buttons[0][2].getText().equals(" ")
                && buttons[0][2].getText().equals(buttons[1][1].getText())
                && buttons[1][1].getText().equals(buttons[2][0].getText())) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }
}