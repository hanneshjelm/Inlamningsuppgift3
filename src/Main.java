import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.*;

public class Main extends JFrame implements ActionListener  {
    Panel p = new Panel();
    Panel p2 = new Panel();
    Panel p3 = new Panel();

    JButton button2 = new JButton("Start/Restart");
    JButton button3 = new JButton("Exit");
    JButton button4 = new JButton("CLICKA INTE");
    JButton button5 = new JButton("");
    ArrayList<JButton> buttons;

    public Main() {

        buttons = new ArrayList<>();

        for (int i = 1; i <= 15; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.addActionListener(this);
            buttons.add(button);
            p2.add(button);
        }

        setTitle("Test");
        this.add(p);
        p.setLayout(new BorderLayout());
        p.add(p2, BorderLayout.CENTER);
        p.add(p3, BorderLayout.SOUTH);
        p2.setLayout(new GridLayout(4, 4));
        p3.setLayout(new FlowLayout());

        p3.add(button2);
        p3.add(button3);
        p3.add(button4);

        button5.setEnabled(false);
        buttons.add(button5);

        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        button2.addActionListener(e -> newGame());
        button3.addActionListener(e -> exit());
        button4.addActionListener(e -> fusk());

    }

    private void newGame(){
        p2.removeAll();
        Collections.shuffle(buttons);
        for (JButton button : buttons) {
            p2.add(button);
        }
        p2.revalidate();
        p2.repaint();
    }

    private void fusk() {
        JButton button15 = null;
        for (JButton btn : buttons) {
            if (btn.getText().equals("15")) {
                button15 = btn;
                break;
            }
        }
        if (button15 != null) {
            Collections.swap(buttons, buttons.indexOf(button5), buttons.indexOf(button15));
            p2.removeAll();
            for (JButton button : buttons) {
                p2.add(button);
            }
            p2.revalidate();
            p2.repaint();
        }

    }
    private void exit(){
        System.exit(0);
    }

    private boolean isNextToEmpty(int index1, int index2) {
        int row1 = index1 / 4;
        int col1 = index1 % 4;
        int row2 = index2 / 4;
        int col2 = index2 % 4;
        return (Math.abs(row1 - row2) + Math.abs(col1 - col2)) == 1;
    }

    private boolean done() {
        for (int i = 0; i < 15; i++) {
            if (!buttons.get(i).getText().equals(String.valueOf(i + 1))) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Main main = new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}