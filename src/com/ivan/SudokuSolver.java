package com.ivan;

public class SudokuSolver {

    public static boolean isPossible(int row, int col, int[][] grid, int num) {

        for (int i = 0; i < 9; i++) {
            if (grid[row][i] == num) return false;
            if (grid[i][col] == num) return false;
        }

        int rowTemp = (row / 3) * 3;
        int colTemp = (col / 3) * 3;

        for (int j = rowTemp; j < rowTemp + 3; j++) {
            for (int i = colTemp; i < colTemp + 3; i++) {
                if (grid[j][i] == num) return false;
            }
        }

        return true;
    }

    public static boolean solveSudoku(int[][] grid) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (grid[row][col] == 0) {
                    for (int num = 1; num < 10; num++) {
                        if (isPossible(row, col, grid, num)) {
                            grid[row][col] = num;

                            if (solveSudoku(grid)) {
                                return true;
                            } else {
                                grid[row][col] = 0;
                            }
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }
}
