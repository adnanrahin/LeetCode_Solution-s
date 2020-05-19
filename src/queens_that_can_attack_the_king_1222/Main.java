package queens_that_can_attack_the_king_1222;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String args[]) {

        int[][] queens = {{0, 1}, {1, 0}, {4, 0}, {0, 4}, {3, 3}, {2, 4}};
        int[] kings = {0, 0};

        System.out.println(queensAttacktheKing(queens, kings));

    }


    public static List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {

        int board[][] = new int[8][8];

        List<List<Integer>> solution = new ArrayList<>();

        board[king[0]][king[1]] = 2; // set the king position

        int kingX = king[0];

        int kingY = king[1];

        for (int i = 0; i < queens.length; i++) {
            board[queens[i][0]][queens[i][1]] = 1;
        }

        for (int i = kingX; i < 8; i++) {
            if (board[i][kingY] == 1) {
                solution.add(Arrays.asList(i, kingY));
                break;
            }
        }

        for (int i = kingX; i >= 0; i--) {
            if (board[i][kingY] == 1) {
                solution.add(Arrays.asList(i, kingY));
                break;
            }
        }

        for (int i = kingY; i < 8; i++) {
            if (board[kingX][i] == 1) {
                solution.add(Arrays.asList(kingX, i));
                break;
            }
        }

        for (int i = kingY; i >= 0; i--) {
            if (board[kingX][i] == 1) {
                solution.add(Arrays.asList(kingX, i));
                break;
            }
        }

        for (int i = kingX, j = kingY; i < 8 && j < 8; i++, j++) {
            if (board[i][j] == 1) {
                solution.add(Arrays.asList(i, j));
                break;
            }
        }

        for (int i = kingX, j = kingY; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                solution.add(Arrays.asList(i, j));
                break;
            }
        }

        for (int i = kingX, j = kingY; i < 8 && j >= 0; i++, j--) {

            if (board[i][j] == 1) {
                solution.add(Arrays.asList(i, j));
                break;
            }
        }

        for (int i = kingX, j = kingY; i >= 0 && j < 8; i--, j++) {
            if (board[i][j] == 1) {
                solution.add(Arrays.asList(i, j));
                break;
            }
        }

        return solution;
    }
}
