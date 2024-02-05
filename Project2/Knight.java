public class Knight {
    int row;
    int col;
    boolean isBlack;

    public Knight(int row, int col, boolean isBlack) {
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }

    /**
     *
     * @param board: the board
     * @param endRow : the row
     * @param endCol : the end col
     * @return true if the move is legal for the Knight, if the source & destination and the formula
     * are verified. and returns false if it's not.
     */
    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        if (board.verifySourceAndDestination(row, col, endRow, endCol, isBlack) &&
                (Math.pow((row - endRow), 2) + Math.pow((col - endCol), 2)) == 5) {
            return true;
        }
        return false;
    }
}F