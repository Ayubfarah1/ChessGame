public class Bishop {
    int row;
    int col;
    boolean isBlack;

    public Bishop(int row, int col, boolean isBlack) {
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;

    }

    /**
     *
     * @param board : the board
     * @param endRow : the end row for the move
     * @param endCol : the end col for the move
     * @return true if the move is legal for a bishop, meaning the diagonal move is verified and source
     * and destination is verified.
     */
    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        if (board.verifyDiagonal(row, col, endRow, endCol) &&
                board.verifySourceAndDestination(row, col, endRow, endCol, isBlack)) {
            return true;
        }
        return false;
    }
}
