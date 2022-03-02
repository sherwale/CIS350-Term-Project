import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConnectHome {

    private JFrame home;
    private JPanel panel;
    private JLabel label;
    private JButton start;

    public ConnectHome() {

        panel = new JPanel();
        label = new JLabel("Connect Four");
        label.setFont(new Font("Verdana", 1, 20));
        label.setForeground(Color.WHITE);
        panel.setBackground(Color.BLUE);
        panel.add(label);
        home = new JFrame("Home Screen");
        start = new JButton("Start A Game!");
        start.setBounds(50, 100, 50,20);
        home.add(panel);
        panel.add(start);
        home.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        home.setSize(550, 420);
        home.setPreferredSize(home.getSize());
        home.setVisible(true);
        start.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                start.setVisible(false);
                new ConnectGrid();
            }
        }));
    }

}
