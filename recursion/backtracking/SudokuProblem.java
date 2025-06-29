package recursion.backtracking;

/*The Sudoku problem is a classic logic-based number placement puzzle. The goal is to fill a 9x9 grid such that:

- Each row contains all the digits from 1 to 9 without repetition.
- Each column contains all the digits from 1 to 9 without repetition.
- Each of the nine 3x3 sub-grids (called boxes) contains all the digits from 1 to 9 without repetition.

Note : Some cells are pre-filled with numbers, serving as clues.
Implementation is basically same as NQueens. */


public class SudokuProblem {

    public static boolean sudokuSolver(int[][] grid){
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == 0){
                    for(int num = 1; num <= 9; num++){
                        if(isValid(grid, row, col, num)){
                            grid[row][col] = num;
                            if(sudokuSolver(grid)) return true;
                            grid[row][col] = 0;
                        }
                    }
                    return false;  //no valid number found
                }
            }
        }
        return true; //puzzle solved
    }

    private static boolean isValid(int[][] board, int row, int col, int num) {
        // Check the row
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }

        // Check the column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        // Check the 3x3 box
        int boxRowStart = (row / 3) * 3;
        int boxColStart = (col / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[boxRowStart + i][boxColStart + j] == num) {
                    return false;
                }
            }
        }

        return true; // Number can be placed
    }

    private static void display(int[][] grid) {
        for (int[] row : grid) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] board = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        if(sudokuSolver(board)) {
            display(board);
        }
        else System.out.println("NO possible answer");
    }
}
