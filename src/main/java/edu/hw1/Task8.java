package edu.hw1;

public class Task8 {
    private Task8() {
    }

    public static boolean knightBoardCapture(int[][] board) {
        if (board.length != 8) {
            return false;
        }
        for (int i = 0; i < 8; ++i) {
            if (board[i].length != 8) {
                return false;
            }
        }
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (board[i][j] == 1) {
                    int[] x_beat = {i + 2, i + 2, i - 2, i - 2, i + 1, i - 1, i + 1, i - 1};
                    int[] y_beat = {j + 1, j - 1, j + 1, j - 1, j + 2, j + 2, j - 2, j - 2};
                    for (int x = 0; x < 8; ++x) {
                        if (-1 < x_beat[x] && x_beat[x] < 8 && -1 < y_beat[x] && y_beat[x] < 8) {
                            if (board[y_beat[x]][x_beat[x]] == 1) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

}
