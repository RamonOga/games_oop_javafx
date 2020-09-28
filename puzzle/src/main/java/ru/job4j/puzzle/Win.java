package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        boolean rsl = true;
        for (int row = 0; row < board.length; row++) {
            for (int cell = 0; cell < board.length; cell++) {
                if (board[row][cell] == 1) {
                    rsl = (Win.checkHorizontal(board, row) || Win.checkVertical(board, cell));
                    break;
                }
            }
        }
        return rsl;
    }

    public static boolean checkHorizontal(int[][] board, int row) {
        boolean rsl = true;
        for (int i = 0; i < board.length ; i++) {
            if (board[row][i] != 1) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }

    public static boolean checkVertical(int[][] board, int cell) {
        boolean rsl = true;
        for (int i = 0; i < board.length ; i++) {
            if (board[i][cell] != 1) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }


}
