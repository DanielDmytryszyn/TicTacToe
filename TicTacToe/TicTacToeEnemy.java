package TicTacToe;

import javax.swing.*;
import java.util.List;

public class TicTacToeEnemy {
    private final List<JButton> buttons;
    private final char enemySymbol;

    public TicTacToeEnemy(List<JButton> buttons, char enemySymbol) {
        this.buttons = buttons;
        this.enemySymbol = enemySymbol;
    }

    public void makeMove() {
        int moveIndex = findBestMove();
        buttons.get(moveIndex).setText(Character.toString(enemySymbol));
    }

    private int findBestMove() {
        int bestMove = -1;
        int bestScore = Integer.MIN_VALUE;

        for (int i = 0; i < buttons.size(); i++) {
            if (buttons.get(i).getText().isEmpty()) {
                buttons.get(i).setText(Character.toString(enemySymbol));
                int score = minimax(false);
                buttons.get(i).setText("");
                if (score > bestScore) {
                    bestScore = score;
                    bestMove = i;
                }
            }
        }

        if (bestMove == -1) {
            throw new IllegalStateException("No valid move found.");
        }

        return bestMove;
    }

    private int minimax(boolean isMaximizingPlayer) {
        if (checkWin(enemySymbol)) {
            return 1;
        } else if (checkWin('X')) {
            return -1;
        } else if (isBoardFull()) {
            return 0;
        }

        int bestScore;
        if (isMaximizingPlayer) {
            bestScore = Integer.MIN_VALUE;

            for (JButton button : buttons) {
                if (button.getText().isEmpty()) {
                    button.setText(Character.toString(enemySymbol));
                    int score = minimax(false);
                    button.setText("");
                    bestScore = Math.max(score, bestScore);
                }
            }

        } else {
            bestScore = Integer.MAX_VALUE;

            for (JButton button : buttons) {
                if (button.getText().isEmpty()) {
                    button.setText("X");
                    int score = minimax(true);
                    button.setText("");
                    bestScore = Math.min(score, bestScore);
                }
            }

        }
        return bestScore;
    }

    private boolean checkWin(char symbol) {
        // Check rows for a win
        if (buttons.get(0).getText().equals(Character.toString(symbol)) && buttons.get(1).getText().equals(Character.toString(symbol)) && buttons.get(2).getText().equals(Character.toString(symbol)))
            return true;
        if (buttons.get(3).getText().equals(Character.toString(symbol)) && buttons.get(4).getText().equals(Character.toString(symbol)) && buttons.get(5).getText().equals(Character.toString(symbol)))
            return true;
        if (buttons.get(6).getText().equals(Character.toString(symbol)) && buttons.get(7).getText().equals(Character.toString(symbol)) && buttons.get(8).getText().equals(Character.toString(symbol)))
            return true;

        // Check columns for a win
        if (buttons.get(0).getText().equals(Character.toString(symbol)) && buttons.get(3).getText().equals(Character.toString(symbol)) && buttons.get(6).getText().equals(Character.toString(symbol)))
            return true;
        if (buttons.get(1).getText().equals(Character.toString(symbol)) && buttons.get(4).getText().equals(Character.toString(symbol)) && buttons.get(7).getText().equals(Character.toString(symbol)))
            return true;
        if (buttons.get(2).getText().equals(Character.toString(symbol)) && buttons.get(5).getText().equals(Character.toString(symbol)) && buttons.get(8).getText().equals(Character.toString(symbol)))
            return true;

        // Check diagonals for a win
        if (buttons.get(0).getText().equals(Character.toString(symbol)) && buttons.get(4).getText().equals(Character.toString(symbol)) && buttons.get(8).getText().equals(Character.toString(symbol)))
            return true;
        if (buttons.get(2).getText().equals(Character.toString(symbol)) && buttons.get(4).getText().equals(Character.toString(symbol)) && buttons.get(6).getText().equals(Character.toString(symbol)))
            return true;

        return false;
    }

    private boolean isBoardFull() {
        for (JButton button : buttons) {
            if (button.getText().isEmpty()) {
                return false;
            }
        }
        return true;
    }
}