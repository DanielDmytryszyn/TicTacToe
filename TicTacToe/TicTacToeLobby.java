package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class TicTacToeLobby extends JFrame {
    TicTacToeLobby() {
        super("Bitte wählen Sie einen Spielmodus");
        setLayout(new GridLayout(1, 2));
        setBounds(70, 25, 1900, 1050);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setMinimumSize(new Dimension(getBounds().width, getBounds().height));
        setVisible(true);
        this.add(human);
        this.add(computer);
        initializeHuman();
        initializeComputer();
    }

    JButton human = new JButton();
    JButton computer = new JButton();


    private JButton initializeHuman() {


        human.setFont(new Font("Arial", Font.BOLD, 50));
        human.setText("Human");

        human.addActionListener(actionEvent -> {

            new TicTacToe();

        });

        return human;
    }

    private JButton initializeComputer() {


        computer.setFont(new Font("Arial", Font.BOLD, 50));
        computer.setText("Computer");

        computer.addActionListener(actionEvent -> {

            new TicTacToeAii();

        });

        return computer;
    }

    public static void main(String[] args) {
        new TicTacToeLobby();
    }
}
