import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
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
}



