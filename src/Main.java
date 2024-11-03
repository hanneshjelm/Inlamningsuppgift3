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



    }



    public static void main(String[] args) {
        Main main = new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}