
import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
import java.util.Scanner;


public class CreateGridComputer extends JPanel implements MouseListener {
    /** Which player's turn it is.*/
    protected static int currentTurn = 1;
    /** The number of rows for the grid.*/
    protected static int rows = 6;
    /** The number of columns for the grid.*/
    protected static int columns = 7;
    /** Creates a grid of colors for the game.*/
    protected static Color[][] cGrid;
    /** The starting x position on the GUI.*/
    protected static int startingX = 0;
    /** The starting y position on the GUI.*/
    protected static int startingY = 0;
    /** The width of the pieces and grid spots.*/
    protected static final int circleWidth = 50;
    /** Which player won the game.*/
    protected static int won = 2;
    /** int to check for if what is
     * clicked is out of bounds.*/
    protected static final int outOfBounds = 20;
    /** Sets teh x value for the print statements of who won. */
    protected static int printX = 400;
    /**
     *
     * Creates a 6 by 7 grid of connect 4.
     */
    public CreateGridComputer() {
        addMouseListener(this);
        setRows(6);
        setColumns(7);
        setPrintX(400);
        cGrid = new Color[rows][columns];
        //creates the grid of the 6 by 7 connect 4 game in white
        for (int i = 0; i < cGrid.length; ++i) {
            for (int j = 0; j < cGrid[0].length; ++j) {
                cGrid[i][j] = new Color(255, 255, 255);
            }
        }
    }

    /**
     *  Creates a grid given the row and column count.
     * @param newRow the new row amount.
     * @param newCol the new column amount.
     */
    public CreateGridComputer(final int newRow, final int newCol) {
        addMouseListener(this);
        setRows(newRow);
        setColumns(newCol);
        setPrintX(newCol * 70);
        cGrid = new Color[rows][columns];
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
            graphic2.drawString("Yellow Player's Turn", printX, 50);
        } else {
            graphic2.drawString("Red Player's Turn", printX, 50);
        }
        //checks if the game is in progress or if one player won yet.
        if (won == 0) {
            graphic2.drawString("Red Player Won", printX, 20);
            reset();
            won = 2;
        } else if (won == 1) {
            graphic2.drawString("Yellow Player Won", printX, 20);
            reset();
            won = 2;
        } else if (won == 2) {
            graphic2.drawString("Game in Progress", printX, 20);
        } else {
            graphic2.drawString("Game is Tied", printX, 20);
            reset();
            won = 2;
        }
    }

    /**
     * Checks if mouse was pressed.
     * @param e gets what the mouse event is.
     */
    public void mousePressed(final MouseEvent e) {
        int xLocation = e.getX() / circleWidth;
        int yLocation = ConnectGridLogicComputer.openingComputer(xLocation);
        //if the game is ongoing it will update the grid with who's piece it is
        //based on where the board is pressed.
        if (yLocation == outOfBounds) {
            System.out.println("Pick a New Spot, Column is Full.");
        } else if (won == 2) {
            if (currentTurn == 1) {
                cGrid[yLocation][xLocation] = new Color(255, 255, 0);
                currentTurn = currentTurn + 1;
                computerTurn();
            } else {
                System.out.println("Not Your Turn!");
            }
            repaint();
        }
        //checks if there is a winner
        //and sets the winner to who won if there is.
        int result = ConnectGridLogicComputer.checkVerticalComputer();
        int result2 = ConnectGridLogicComputer.checkHorizontalComputer();
        int result3 = ConnectGridLogicComputer.checkDiagonal1Computer();
        int result4 = ConnectGridLogicComputer.checkDiagonal2Computer();
        int tie = ConnectGridLogicComputer.checkTieComputer();
        if (result == 0 || result2 == 0 || result3 == 0 || result4 == 0) {
            won = 0;
        } else if (result == 1 || result2 == 1
                || result3 == 1 || result4 == 1) {
            won = 1;
        } else {
            won = 2;
        }
        if (tie == 1) {
            won = 3;
        }

    }


    /**
     * The computer picks a random x value.
     */
    public void computerTurn() {
        Random rand = new Random();
        int n;
        while (true) {
            n = rand.nextInt(columns);
            int yLocation = ConnectGridLogicComputer.openingComputer(n);
            //if the game is ongoing it will update
            //the grid with who's piece it is
            //based on where the board is pressed.
            if (yLocation == outOfBounds) {
                System.out.println("Pick a New Spot, Column is Full.");
            } else if (won == 2) {
                    currentTurn = 1;
                    cGrid[yLocation][n] = new Color(255, 0, 0);
                repaint();
                break;
            }
        }
            //checks if there is a winner
            //and sets the winner to who won if there is.
            int result = ConnectGridLogicComputer.checkVerticalComputer();
            int result2 = ConnectGridLogicComputer.checkHorizontalComputer();
            int result3 = ConnectGridLogicComputer.checkDiagonal1Computer();
            int result4 = ConnectGridLogicComputer.checkDiagonal2Computer();
            int tie = ConnectGridLogicComputer.checkTieComputer();
            if (result == 0 || result2 == 0 || result3 == 0 || result4 == 0) {
                won = 0;
            } else if (result == 1 || result2 == 1
                    || result3 == 1 || result4 == 1) {
                won = 1;
            } else {
                won = 2;
            }
            if (tie == 1) {
                won = 3;
            }
    }

    /**
     * Sets the row count.
     * @param rowNum the new row count.
     */
    public void setRows(final int rowNum) {
        rows = rowNum;
    }

    /**
     * Sets the column count.
     * @param colNum the new column count.
     */
    public void setColumns(final int colNum) {
        columns = colNum;
    }

    /**
     * Sets the x position for the prints.
     * @param newX the new x position.
     */
    public void setPrintX(final int newX) {
        printX = newX;
    }

    /**
     * Checks if you want to play a new game.
     */
    public void reset() {
        Scanner reader = new Scanner(System.in);
        System.out.println("New Game? (1 for Yes, 0 For No)");
        int game = reader.nextInt();
        if (game == 1) {
            new ConnectHome();
        } else {
            System.exit(0);
        }
    }

    /**
     * Gets the rows.
     * @return returns the number of rows.
     */
    public int getRows() {
        return rows;
    }

    /**
     * Gets the columns.
     * @return returns the number of columns.
     */
    public int getCols() {
        return columns;
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
