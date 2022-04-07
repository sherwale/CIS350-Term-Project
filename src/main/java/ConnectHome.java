import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class ConnectHome {

    private JFrame home;
    private JPanel panel;
    private JLabel label;
    private JButton start;
    private JButton computer;

    public ConnectHome() {

        panel = new JPanel();
        label = new JLabel("Connect Four");
        label.setFont(new Font("Verdana", 1, 70));
        label.setForeground(Color.WHITE);
        panel.setBackground(Color.BLUE);
        home = new JFrame("Home Screen");
        start = new JButton("Start A Game Against Another Person.");
        computer = new JButton("Start A Game Vs A Computer.");
        panel.setLayout(new BorderLayout());
        start.setBounds(0, 325, 600,25);
        home.add(panel);
        panel.add(label, BorderLayout.NORTH);
        panel.add(start, BorderLayout.SOUTH);
        panel.add(computer, BorderLayout.SOUTH);
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

        computer.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                new ConnectGridComputer();
                home.setVisible(false);
            }
        }));
    }

}
