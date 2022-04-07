
import javax.swing.*;



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
     * Creates a grid against a human from given parameters.
     * @param newRow the new row count.
     * @param newCol the new column count.
     */
    public ConnectGrid(final int newRow, final int newCol) {

        connect4 = new JFrame("ConnectGrid");
        connect4.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        connect4.setSize(550, 420);
        connect4.setPreferredSize(connect4.getSize());
        connect4.add(new CreateGrid(newRow, newCol));
        connect4.setVisible(true);


    }
    /**
     * The main method of running the connect 4 game.
     * @param argv the argument parameter.
     */

    public static void main(final String[] argv) {
        new ConnectHome();
    }
    }
