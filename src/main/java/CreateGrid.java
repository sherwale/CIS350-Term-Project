
import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class CreateGrid extends JPanel implements MouseListener {
    /** Which player's turn it is.*/
    public static int currentTurn = 1;
    /** The number of rows for the grid.*/
    public static int rows = 6;
    /** The number of columns for the grid.*/
    public static int columns = 7;
    /** Creates a grid of colors for the game.*/
    public static Color[][] cGrid = new Color[rows][columns];
    /** The starting x position on the GUI.*/
    public static int startingX = 0;
    /** The starting y position on the GUI.*/
    public static int startingY = 0;
    /** The width of the pieces and grid spots.*/
    public static int circleWidth = 50;
    /** Which player won the game.*/
    public static int won = 2;
    /** int to check for if what is
     * clicked is out of bounds.*/
    public static int outOfBounds = 20;
    /**
     *
     * Creates a 6 by 7 grid of connect 4.
     */
    public CreateGrid() {
        addMouseListener(this);
        //creates the grid of the 6 by 7 connect 4 game in white
        for (int i = 0; i < cGrid.length; ++i) {
            for (int j = 0; j < cGrid[0].length; ++j) {
                cGrid[i][j] = new Color(255, 255, 255);
            }
        }
    }

    /**
     * Overrides the paintComponent method to implement painting
     * the board and repainting it when pieces are placed.
     * @param connectGraphic a graphics object.
     */
    @Override
    public void paintComponent(final Graphics connectGraphic) {
        Graphics2D graphic2 = (Graphics2D) connectGraphic;
        Dimension dimensionPaint = getSize();
        //creates the background in blue for the connect 4 game.
        graphic2.setColor(new Color(0, 0, 180));
        graphic2.fillRect(0, 0, dimensionPaint.width, dimensionPaint.height);
        startingX = 0;
        startingY = 0;
        //Fills the grid in with white 42 ovals for the
        // spots where the pieces will go when placed.
        for (int i = 0; i < cGrid.length; ++i) {
            for (int j = 0; j < cGrid[0].length; ++j) {
                graphic2.setColor(cGrid[i][j]);
                graphic2.fillOval(startingX, startingY,
                        circleWidth, circleWidth);
                startingX = startingX + circleWidth;
            }
            startingX = 0;
            startingY = startingY + circleWidth;
        }

        //Draws under the grid which player's turn it is currently.
        graphic2.setColor(new Color(255, 255, 255));
        if (currentTurn == 1) {
            graphic2.drawString("Yellow Player's Turn", 120, 350);
        } else {
            graphic2.drawString("Red Player's Turn", 120, 350);
        }
        //checks if the game is in progress or if one player won yet.
        if (won == 0) {
            graphic2.drawString("Red Player Won", 400, 20);
        } else if (won == 1) {
            graphic2.drawString("Yellow Player Won", 400, 20);
        } else {
            graphic2.drawString("Game in Progress", 400, 20);
        }
    }

    /**
     * Checks if mouse was pressed.
     * @param e gets what the mouse event is.
     */
    public void mousePressed(final MouseEvent e) {
        int xLocation = e.getX() / circleWidth;
        int yLocation = ConnectLogic.opening(xLocation);
        //if the game is ongoing it will update the grid with who's piece it is
        //based on where the board is pressed.
        if (yLocation == outOfBounds) {
            System.out.println("Pick a New Spot, Column is Full.");
        } else if (won == 2) {
            if (currentTurn == 2) {
                currentTurn = 1;
                cGrid[yLocation][xLocation] = new Color(255, 0, 0);
            } else {
                cGrid[yLocation][xLocation] = new Color(255, 255, 0);
                currentTurn = currentTurn + 1;
            }
                repaint();
        }
        //checks if there is a winner
        //and sets the winner to who won if there is.
        int result = ConnectLogic.checkVertical();
        int result2 = ConnectLogic.checkHorizontal();
        int result3 = ConnectLogic.checkDiagonal1();
        int result4 = ConnectLogic.checkDiagonal2();
        if (result == 0 || result2 == 0 || result3 == 0 || result4 == 0) {
            won = 0;
        } else if (result == 1 || result2 == 1
                || result3 == 1 || result4 == 1) {
            won = 1;
        } else {
            won = 2;
        }
    }

    //below are needed for compiling.
    /**
     * Checks for mouse entered.
     * @param e Which mouse event happened.
     */
    public void mouseEntered(final MouseEvent e) { }

    /**
     * Checks for mouse released.
     * @param e Which mouse event happened.
     */
    public void mouseReleased(final MouseEvent e) { }

    /**
     * Checks for mouse clicked.
     * @param e What mouse event happened.
     */
    public void mouseClicked(final MouseEvent e) { }

    /**
     * Checks for mouse exited.
     * @param e Which mouse event happened.
     */
    public void mouseExited(final MouseEvent e) { }
}
