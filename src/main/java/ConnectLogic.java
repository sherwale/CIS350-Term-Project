import java.awt.Color;

public class ConnectLogic extends CreateGrid {
    /**
     * Checks for an open spot below where the player pressed.
     *
     * @param xLocation the x location
     *                  of the GUI which the player pressed.
     * @return returns the y location if okay, and outOfbounds if not.
     */
    public static int opening(final int xLocation) {
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
     *
     * @return returns which player won or if neither did.
     */
    public static int checkVertical() {
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
        }
        return 2;
    }

    /**
     * Checks the horizontal win condition of 4 pieces in a row.
     *
     * @return returns which player won or if neither did.
     */
    public static int checkHorizontal() {
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
        }
        return 2;
    }

    /**
     * Checks the diagonal win condition of 4 pieces in a row
     * from top left to bottom right.
     *
     * @return returns which player won or if neither did.
     */
    public static int checkDiagonal1() {
        int check = 0;
        int check2 = 0;
        for (int y = 0; y < cGrid[0].length - 3; ++y) {
            for (int x = 0; x < cGrid[0].length - 4; ++x) {
                for (int i = 0; i < 4; ++i) {
                    if (cGrid[x + i][y + i].equals(new Color(255, 0, 0))) {
                        check++;
                        check2 = 0;
                        if (check >= 4) {
                            return 0;
                        }
                    } else if (cGrid[x + i][y + i].equals(new Color(255, 255, 0))) {
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
            }
        }
        return 2;
    }
    /**
     * Checks the diagonal win condition of 4 pieces in a row
     * from top right to bottom left.
     *
     * @return returns which player won or if neither did.
     */
    public static int checkDiagonal2() {
        int check = 0;
        int check2 = 0;
        for (int y = 0; y < cGrid[0].length - 3; ++y) {
            for (int x = 3; x < cGrid[0].length - 1; ++x) {
                for (int i = 0; i < 4; ++i) {
                    if (cGrid[x - i][y + i].equals(new Color(255, 0, 0))) {
                        check++;
                        check2 = 0;
                        if (check >= 4) {
                            return 0;
                        }
                    } else if (cGrid[x - i][y + i].equals(new Color(255, 255, 0))) {
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
            }
        }
        return 2;
    }
    /**
     * Checks for a tie
     * from top right to bottom left.
     *
     * @return returns if all tiles are full.
     */
    public static int checkTie() {
        int check = 0;
        for (int y = 0; y < cGrid[0].length; ++y) {
            for (int x = 0; x < cGrid[0].length - 1; ++x) {
               if (cGrid[x][y].equals(new Color(255, 255, 255))) {
                    check++;
                }
            }
        }
        if (check > 0) {
            return 0;
        } else {
            return 1;
        }
    }
}
