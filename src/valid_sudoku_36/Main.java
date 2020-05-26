package valid_sudoku_36;

import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String args[]) {

		char board[][] = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' }, };

		System.out.println(isValidSudoku(board));
		char board_[][] = { { '.', '.', '.', '.', '5', '.', '.', '1', '.' },
				{ '.', '4', '.', '3', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '3', '.', '.', '1' },
				{ '8', '.', '.', '.', '.', '.', '.', '2', '.' }, { '.', '.', '2', '7', '.', '.', '.', '.', '.' },
				{ '.', '1', '5', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '2', '.', '.', '.' },
				{ '.', '2', '.', '9', '.', '.', '.', '.', '.' }, { '.', '.', '4', '.', '.', '.', '.', '.', '.' }, };

		System.out.println(isValidSudoku(board_));

	}

	public static boolean isValidSudoku(char[][] board) {

		int row = board.length;

		int col = board[0].length;

		for (int i = 0; i < row; i++) {

			Set<Character> set = new HashSet<>();

			for (int j = 0; j < col; j++) {
				if (board[i][j] != '.') {
					if (!set.add(board[i][j])) {
						return false;
					}

				}
			}
			set.clear();
			for (int j = 0; j < col; j++) {
				if (board[j][i] != '.') {
					if (!set.add(board[j][i])) {
						return false;
					}
				}
			}
		}

		if (!checker(board, 0, 2, 0, 2))
			return false;
		if (!checker(board, 0, 2, 3, 5))
			return false;
		if (!checker(board, 0, 2, 6, 8))
			return false;
		if (!checker(board, 3, 5, 0, 2))
			return false;
		if (!checker(board, 3, 5, 3, 5))
			return false;
		if (!checker(board, 3, 5, 6, 8))
			return false;
		if (!checker(board, 6, 8, 0, 2))
			return false;
		if (!checker(board, 6, 8, 3, 5))
			return false;
		if (!checker(board, 6, 8, 6, 8))
			return false;

		return true;
	}

	private static boolean checker(char[][] board, int start, int end, int start_1, int end_1) {

		Set<Character> set = new HashSet<>();

		for (int i = start; i <= end; i++) {
			for (int j = start_1; j <= end_1; j++) {
				if (board[i][j] != '.') {
					if (!set.add(board[i][j])) {
						return false;
					}

				}
			}
		}

		return true;
	}

}
