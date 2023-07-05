import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe implements ActionListener {

    JFrame frame = new JFrame();

    JPanel text = new JPanel();

    JLabel title = new JLabel();

    JPanel game = new JPanel();

    JButton[] buttons = new JButton[9];

    Random random = new Random();

    boolean xTurn;

    String o = "O";

    String x = "X";


    TicTacToe() throws InterruptedException {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setSize(800, 800);
        title.setText("Tic-Tac-Toe");
        title.setFont(new Font("MV Boli", Font.PLAIN, 50));
        text.setBackground(Color.GRAY);
        text.add(title);


        game.setLayout(new GridLayout(3, 3));

        for (int i = 0 ; i < 9 ; i++) {
            buttons[i] = new JButton();
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            buttons[i].setFont(new Font("MV Boli", Font.PLAIN, 70));
            game.add(buttons[i]);

        }


        frame.add(text, BorderLayout.NORTH);
        frame.add(game);
        frame.setVisible(true);


        int turnSelector = random.nextInt(2);

        xTurn = turnSelector == 0;

        Thread.sleep(500);

        if (xTurn) {
            title.setText("X turn");
        }
        else {
            title.setText("O turn");
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i=0 ; i<9 ; i++) {
            if(e.getSource()==buttons[i] && buttons[i].getText().equals("")) {
                if(xTurn) {
                    buttons[i].setForeground(new Color(255,0,0));
                    buttons[i].setText(x);
                    title.setText("O turn");
                }
                else {
                    buttons[i].setForeground(new Color(0,0,255));
                    buttons[i].setText(o);
                    title.setText("X turn");
                }

                if (checkDraw()) {
                    title.setText("Draw!");
                }

                xTurn = !xTurn;

                String winner = checkWinner();

                if (!winner.equals("")) {
                    if (winner.equals(o)) {
                        title.setText("O wins!");
                    }
                    else {
                        title.setText("X wins!");
                    }
                }
            }
        }
    }

    public boolean checkDraw() {

        for (int i = 0 ; i < 9 ; i++) {

            if (buttons[i].getText().equals("")) {
                return false;
            }
        }
        return true;
    }

    public String checkWinner() {

        String winner = "";

        for (int i = 0 ; i < 2 ; i++) {

            if (buttons[(3 * i)].getText().equals(buttons[(3 * i) + 1].getText()) && buttons[(3 * i)].getText().equals(buttons[(3 * i) + 2].getText()) && !buttons[(3 * i)].getText().equals("")) {
                winner = buttons[3 * i].getText();
                winnerBoard((3 * i), (3 * i) + 1, (3 * i) + 2);
            }
            if (buttons[i].getText().equals(buttons[i + 3].getText()) && buttons[i].getText().equals(buttons[i + 6].getText()) && !buttons[i].getText().equals("")) {
                winner = buttons[i].getText();
                winnerBoard(i, i + 3, i + 6);
            }

        }

        if (buttons[0].getText().equals(buttons[4].getText()) && buttons[0].getText().equals(buttons[8].getText()) && !buttons[0].getText().equals("")) {
            winner = buttons[0].getText();
            winnerBoard(0, 4, 8);
        }
        if (buttons[2].getText().equals(buttons[4].getText()) && buttons[2].getText().equals(buttons[6].getText()) && !buttons[2].getText().equals("")) {
            winner = buttons[0].getText();
            winnerBoard(2, 4, 6);
        }

        return winner;
    }

    public void winnerBoard(int a, int b, int c) {

        for (int i = 0 ; i < 9 ; i++) {

            if (i != a && i != b && i != c) {
                buttons[i].setEnabled(false);
            }
            else {
                buttons[i].setForeground(Color.GREEN);
            }
        }
    }
}



