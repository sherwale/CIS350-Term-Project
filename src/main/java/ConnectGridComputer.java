
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
        connect4Computer.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        connect4Computer.setSize(550, 420);
        connect4Computer.setPreferredSize(connect4Computer.getSize());
        connect4Computer.add(new CreateGridComputer());

        connect4Computer.setVisible(true);

    }
}
