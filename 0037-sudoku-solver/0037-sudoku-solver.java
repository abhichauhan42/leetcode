class Solution {
    public boolean issafe(char[][] board, int row, int col, char digit) {
        // for column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == digit) {
                return false;
            }
        }

        // for row
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == digit) {
                return false;
            }
        }

        // for grid
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;

        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (board[i][j] == digit) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean sudokusolver(char[][] board, int row, int col) {
        // base case
        if (row == 9 && col == 0) {
            return true;
        }

        int nextrow = row, nextcol = col + 1;
        if (col + 1 == 9) {
            nextrow = row + 1;
            nextcol = 0;
        }
        if (board[row][col] != '.') {
            return sudokusolver(board, nextrow, nextcol);
        }
        for (char digit = '1'; digit <= '9'; digit++) {
            if (issafe(board, row, col, digit)) {
                board[row][col] = digit;
                if (sudokusolver(board, nextrow, nextcol)) {
                    return true;
                }
                board[row][col] = '.'; // Backtrack if the current digit doesn't lead to a solution
            }
        }
        return false;
    }

    public void print(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }

    public void solveSudoku(char[][] board) {
        sudokusolver(board, 0, 0);
        print(board);
    }
}
