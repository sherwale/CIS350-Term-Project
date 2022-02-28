
import javax.swing.JFrame;

import javax.swing.WindowConstants;

public class ConnectGrid extends CreateGrid {
    /**
     * Creates a frame for the connect 4 grid.
     */
    private JFrame connect4;

    /**
     * Creates a default grid of connect 4.
     */
    public ConnectGrid() {

        //Sets up a default game of Connect 4 with a size of 600 by 400
        //
        connect4 = new JFrame("ConnectGrid");
        connect4.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        connect4.setSize(550, 420);
        connect4.setPreferredSize(connect4.getSize());
        connect4.add(new CreateGrid());

        connect4.setVisible(true);

    }

    /**
     * The main method of running the connect 4 game.
     * @param argv the argument parameter.
     */
    public static void main(final String[] argv) {
        new ConnectGrid();
    }
    }
