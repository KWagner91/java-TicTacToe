public class Board {
    private char[][] board;
    private boolean validMove;
    private int currentCol;
    private int currentRow;

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

    public void setEmptyBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void showBoard() {
        for (char[] row : this.board) {
            System.out.print("|");
            for (char column : row) {
                System.out.print(column);
                System.out.print("|");
            }
            System.out.println();
        }
    }

    public void updateBoard(int[] coordinates, Player player) {
        if (isValidMove(coordinates)) {
            this.board[coordinates[0]][coordinates[1]] = player.getTokken();
            this.currentCol = coordinates[0];
            this.currentRow = coordinates[1];
        } else {
            System.out.println("The other Player had his tokken there already!");
        }
    }

    public boolean isValidMove(int[] coordinates) {
        if (this.board[coordinates[0]][coordinates[1]] != '-') {
            this.validMove = false;
        } else {
            this.validMove = true;
        }
        return validMove;
    }

    public boolean win(Player player) {
        return (board[currentRow][0] == player.getTokken()         // 3-in-the-row
                && board[currentRow][1] == player.getTokken()
                && board[currentRow][2] == player.getTokken()
                || board[0][currentCol] == player.getTokken()         // 3-in-the-column
                && board[1][currentCol] == player.getTokken()
                && board[2][currentCol] == player.getTokken()
                || currentRow == currentCol            // 3-in-the-diagonal
                && board[0][0] == player.getTokken()
                && board[1][1] == player.getTokken()
                && board[2][2] == player.getTokken()
                || currentRow + currentCol == 2  // 3-in-the-opposite-diagonal
                && board[0][2] == player.getTokken()
                && board[1][1] == player.getTokken()
                && board[2][0] == player.getTokken());
    }


    public boolean isDraw() {
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (board[i][j] == '-') {
                    return false; // an empty seed found, not a draw, exit
                }
            }
        }
        return true; // no empty cell, it's a draw
    }


}
