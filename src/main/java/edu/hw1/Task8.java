package edu.hw1;

import static edu.hw1.Constants.BOARDLENGTH;

public class Task8 {
    private Task8() {
    }

    public static boolean knightBoardCapture(int[][] board) {
        if (board.length != BOARDLENGTH) {
            return false;
        }
        for (int i = 0; i < BOARDLENGTH; ++i) {
            if (board[i].length != BOARDLENGTH) {
                return false;
            }
        }
        for (int i = 0; i < BOARDLENGTH; ++i) {
            for (int j = 0; j < BOARDLENGTH; ++j) {
                if (board[i][j] == 1) {
                    int[] xBeat = {i + 2, i + 2, i - 2, i - 2, i + 1, i - 1, i + 1, i - 1};
                    int[] yBeat = {j + 1, j - 1, j + 1, j - 1, j + 2, j + 2, j - 2, j - 2};
                    for (int x = 0; x < BOARDLENGTH; ++x) {
                        if (-1 < xBeat[x] && xBeat[x] < BOARDLENGTH && -1 < yBeat[x] && yBeat[x] < BOARDLENGTH) {
                            if (board[yBeat[x]][xBeat[x]] == 1) {
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
