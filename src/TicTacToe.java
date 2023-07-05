import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe implements ActionListener {

    JFrame frame = new JFrame();

    JPanel text = new JPanel();

    JLabel title = new JLabel();

    JPanel game = new JPanel();

    JButton[] buttons = new JButton[9];



    TicTacToe() {

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
            game.add(buttons[i]);

        }




        frame.add(text, BorderLayout.NORTH);
        frame.add(game);
        frame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
