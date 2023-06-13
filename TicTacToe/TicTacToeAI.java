package TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;


/**
 * Author: Daniel Dmytryszyn
 */
public class TicTacToeAI extends JFrame {
    ArrayList<JButton> buttons = new ArrayList<>();  // List of buttons representing the game board
    TicTacToeEnemy enemy;  // AI opponent for the game

    public static final String humanChar = "X";  // Character representing the human player
    public static final String aiChar = "O";  // Character representing the AI player

    int winCountX = 0;  // Number of wins for the human player
    int winCountY = 0;  // Number of wins for the AI player
    int drawCount = 0;  // Number of draws (tie games)

    public static final int SYMBOL_FONT_SIZE = 200;  // Font size for the symbol (X or O) on the buttons
    public static final int NORMAL_FONT_SIZE = 30;  // Font size for normal text on the buttons

    /**
     * Constructs a new TicTacToeAii object.
     * Initializes the JFrame with the title and layout.
     * Sets the size and position of the JFrame.
     * Create the buttons for the game board.
     * Initializes the AI opponent.
     */
    TicTacToeAI() {
        super("Your Symbol is " + humanChar);
        createUI();
        createButtons();
        addButtons();
        enemy = new TicTacToeEnemy(buttons, aiChar.charAt(0));
    }

    private void createUI() {
        setLayout(new GridLayout(3, 3));
        setBounds(70, 25, 1900, 1050);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setMinimumSize(new Dimension(getBounds().width, getBounds().height));
        setVisible(true);
    }

    /**
     * The main method to start the Tic-Tac-Toe game.
     */
    public static void main(String[] args) {
        new TicTacToeAI();
    }

    /**
     * Adds the buttons to the JFrame.
     */
    public void addButtons() {
        buttons.forEach(this::add);
    }

    /**
     * Creates the buttons for the game board.
     */
    public void createButtons() {
        for (int y = 0; y < 9; y++) {
            JButton button = initializeButton();
            buttons.add(button);
        }
    }

    /**
     * Writes a win message to the buttons and updates the game statistics.
     *
     * @param symbol The symbol (X or O) of the winner.
     */
    public void writeWinMessage(String symbol) {
        changeFontSizes(NORMAL_FONT_SIZE);
        writeToAllButtons(symbol + " has won, click to Reset".toUpperCase());
        setTitle(symbol + " has won".toUpperCase());

        if (Objects.equals(symbol, humanChar))
            winCountX++;
        else
            winCountY++;
    }

    /**
     * Checks the state of the game board for a win or draw.
     * If a win or draw is detected, it displays the appropriate message and updates the game statistics.
     */
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
            writeToAllButtons("Draw, click to Reset".toUpperCase());
            setTitle("Draw".toUpperCase());
            drawCount++;
        }
    }

    /**
     * Initializes a button with the appropriate properties and event listener.
     *
     * @return The initialized button.
     */
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

    /**
     * Shows the indexes on the buttons (for debugging purposes).
     */
    public void showIndexes() {
        for (int i = 0; i < buttons.size(); i++) {
            String indexString = String.valueOf(i);
            buttons.get(i).setText(indexString);
        }
    }

    /**
     * Writes the given text to all buttons.
     *
     * @param text The text to write on the buttons.
     */
    public void writeToAllButtons(String text) {
        buttons.forEach(jButton -> jButton.setText(text));
    }

    /**
     * Changes the font sizes of all buttons to the given size.
     *
     * @param fontSize The new font size for the buttons.
     */
    public void changeFontSizes(int fontSize) {
        buttons.forEach(jButton -> jButton.setFont(new Font("Arial", Font.BOLD, fontSize)));
    }

    /**
     * Makes a move on the game board by the human player.
     * Checks if the button is empty, updates the board, and calls the AI opponent to make a move.
     * Updates the title of the JFrame with the game statistics.
     *
     * @param button The button representing the move made by the human player.
     */
    private void makeMove(JButton button) {
        if (button.getText().equals("")) {
            button.setText(humanChar);
            checkBoardState();
            enemy.makeMove();

            setTitle("The active player is player: " + "X" + "     " +
                    winCountX + " times has X won     " +
                    winCountY + " times has O won     " +
                    "     " + drawCount + " times the game has concluded in a draw");
        }
    }

    /**
     * Clears the text on all buttons.
     */
    public void clearButtons() {
        buttons.forEach(jButton -> jButton.setText(""));
    }

    /**
     * Checks if the game board is full (no empty buttons).
     *
     * @return true if the game board is full, false otherwise.
     */
    public boolean isFull() {
        long emptyButtonCount = buttons.stream().filter(jButton -> jButton.getText().equals("")).count();
        return emptyButtonCount == 0;
    }

    /**
     * Checks if the given symbol (X or O) has won the game.
     *
     * @param symbol The symbol to check for a win.
     * @return true if the symbol has won, false otherwise.
     */
    public boolean checkWin(String symbol) {
        for (int i = 0; i < 9; i += 3) {
            if (buttons.get(i).getText().equals(symbol) &&
                    buttons.get(i + 1).getText().equals(symbol) &&
                    buttons.get(i + 2).getText().equals(symbol)) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (buttons.get(i).getText().equals(symbol) &&
                    buttons.get(i + 3).getText().equals(symbol) &&
                    buttons.get(i + 6).getText().equals(symbol)) {
                return true;
            }
        }

        if (buttons.get(0).getText().equals(symbol) &&
                buttons.get(4).getText().equals(symbol) &&
                buttons.get(8).getText().equals(symbol)) {
            return true;
        }

        return buttons.get(2).getText().equals(symbol) &&
                buttons.get(4).getText().equals(symbol) &&
                buttons.get(6).getText().equals(symbol);
    }

}