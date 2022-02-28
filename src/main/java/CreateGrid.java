
import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class CreateGrid extends JPanel implements MouseListener {
    /** Which player's turn it is.*/
    private int currentTurn = 1;
    /** The number of rows for the grid.*/
    private int rows = 6;
    /** The number of columns for the grid.*/
    private int columns = 7;
    /** Creates a grid of colors for the game.*/
    private Color[][] cGrid = new Color[rows][columns];
    /** The starting x position on the GUI.*/
    private int startingX = 0;
    /** The starting y position on the GUI.*/
    private int startingY = 0;
    /** The width of the pieces and grid spots.*/
    private int circleWidth = 50;
    /** Which player won the game.*/
    private int won = 2;
    /** int to check for if what is
     * clicked is out of bounds.*/
    private int outOfBounds = 20;
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
        int yLocation = opening(xLocation);
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
        int result = checkVertical();
        int result2 = checkHorizontal();
        if (result == 0 || result2 == 0) {
            won = 0;
        } else if (result == 1 || result2 == 1) {
            won = 1;
        } else {
            won = 2;
        }
    }

    /**
     * Checks for an open spot below where the player pressed.
     * @param xLocation the x location
     *                  of the GUI which the player pressed.
     * @return returns the y location if okay, and outOfbounds if not.
     */
    public int opening(final int xLocation) {
        int yLocation = rows - 1;
        //checks if the spot in the gird is open
        // and returns the lowest open spot if available.
        while (!cGrid[yLocation][xLocation].equals(new Color(255, 255, 255))) {
            yLocation = yLocation - 1;
            if (yLocation < 0) {
                return outOfBounds;
            }
        }
        return yLocation;
    }

    /**
     * Checks the vertical win condition of 4 pieces in a row.
     * @return returns which player won or if neither did.
     */
    public int checkVertical() {
        int check = 0;
        int check2 = 0;
        //Goes through the grid and checks for winner vertically.
        for (int i = 0; i < cGrid[0].length; ++i) {
            for (int j = 0; j < cGrid[0].length - 1; ++j) {
                //if there is 4 reds in a row vertically then red won.
                if (cGrid[j][i].equals(new Color(255, 0, 0))) {
                    check++;
                    check2 = 0;
                    if (check >= 4) {
                        return 0;
                    }
                } else if (cGrid[j][i].equals(new Color(255, 255, 0))) {
                    //if there is 4 yellows in a row vertically then yellow won.
                    check = 0;
                    check2++;
                    if (check2 >= 4) {
                        return 1;
                    }
                } else {
                    check = 0;
                    check2 = 0;
                }
            }
            //return 2 noting that there is no winner and the game is ongoing.
        }   return 2;
    }

    /**
     * Checks the horizontal win condition of 4 pieces in a row.
     * @return returns which player won or if neither did.
     */
    public int checkHorizontal() {
        int check = 0;
        int check2 = 0;
        //Goes through the grid and checks for winner horizontally.
        for (int i = 0; i < cGrid[0].length - 1; ++i) {
            for (int j = 0; j < cGrid[0].length; ++j) {
                //if there is 4 reds in a row horizontally then red won.
                if (cGrid[i][j].equals(new Color(255, 0, 0))) {
                    check++;
                    check2 = 0;
                    if (check >= 4) {
                        return 0;
                    }
                } else if (cGrid[i][j].equals(new Color(255, 255, 0))) {
                    //if there is 4 yellows in a
                    // row horizontally then yellow won.
                    check = 0;
                    check2++;
                    if (check2 >= 4) {
                        return 1;
                    }
                } else {
                    check = 0;
                    check2 = 0;
                }
            }
            //return 2 noting that there is no winner and the game is ongoing.
        }   return 2;
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
