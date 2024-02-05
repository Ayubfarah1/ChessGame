import java.util.Scanner;

public class Game {

    /**
     *
     * @param args - string argument
     *  The main function of the game class takes a while loop that goes until either of the king pieces have
     *  been captured. Then shows which players turn it is and takes their input. But if there input is invalid,
     *  I let them know its invalid and have them input a new move. After their input is valid move or capture a piece.
     *  It checks to see if a pawn can be promoted and promotes if that is the case.
     *  The process repeats with the other players and this goes on until a king piece has been captured.
     */

    public static void main(String[] args) {
        boolean isBlack = false;
        Board myBoard = new Board();
        Fen.load("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR", myBoard);
        Scanner turn = new Scanner(System.in);
        while (myBoard.isGameOver() == false) {
            //Checks to see which colors turn it is
            System.out.println(myBoard);
            if (isBlack == false) {
                System.out.println("It is currently white's turn to play");
                System.out.println("What is your move? (format: [start row] [start col] [end row] [end col]");
            }
            if (isBlack == true) {
                System.out.println("It is currently black's turn to play");
                System.out.println("What is your move? (format: [start row] [start col] [end row] [end col]");
            }

            String input = turn.nextLine();
            String[] coordinates = input.split(" ");
            // takes and ask for input
            try {
                int startRow = Integer.parseInt(coordinates[0]);
                int startCol = Integer.parseInt(coordinates[1]);
                int endRow = Integer.parseInt(coordinates[2]);
                int endCol = Integer.parseInt(coordinates[3]);
                // checks to see if its invalid
                while (!(myBoard.verifySourceAndDestination(startRow, startCol, endRow, endCol, isBlack)
                        && myBoard.getPiece(startRow, startCol).getIsBlack() == isBlack
                        && myBoard.movePiece(startRow, startCol, endRow, endCol))) {
                    System.out.println("You have chosen an invalid position ");
                    if (isBlack == false) {
                        System.out.println("It is currently white's turn to play");
                        System.out.println("What is your move? (format: [start row] [start col] [end row] [end col]");
                    }
                    if (isBlack == true) {
                        System.out.println("It is currently black's turn to play");
                        System.out.println("What is your move? (format: [start row] [start col] [end row] [end col]");
                    }
//                     takes in input after invalid
                    input = turn.nextLine();
                    coordinates = input.split(" ");
                    startRow = Integer.parseInt(coordinates[0]);
                    startCol = Integer.parseInt(coordinates[1]);
                    endRow = Integer.parseInt(coordinates[2]);
                    endCol = Integer.parseInt(coordinates[3]);
                }
                //Checks to see if pawn has reached end of the board and promotes it
                if (myBoard.getPiece(endRow, endCol).getChar() == '\u2659' ||
                        (myBoard.getPiece(endRow, endCol).getChar() == '\u2659')) {
                    myBoard.getPiece(endRow, endCol).promotePawn(endRow, isBlack);
                }

                isBlack = !isBlack;
            } catch (Exception e){
                System.out.println("Invalid, try again");
            }
            }

            // checks to see if the game is over and lets the user know the game has ended
            if (myBoard.isGameOver()) {
                System.out.println(myBoard);
                System.out.println("Game has ended");
                if (isBlack == false) {
                    System.out.println("Black has won");
                } else {
                    System.out.println("White has won");
                }
            }
        }
    }

