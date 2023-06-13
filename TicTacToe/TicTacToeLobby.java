package TicTacToe;

import javax.swing.*;
import java.awt.*;

/**
 * <h1>Author: Daniel Dmytryszyn</h1>
 */
public class TicTacToeLobby extends JFrame {
    /**
     * Constructs a new TicTacToeLobby object.
     *
     * <p>This constructor initializes the lobby window by setting the layout,
     * bounds, and title. It also sets the minimum size, adds the human and
     * computer buttons to the layout, and initializes the button actions.</p>
     */
    TicTacToeLobby() {
        super("Choose a game mode");
        createUI();
        createPlayers();
    }

    private void createPlayers() {
        this.add(human);
        this.add(computer);
        initializeHuman();
        initializeComputer();
    }

    private void createUI() {
        setLayout(new GridLayout(1, 2));
        setBounds(70, 25, 1900, 1050);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(getBounds().width, getBounds().height));
        setVisible(true);
    }

    private final JButton human = new JButton();
    private final JButton computer = new JButton();

    /**
     * Initializes the "Human" button.
     *
     * <p>This method sets the font, text, and action for the "Human" button.
     * When the button is clicked, it creates a new TicTacToe object.</p>
     */
    private void initializeHuman() {
        human.setFont(new Font("Arial", Font.BOLD, 50));
        human.setText("Human");

        human.addActionListener(actionEvent -> new TicTacToe());
    }

    /**
     * Initializes the "Computer" button.
     *
     * <p>This method sets the font, text, and action for the "Computer" button.
     * When the button is clicked, it creates a new TicTacToeAii object.</p>
     */
    private void initializeComputer() {
        computer.setFont(new Font("Arial", Font.BOLD, 50));
        computer.setText("Computer");

        computer.addActionListener(actionEvent -> new TicTacToeAI());
    }

    /**
     * The main method of the TicTacToeLobby class.
     *
     * <p>It creates a new TicTacToeLobby object, which displays the lobby window.</p>
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        new TicTacToeLobby();
    }
}

