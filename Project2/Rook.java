public class Rook {
    int row;
    int col;
    boolean isBlack;

    public Rook(int row, int col, boolean isBlack) {
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;

    }

    /**
     *
     * @param board : the board
     * @param endRow : the end row of the move
     * @param endCol : the end col of the move
     * @return true if the move is legal for the rook meaning vertical, horizontal ,
     * and source and destination are verified. and returns false if it's not.
     */
    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        if (board.verifyVertical(row, col, endRow, endCol) || board.verifyHorizontal(row, col, endRow, endCol)
                && board.verifySourceAndDestination(row, col, endRow, endCol, isBlack)) {
            return true;

        }
        return false;
    }
}

