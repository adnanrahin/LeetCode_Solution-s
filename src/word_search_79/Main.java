package word_search_79;

public class Main {

	public static void main(String args[]) {

		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };

		System.out.println(exist(board, "ABCCED"));
		System.out.println(exist(board, "SEE"));
		System.out.println(exist(board, "ABCB"));
		char[][] board_1 = { { 'a', 'a' } };
		System.out.println(exist(board_1, "aa"));

		char[][] board_2 = { { 'C', 'A', 'A' }, { 'A', 'A', 'A' }, { 'B', 'C', 'D' } };
		System.out.println(exist(board_2, "AAB"));
	}

	public static boolean exist(char[][] board, String word) {

		boolean[][] visited = new boolean[board.length][board[0].length];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++)
				if (checkmaze(board, visited, i, j, word, 0))
					return true;
		}
		return false;
	}

	private static boolean isvalid(char[][] board, int startRow, int startCol) {

		if (startRow >= 0 && startRow < board.length && startCol >= 0 && startCol < board[0].length) {
			return true;
		}
		return false;
	}

	public static boolean checkmaze(char[][] board, boolean[][] visited, int startRow, int startCol, String word,
			int index) {

		if (index == word.length())
			return true;

		if (!isvalid(board, startRow, startCol) || visited[startRow][startCol])
			return false;

		if (word.charAt(index) == board[startRow][startCol]) {
			visited[startRow][startCol] = true;

			if (checkmaze(board, visited, startRow + 1, startCol, word, index + 1)) {
				return true;
			} else if (checkmaze(board, visited, startRow, startCol + 1, word, index + 1)) {
				return true;
			} else if (checkmaze(board, visited, startRow - 1, startCol, word, index + 1)) {
				return true;
			} else if (checkmaze(board, visited, startRow, startCol - 1, word, index + 1)) {
				return true;
			}
			visited[startRow][startCol] = false;
			return false;

		}

		return false;

	}

}
