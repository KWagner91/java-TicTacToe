public class TicTacToe {

    public static void main(String[] args) {
        Board board = new Board();
        board.setBoard(new char[3][3]);
        board.setEmptyBoard();
        board.showBoard();

        // Create player instances
        Player player1 = new Player('X');
        Player player2 = new Player('O');

        // Game
        while (true) {
            System.out.println("Player 1 move: ");
            player1.playerMove();
            while (!player1.isValidCoordinates()) {
                player1.playerMove();
            }
            board.updateBoard(player1.getCoordinates(), player1);
            board.showBoard();

            // Check win or draw
            if (board.win(player1)) {
                System.out.println("Player 1 wins the game!");
                break;
            } else if (board.isDraw()) {
                System.out.println("Nobody wins!");
            }

            System.out.println("Player 2 move: ");
            player2.playerMove();
            while (!player2.isValidCoordinates()) {
                player2.playerMove();
            }
            board.updateBoard(player2.getCoordinates(), player2);
            board.showBoard();

            // Check win or draw
            if (board.win(player2)) {
                System.out.println("Player 2 wins the game!");
                break;
            } else if (board.isDraw()) {
                System.out.println("Nobody wins!");
            }
        }
    }
}
