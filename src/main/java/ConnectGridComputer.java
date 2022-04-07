
import javax.swing.JFrame;

import javax.swing.WindowConstants;

public class ConnectGridComputer extends CreateGridComputer {
    /**
     * Creates a frame for the connect 4 grid.
     */
    private JFrame connect4Computer;

    /**
     * Creates a default grid of connect 4.
     */
    public ConnectGridComputer() {

        //Sets up a default game of Connect 4 with a size of 600 by 400
        //
        connect4Computer = new JFrame("ConnectGrid");
        connect4Computer.setDefaultCloseOperation(
                WindowConstants.EXIT_ON_CLOSE);
        connect4Computer.setSize(550, 420);
        connect4Computer.setPreferredSize(connect4Computer.getSize());
        connect4Computer.add(new CreateGridComputer());
        connect4Computer.setVisible(true);

    }

    /**
     * Creates a grid against a computer from given parameters.
     * @param newRow the new row count.
     * @param newCol the new column count.
     */
    public ConnectGridComputer(final int newRow, final int newCol) {

        connect4Computer = new JFrame("ConnectGrid");
        connect4Computer.setDefaultCloseOperation(
                WindowConstants.EXIT_ON_CLOSE);
        connect4Computer.setSize(550, 420);
        connect4Computer.setPreferredSize(connect4Computer.getSize());
        connect4Computer.add(new CreateGridComputer(newRow, newCol));
        connect4Computer.setVisible(true);

    }
}
