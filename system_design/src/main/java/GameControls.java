public class GameControls {
    // WIN STRATEGIES------
    public boolean checkWin(char[][] board, char symbol) {
        int size = 3;
        // Check rows and columns
        for (int i = 0; i < size; i++) {
            if (checkRow(board, symbol, i) || checkColumn(board, symbol, i)) {
                return true;
            }
        }
        // Check diagonals
        return checkDiagonal(board, symbol) || checkAntiDiagonal(board, symbol);
    }

    private boolean checkRow(char[][] board, char symbol, int row) {
        for (int i = 0; i < 3; i++) {
            if (board[row][i] != symbol) {
                return false;
            }
        }
        return true;
    }

    private boolean checkColumn(char[][] board, char symbol, int col) {
        for (int i = 0; i < 3; i++) {
            if (board[i][col] != symbol) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDiagonal(char[][] board, char symbol) {
        for (int i = 0; i < 3; i++) {
            if (board[i][i] != symbol) {
                return false;
            }
        }
        return true;
    }

    private boolean checkAntiDiagonal(char[][] board, char symbol) {
        int size = 3;
        for (int i = 0; i < size; i++) {
            if (board[i][size - 1 - i] != symbol) {
                return false;
            }
        }
        return true;
    }
    // WIN STRATEGIES -------

    public boolean checkMove(char[][] board, int x, int y) {
        if(x>2 || y>2 || x<0 || y<0) return false;
        if(board[x][y]!='.') return false;

        return true;
    }
}
