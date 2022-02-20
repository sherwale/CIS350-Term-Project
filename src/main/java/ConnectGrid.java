
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class ConnectGrid extends CreateGrid{
    JFrame connect4;
    //private JPanel panel = new JPanel();
    //private JButton btn = new JButton("Reset");
    public ConnectGrid() {

        //Sets up a default game of Connect 4 with a size of 600 by 400
        //
        connect4 = new JFrame("ConnectGrid");
        connect4.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        connect4.setSize(550, 420);
        connect4.setPreferredSize(connect4.getSize());
        connect4.add(new CreateGrid());
        //btn.setBounds(400, 100, 60, 30);
        //panel.setLayout(null);
        //panel.add(btn);
        //panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        //frame.add(panel);
        connect4.setVisible(true);

    }
    public static void main(String[] argv){
        new ConnectGrid();
    }

    }
