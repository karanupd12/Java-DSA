
package recursion.backtracking;

// List all the ways in which N queens can be placed in an NxN chessboard
// such that they are all safe (won't attack each other)
public class Nqueens {

    //main recursive function to solve n queens
    static void queens(int[][] board, int row) {
        if (row == board.length) {
            display(board);
            System.out.println();
        }
        for (int col = 0; col < board[0].length; col++) {              //for each cell
            if (isSafe(board, row, col)) {
                board[row][col] = 1;               // Place the queen
                queens(board, row + 1);       // Recursively place queens in the next row
                board[row][col] = 0;               // Backtrack and remove the queen
            }
        }
    }

    private static boolean isSafe(int[][] board, int row, int col) {

        for (int i = 0; i < row; i++)                                        // Check vertically up the column
            if (board[i][col] == 1) return false;

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)      // Check upper-left diagonal
            if (board[i][j] == 1) return false;

        for (int i = row - 1, j = col + 1; i >= 0 && j < board[0].length; i--, j++)         // Check upper-right diagonal
            if (board[i][j] == 1) return false;

        // No need to check the current row or rows below (not yet explored)
        return true; // Safe to place queen
    }

    private static void display(int[][] board) {
        for (int[] row : board) {
            for (int element : row) {
                if (element == 1) System.out.print("Q ");
                else System.out.print("X ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] board = new int[n][n];
        queens(board, 0);
    }

}
