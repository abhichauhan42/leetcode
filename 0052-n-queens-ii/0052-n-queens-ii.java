class Solution {

    public boolean issafe(char[][] board, int row, int col) {
        // vertical up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q')
                return false;
        }
        // left up
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // for right
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public boolean nqueen(char[][] board, int row, int[] count) {
        if (row == board.length) {
            count[0]++;
            return true;
        }

        for (int j = 0; j < board.length; j++) {
            if (issafe(board, row, j)) {
                board[row][j] = 'Q';
                nqueen(board, row + 1, count);
                board[row][j] = 'X'; // backtrack
            }
        }
        return false;
    }

    public int totalNQueens(int n) {
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'X';
            }
        }

        int[] count = {0};
        nqueen(board, 0, count);
        return count[0];
    }
}
