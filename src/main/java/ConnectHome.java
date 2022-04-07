import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class ConnectHome {

    /** The JFrame for the Home Screen.*/
    private JFrame home;
    /** The JPanel for the Home Screen.*/
    private JPanel panel;
    /** The JLabel for the Home Screen.*/
    private JLabel label;
    /** Start a default game vs a person.*/
    private JButton start;
    /** Start a default game vs a computer.*/
    private JButton computer;
    /** Start a custom game vs a person.*/
    private JButton startCustom;
    /** Start a custom game vs a computer.*/
    private JButton computerCustom;

    /**
     * Default constructor for the home screen.
     */
    public ConnectHome() {

        panel = new JPanel();
        label = new JLabel("Connect Four");
        label.setFont(new Font("Verdana", 1, 70));
        label.setForeground(Color.WHITE);
        panel.setBackground(Color.BLUE);
        home = new JFrame("Home Screen");
        start = new JButton("Start A Game Against Another Person.");
        startCustom = new
                JButton("Start A Custom Game Against Another Person.");
        computer = new JButton("Start A Game VS A Computer.");
        computerCustom = new JButton("Custom Game VS A Computer.");
        panel.setLayout(new BorderLayout());
        start.setBounds(0, 275, 600, 25);
        startCustom.setBounds(0, 300, 600, 25);
        computerCustom.setBounds(0, 325, 600, 25);
        home.add(panel);
        panel.add(label, BorderLayout.NORTH);
        panel.add(start, BorderLayout.SOUTH);
        panel.add(startCustom, BorderLayout.SOUTH);
        panel.add(computerCustom, BorderLayout.SOUTH);
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

        startCustom.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                Scanner reader = new Scanner(System.in);
                System.out.println("Enter a Row Count");
                int row = reader.nextInt();
                System.out.println("Enter a Column Count");
                int col = reader.nextInt();
                new ConnectGrid(row, col);
                home.setVisible(false);
            }
        }));

        computerCustom.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                Scanner reader = new Scanner(System.in);
                System.out.println("Enter a Row Count");
                int row = reader.nextInt();
                System.out.println("Enter a Column Count");
                int col = reader.nextInt();
                new ConnectGridComputer(row, col);
                home.setVisible(false);
            }
        }));
    }

}
