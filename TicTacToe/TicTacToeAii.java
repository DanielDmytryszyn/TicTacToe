package TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class TicTacToeAii extends JFrame {

    ArrayList<JButton> buttons = new ArrayList<>();

    TicTacToeEnemy enemy;

    public static final String humanChar = "X";
    public static final String aiChar = "O";


    int winCountX = 0;
    int winCountY = 0;
    int unentschieden = 0;

    public static final int SYMBOL_FONT_SIZE = 200;
    public static final int NORMAL_FONT_SIZE = 30;


    TicTacToeAii() {
        super("Your Symbol is " + humanChar);
        setLayout(new GridLayout(3, 3));
        setBounds(70, 25, 1900, 1050);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setMinimumSize(new Dimension(getBounds().width, getBounds().height));
        setVisible(true);
        createButtons();
        addButtons();
        enemy = new TicTacToeEnemy(buttons, aiChar.charAt(0));
    }

    public static void main(String[] args) {

        new TicTacToeAii();

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

        if (Objects.equals(symbol, humanChar)) winCountX++;
        else winCountY++;

    }

    public void checkBoardState() {
        if (checkWin(humanChar)) {
            writeWinMessage(humanChar);
            return;
        }
        if (checkWin(aiChar)) {
            writeWinMessage(aiChar);
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

            button.setText(humanChar);
            checkBoardState();
            enemy.makeMove();


            setTitle("The active player is player: " + "X" + "     " +
                    winCountX + " Mal hat X gewonnen     " +
                    winCountY + " Mal hat O gewonnen     " +
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