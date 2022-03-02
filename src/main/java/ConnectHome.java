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
        label.setFont(new Font("Verdana", 1, 70));
        label.setForeground(Color.WHITE);
        panel.setBackground(Color.BLUE);
        home = new JFrame("Home Screen");
        start = new JButton("Start A Game Against Another Person");
        panel.setLayout(new BorderLayout());
        start.setBounds(50, 100, 50,50);
        home.add(panel);
        panel.add(label, BorderLayout.NORTH);
        panel.add(start, BorderLayout.SOUTH);
        home.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        home.setSize(550, 420);
        home.setPreferredSize(home.getSize());
        home.setVisible(true);
        start.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                new ConnectGrid();
                home.setVisible(false);
            }
        }));
    }

}
