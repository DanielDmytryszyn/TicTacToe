package TicTacToe;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TTT extends JFrame {

    GridLayout myGridLayout = new GridLayout();
    JButton myButton1 = new JButton();
    JButton myButton2 = new JButton();
    JButton myButton3 = new JButton();
    JButton myButton4 = new JButton();
    JButton myButton5 = new JButton();
    JButton myButton6 = new JButton();
    JButton myButton7 = new JButton();
    JButton myButton8 = new JButton();
    JButton myButton9 = new JButton();
    String aktZeichen = "X";
    int varX = 0;
    int varO = 0;

    public TTT() {
        super();

        setTitle("0 : 0");
        setSize(600, 400);
        setLayout(new GridLayout(3, 3));
        add(myButton1);
        myButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (myButton1.getText().equals("")) {

                    if (aktZeichen == "X") {
                        myButton1.setText("X");
                        aktZeichen = "O";
                    } else {
                        myButton1.setText("O");
                        aktZeichen = "X";
                    }
                    gewinn();
                    Computerzug();
                }
            }

        });
        add(myButton2);
        myButton2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {

                if (myButton2.getText() == "") {

                    if (aktZeichen == "X") {
                        myButton2.setText("X");
                        aktZeichen = "O";
                    } else {
                        myButton2.setText("O");
                        aktZeichen = "X";
                    }
                    gewinn();
                    Computerzug();
                }
            }

        });
        add(myButton3);
        myButton3.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {

                if (myButton3.getText() == "") {

                    if (aktZeichen == "X") {
                        System.out.println(aktZeichen);
                        myButton3.setText("X");
                        aktZeichen = "O";
                    } else {
                        myButton3.setText("O");
                        aktZeichen = "X";
                    }
                    gewinn();
                    Computerzug();
                }
            }

        });
        add(myButton4);
        myButton4.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {

                if (myButton4.getText() == "") {

                    if (aktZeichen == "X") {
                        myButton4.setText("X");
                        aktZeichen = "O";
                    } else {
                        myButton4.setText("O");
                        aktZeichen = "X";
                    }
                    gewinn();
                    Computerzug();
                }
            }

        });
        add(myButton5);
        myButton5.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {

                if (myButton5.getText() == "") {

                    if (aktZeichen == "X") {
                        myButton5.setText("X");
                        aktZeichen = "O";
                    } else {
                        myButton5.setText("O");
                        aktZeichen = "X";
                    }
                    gewinn();
                    Computerzug();
                }
            }

        });
        add(myButton6);
        myButton6.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {

                if (myButton6.getText() == "") {

                    if (aktZeichen == "X") {
                        myButton6.setText("X");
                        aktZeichen = "O";
                    } else {
                        myButton6.setText("O");
                        aktZeichen = "X";
                    }
                    gewinn();
                    Computerzug();
                }
            }

        });
        add(myButton7);
        myButton7.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {

                if (myButton7.getText() == "") {

                    if (aktZeichen == "X") {
                        myButton7.setText("X");
                        aktZeichen = "O";
                    } else {
                        myButton7.setText("O");
                        aktZeichen = "X";
                    }
                    gewinn();
                    Computerzug();
                }
            }

        });
        add(myButton8);
        myButton8.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {

                if (myButton8.getText() == "") {

                    if (aktZeichen == "X") {
                        myButton8.setText("X");
                        aktZeichen = "O";
                    } else {
                        myButton8.setText("O");
                        aktZeichen = "X";
                    }
                    gewinn();
                    Computerzug();
                }
            }

        });
        add(myButton9);
        myButton9.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {

                if (myButton9.getText() == "") {

                    if (aktZeichen == "X") {
                        myButton9.setText("X");
                        aktZeichen = "O";
                    } else {
                        myButton9.setText("O");
                        aktZeichen = "X";
                    }
                    gewinn();
                    Computerzug();
                }
            }

        });

        myButton1.setFont(new Font("Arial", Font.BOLD, 60));
        myButton2.setFont(new Font("Arial", Font.BOLD, 60));
        myButton3.setFont(new Font("Arial", Font.BOLD, 60));
        myButton4.setFont(new Font("Arial", Font.BOLD, 60));
        myButton5.setFont(new Font("Arial", Font.BOLD, 60));
        myButton6.setFont(new Font("Arial", Font.BOLD, 60));
        myButton7.setFont(new Font("Arial", Font.BOLD, 60));
        myButton8.setFont(new Font("Arial", Font.BOLD, 60));
        myButton9.setFont(new Font("Arial", Font.BOLD, 60));
        setBounds(50, 50, 1980, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    void Computerzug() {
        boolean erfolg = false;

        if (myButton1.getText() == "O" && myButton2.getText() == "O" && myButton3.getText() == "") {
            myButton3.setText("O");
            aktZeichen = "X";
            erfolg = true;
        }

        else if (myButton1.getText() == "X" && myButton2.getText() == "X" && myButton3.getText() == "") {
            myButton3.setText("O");
            aktZeichen = "X";
            erfolg = true;
        }

        else if (myButton4.getText() == "O" && myButton5.getText() == "O" && myButton6.getText() == "") {
            myButton6.setText("O");
            aktZeichen = "X";
            erfolg = true;
        }

        else if (myButton4.getText() == "X" && myButton5.getText() == "X" && myButton6.getText() == "") {
            myButton6.setText("O");
            aktZeichen = "X";
            erfolg = true;
        }

        else if (myButton7.getText() == "O" && myButton8.getText() == "O" && myButton9.getText() == "") {
            myButton9.setText("O");
            aktZeichen = "X";
            erfolg = true;
        }

        else if (myButton7.getText() == "X" && myButton8.getText() == "X" && myButton9.getText() == "") {
            myButton9.setText("O");
            aktZeichen = "X";
            erfolg = true;
        }

        //fddddddddffd
        else if (myButton1.getText() == "X" && myButton4.getText() == "X" && myButton7.getText() == "") {
            myButton7.setText("O");
            aktZeichen = "X";
            erfolg = true;
        }

        else if (myButton1.getText() == "O" && myButton4.getText() == "O" && myButton7.getText() == "") {
            myButton7.setText("O");
            aktZeichen = "X";
            erfolg = true;
        }

        else if (myButton2.getText() == "X" && myButton5.getText() == "X" && myButton8.getText() == "") {
            myButton8.setText("O");
            aktZeichen = "X";
            erfolg = true;
        }

        else if (myButton2.getText() == "O" && myButton5.getText() == "O" && myButton8.getText() == "") {
            myButton8.setText("O");
            aktZeichen = "X";
            erfolg = true;
        }

        else if (myButton3.getText() == "X" && myButton6.getText() == "X" && myButton9.getText() == "") {
            myButton9.setText("O");
            aktZeichen = "X";
            erfolg = true;
        }

        else if (myButton3.getText() == "O" && myButton6.getText() == "O" && myButton9.getText() == "") {
            myButton9.setText("O");
            aktZeichen = "X";
            erfolg = true;
        }

        else if (myButton1.getText() == "O" && myButton5.getText() == "O" && myButton9.getText() == "") {
            myButton9.setText("O");
            aktZeichen = "X";
            erfolg = true;
        }

        else if (myButton1.getText() == "X" && myButton5.getText() == "X" && myButton9.getText() == "") {
            myButton9.setText("O");
            aktZeichen = "X";
            erfolg = true;
        }

        else if (myButton3.getText() == "X" && myButton5.getText() == "X" && myButton7.getText() == "") {
            myButton7.setText("O");
            aktZeichen = "X";
            erfolg = true;
        }

        else if (myButton3.getText() == "O" && myButton5.getText() == "O" && myButton7.getText() == "") {
            myButton7.setText("O");
            aktZeichen = "X";
            erfolg = true;
        }

        else if (myButton1.getText() == "X" && myButton2.getText() == "" && myButton3.getText() == "X") {
            myButton2.setText("O");
            aktZeichen = "X";
            erfolg = true;
        }

        else if (myButton1.getText() == "O" && myButton2.getText() == "" && myButton3.getText() == "O") {
            myButton2.setText("O");
            aktZeichen = "X";
            erfolg = true;
        }

        else if (myButton4.getText() == "X" && myButton5.getText() == "" && myButton6.getText() == "X") {
            myButton5.setText("O");
            aktZeichen = "X";
            erfolg = true;
        }

        else if (myButton4.getText() == "O" && myButton5.getText() == "" && myButton6.getText() == "O") {
            myButton5.setText("O");
            aktZeichen = "X";
            erfolg = true;
        }

        else if (myButton7.getText() == "X" && myButton8.getText() == "" && myButton9.getText() == "X") {
            myButton8.setText("O");
            aktZeichen = "X";
            erfolg = true;
        }

        else if (myButton7.getText() == "O" && myButton8.getText() == "" && myButton9.getText() == "O") {
            myButton8.setText("O");
            aktZeichen = "X";
            erfolg = true;
        }

        else if (myButton1.getText() == "X" && myButton4.getText() == "" && myButton7.getText() == "X") {
            myButton4.setText("O");
            aktZeichen = "X";
            erfolg = true;
        }

        else if (myButton1.getText() == "O" && myButton4.getText() == "" && myButton7.getText() == "O") {
            myButton4.setText("O");
            aktZeichen = "X";
            erfolg = true;
        }

        else if (myButton2.getText() == "X" && myButton5.getText() == "" && myButton8.getText() == "X") {
            myButton5.setText("O");
            aktZeichen = "X";
            erfolg = true;
        }

        else if (myButton2.getText() == "O" && myButton5.getText() == "" && myButton8.getText() == "O") {
            myButton5.setText("O");
            aktZeichen = "X";
            erfolg = true;
        }

        else if (myButton3.getText() == "X" && myButton6.getText() == "" && myButton9.getText() == "X") {
            myButton6.setText("O");
            aktZeichen = "X";
            erfolg = true;
        }

        else if (myButton3.getText() == "O" && myButton6.getText() == "" && myButton9.getText() == "O") {
            myButton6.setText("O");
            aktZeichen = "X";
            erfolg = true;
        }

        else if (myButton1.getText() == "O" && myButton5.getText() == "" && myButton9.getText() == "O") {
            myButton5.setText("O");
            aktZeichen = "X";
            erfolg = true;
        }

        else if (myButton1.getText() == "X" && myButton5.getText() == "" && myButton9.getText() == "X") {
            myButton5.setText("O");
            aktZeichen = "X";
            erfolg = true;
        }

        else if (myButton3.getText() == "X" && myButton5.getText() == "" && myButton7.getText() == "X") {
            myButton5.setText("O");
            aktZeichen = "X";
            erfolg = true;
        }

        else if (myButton3.getText() == "O" && myButton5.getText() == "" && myButton7.getText() == "O") {
            myButton5.setText("O");
            aktZeichen = "X";
            erfolg = true;
        }

        else if (myButton1.getText() == "" && myButton2.getText() == "X" && myButton3.getText() == "X") {
            myButton2.setText("O");
            aktZeichen = "X";
            erfolg = true;
        }

        else if (myButton1.getText() == "" && myButton2.getText() == "O" && myButton3.getText() == "O") {
            myButton1.setText("O");
            aktZeichen = "X";
            erfolg = true;
        }

        else if (myButton4.getText() == "" && myButton5.getText() == "X" && myButton6.getText() == "X") {
            myButton4.setText("O");
            aktZeichen = "X";
            erfolg = true;
        }

        else if (myButton4.getText() == "" && myButton5.getText() == "O" && myButton6.getText() == "O") {
            myButton4.setText("O");
            aktZeichen = "X";
            erfolg = true;
        }

        else if (myButton7.getText() == "" && myButton8.getText() == "X" && myButton9.getText() == "X") {
            myButton7.setText("O");
            aktZeichen = "X";
            erfolg = true;
        }

        else if (myButton7.getText() == "" && myButton8.getText() == "O" && myButton9.getText() == "O") {
            myButton7.setText("O");
            aktZeichen = "X";
            erfolg = true;
        }

        else if (myButton1.getText() == "" && myButton4.getText() == "X" && myButton7.getText() == "X") {
            myButton1.setText("O");
            aktZeichen = "X";
            erfolg = true;
        }

        else if (myButton1.getText() == "" && myButton4.getText() == "O" && myButton7.getText() == "O") {
            myButton1.setText("O");
            aktZeichen = "X";
            erfolg = true;
        }

        else if (myButton2.getText() == "" && myButton5.getText() == "X" && myButton8.getText() == "X") {
            myButton2.setText("O");
            aktZeichen = "X";
            erfolg = true;
        }

        else if (myButton2.getText() == "" && myButton5.getText() == "O" && myButton8.getText() == "O") {
            myButton2.setText("O");
            aktZeichen = "X";
            erfolg = true;
        }

        else if (myButton3.getText() == "" && myButton6.getText() == "X" && myButton9.getText() == "X") {
            myButton3.setText("O");
            aktZeichen = "X";
            erfolg = true;
        }

        else if (myButton3.getText() == "" && myButton6.getText() == "O" && myButton9.getText() == "O") {
            myButton3.setText("O");
            aktZeichen = "X";
            erfolg = true;
        }

        else if (myButton1.getText() == "" && myButton5.getText() == "O" && myButton9.getText() == "O") {
            myButton1.setText("O");
            aktZeichen = "X";
            erfolg = true;
        }

        else if (myButton1.getText() == "" && myButton5.getText() == "X" && myButton9.getText() == "X") {
            myButton1.setText("O");
            aktZeichen = "X";
            erfolg = true;
        }

        else if (myButton3.getText() == "" && myButton5.getText() == "X" && myButton7.getText() == "X") {
            myButton3.setText("O");
            aktZeichen = "X";
            erfolg = true;
        }

        else if (myButton3.getText() == "" && myButton5.getText() == "O" && myButton7.getText() == "O") {
            myButton7.setText("O");
            aktZeichen = "X";
            erfolg = true;
        }

        Random zufall = new Random();


        while (erfolg == false) {
            int zahl = zufall.nextInt(9) + 1;
            if (zahl == 1) {
                if (myButton1.getText() == "") {
                    myButton1.setText("O");
                    erfolg = true;
                    aktZeichen = "X";
                }
            } else if (zahl == 2) {
                if (myButton2.getText() == "") {
                    myButton2.setText("O");
                    erfolg = true;
                    aktZeichen = "X";
                }
            } else if (zahl == 3) {
                if (myButton3.getText() == "") {
                    myButton3.setText("O");
                    erfolg = true;
                    aktZeichen = "X";
                }
            } else if (zahl == 4) {
                if (myButton4.getText() == "") {
                    myButton4.setText("O");
                    erfolg = true;
                    aktZeichen = "X";
                }
            } else if (zahl == 5) {
                if (myButton5.getText() == "") {
                    myButton5.setText("O");
                    erfolg = true;
                    aktZeichen = "X";
                }
            } else if (zahl == 6) {
                if (myButton6.getText() == "") {
                    myButton6.setText("O");
                    erfolg = true;
                    aktZeichen = "X";
                }
            } else if (zahl == 7) {
                if (myButton7.getText() == "") {
                    myButton7.setText("O");
                    erfolg = true;
                    aktZeichen = "X";
                }
            } else if (zahl == 8) {
                if (myButton8.getText() == "") {
                    myButton8.setText("O");
                    erfolg = true;
                    aktZeichen = "X";
                }
            } else if (zahl == 9) {
                if (myButton9.getText() == "") {
                    myButton9.setText("O");
                    erfolg = true;
                    aktZeichen = "X";
                }
            }
        }

    }

    void reset() {
        myButton1.setText("");
        myButton2.setText("");
        myButton3.setText("");
        myButton4.setText("");
        myButton5.setText("");
        myButton6.setText("");
        myButton7.setText("");
        myButton8.setText("");
        myButton9.setText("");
        aktZeichen = "X";
    }

    void gewinn() {
        if (myButton1.getText() == "X" && myButton2.getText() == "X" && myButton3.getText() == "X") {
            reset();
            varX++;
            setTitle(varX + " : " + varO);
        }

        if (myButton1.getText() == "O" && myButton2.getText() == "O" && myButton3.getText() == "O") {
            reset();
            varO++;
            setTitle(varX + " : " + varO);
        }

        if (myButton4.getText() == "X" && myButton5.getText() == "X" && myButton6.getText() == "X") {
            reset();
            varX++;
            setTitle(varX + " : " + varO);
        }

        if (myButton4.getText() == "O" && myButton5.getText() == "O" && myButton6.getText() == "O") {
            reset();
            varO++;
            setTitle(varX + " : " + varO);
        }

        if (myButton7.getText() == "X" && myButton8.getText() == "X" && myButton9.getText() == "X") {
            reset();
            varX++;
            setTitle(varX + " : " + varO);
        }

        if (myButton7.getText() == "O" && myButton8.getText() == "O" && myButton9.getText() == "O") {
            reset();
            varO++;
            setTitle(varX + " : " + varO);
        }

        if (myButton1.getText() == "X" && myButton4.getText() == "X" && myButton7.getText() == "X") {
            reset();
            varX++;
            setTitle(varX + " : " + varO);
        }

        if (myButton1.getText() == "O" && myButton4.getText() == "O" && myButton7.getText() == "O") {
            reset();
            varO++;
            setTitle(varX + " : " + varO);
        }

        if (myButton2.getText() == "X" && myButton5.getText() == "X" && myButton8.getText() == "X") {
            reset();
            varX++;
            setTitle(varX + " : " + varO);
        }

        if (myButton2.getText() == "O" && myButton5.getText() == "O" && myButton8.getText() == "O") {
            reset();
            varO++;
            setTitle(varX + " : " + varO);
        }

        if (myButton3.getText() == "X" && myButton6.getText() == "X" && myButton9.getText() == "X") {
            reset();
            varX++;
            setTitle(varX + " : " + varO);
        }

        if (myButton3.getText() == "O" && myButton6.getText() == "O" && myButton9.getText() == "O") {
            reset();
            varO++;
            setTitle(varX + " : " + varO);
        }

        if (myButton1.getText() == "O" && myButton5.getText() == "O" && myButton9.getText() == "O") {
            reset();
            varO++;
            setTitle(varX + " : " + varO);
        }

        if (myButton1.getText() == "X" && myButton5.getText() == "X" && myButton9.getText() == "X") {
            reset();
            varX++;
            setTitle(varX + " : " + varO);
        }

        if (myButton3.getText() == "X" && myButton5.getText() == "X" && myButton7.getText() == "X") {
            reset();
            varX++;
            setTitle(varX + " : " + varO);
        }

        if (myButton3.getText() == "O" && myButton5.getText() == "O" && myButton7.getText() == "O") {
            reset();
            varO++;
            setTitle(varX + " : " + varO);
        }

        if (myButton1.getText() != "" && myButton2.getText() != "" && myButton3.getText() != ""
                && myButton4.getText() != "" && myButton5.getText() != "" && myButton6.getText() != ""
                && myButton7.getText() != "" && myButton8.getText() != "" && myButton9.getText() != "") {
            reset();
        }

    }

    public static void main(String[] args) {
        new TTT();

    }

}