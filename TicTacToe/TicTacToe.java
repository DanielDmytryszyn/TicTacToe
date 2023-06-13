package TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class TicTacToe extends JFrame {

    ArrayList<JButton> buttons = new ArrayList<>();
    boolean player = true;
    String activePlayer = "X";

    int winCountX = 0;
    int winCountY = 0;
    int unentschieden = 0;

    public static final int SYMBOL_FONT_SIZE = 200;
    public static final int NORMAL_FONT_SIZE = 30;


    TicTacToe() {
        super("The active player is player: X");
        setLayout(new GridLayout(3, 3));
        setBounds(70, 25, 1900, 1050);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setMinimumSize(new Dimension (getBounds().width, getBounds().height));
        setVisible(true);
        createButtons();
        addButtons();
    }

    public static void main(String[] args) {

        new TicTacToe();

    }


    public void addButtons() {
        buttons.forEach(this::add);
    }

    public void createButtons() {

        for (int y = 0; y < 9; y++) {

            JButton button = initializeButton();
            buttons.add(button);

        }

    }

    public void writeWinMessage(String symbol) {
        changeFontSizes(NORMAL_FONT_SIZE);
        writeToAllButtons(symbol + " hat gewonnen, click to Reset".toUpperCase());
        setTitle(symbol + " hat gewonnen".toUpperCase());

        if (Objects.equals(symbol, "X")) winCountX++;
        else winCountY++;

    }

    public void checkBoardState() {
        if (checkWin("X")) {
            writeWinMessage("X");
            return;
        }
        if (checkWin("O")) {
            writeWinMessage("O");
            return;
        }

        if (isFull()) {
            changeFontSizes(NORMAL_FONT_SIZE);
            writeToAllButtons("Unentschieden, click to Reset".toUpperCase());
            setTitle("Unentschieden".toUpperCase());
            unentschieden++;
        }
    }

    private JButton initializeButton() {
        JButton button = new JButton();
        button.setBounds(1, 1, 150, 150);
        button.setFont(new Font("Arial", Font.BOLD, SYMBOL_FONT_SIZE));

        button.addActionListener(actionEvent -> {
            if (isFull()) {
                clearButtons();
                changeFontSizes(SYMBOL_FONT_SIZE);
            } else {
                makeMove(button);
                checkBoardState();
            }
        });

        return button;
    }

    public void showIndexes() {
        for (int i = 0; i < buttons.size(); i++) {
            String indexString = String.valueOf(i);
            buttons.get(i).setText(indexString);
        }
    }

    public void writeToAllButtons(String text) {
        buttons.forEach(jButton -> jButton.setText(text));
    }

    public void changeFontSizes(int fontSize) {
        buttons.forEach(jButton -> jButton.setFont(new Font("Arial", Font.BOLD, fontSize)));
    }


    private void makeMove(JButton button) {
        if (button.getText().equals("")) {
            if (player) {
                button.setText("O");
                activePlayer = "X";
            } else {
                button.setText("X");
                activePlayer = "O";
            }

            player = !player;

            setTitle("The active player is player: " + activePlayer + "     " +
                    winCountX + " Mal hat X gewonnen     " +
                    winCountY + " Mal hat Y gewonnen     " +
                    "     " + unentschieden + " Mal ist ein Unentschieden gespielt worden");
        }
    }

    public void clearButtons() {
        buttons.forEach(jButton -> jButton.setText(""));
    }

    public boolean isFull() {

        long emptyButtonCount = buttons.stream().filter(jButton -> jButton.getText().equals("")).count();

        return emptyButtonCount == 0;
    }

    public boolean checkWin(String symbol) {

        for (int i = 0; i < 9; i += 3) {
            if (buttons.get(i).getText().equals(symbol) && buttons.get(i + 1).getText().equals(symbol) && buttons.get(i + 2).getText().equals(symbol)) {
                return true;
            }
        }


        for (int i = 0; i < 3; i++) {
            if (buttons.get(i).getText().equals(symbol) && buttons.get(i + 3).getText().equals(symbol) && buttons.get(i + 6).getText().equals(symbol)) {
                return true;
            }
        }


        if (buttons.get(0).getText().equals(symbol) && buttons.get(4).getText().equals(symbol) && buttons.get(8).getText().equals(symbol)) {
            return true;
        }
        return buttons.get(2).getText().equals(symbol) && buttons.get(4).getText().equals(symbol) && buttons.get(6).getText().equals(symbol);

    }


}