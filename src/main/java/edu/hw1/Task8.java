package edu.hw1;

import static edu.hw1.Constants.BoarLength;

public class Task8 {
    private Task8() {
    }

    public static boolean knightBoardCapture(int[][] board) {
        if (board.length != BoarLength) {
            return false;
        }
        for (int i = 0; i < BoarLength; ++i) {
            if (board[i].length != BoarLength) {
                return false;
            }
        }
        for (int i = 0; i < BoarLength; ++i) {
            for (int j = 0; j < BoarLength; ++j) {
                if (board[i][j] == 1) {
                    int[] xBeat = {i + 2, i + 2, i - 2, i - 2, i + 1, i - 1, i + 1, i - 1};
                    int[] yBeat = {j + 1, j - 1, j + 1, j - 1, j + 2, j + 2, j - 2, j - 2};
                    for (int x = 0; x < BoarLength; ++x) {
                        if (-1 < xBeat[x] && xBeat[x] < BoarLength && -1 < yBeat[x] && yBeat[x] < BoarLength) {
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
