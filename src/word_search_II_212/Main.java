package word_search_II_212;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

	public static void main(String args[]) {

	}

	public static List<String> findWords(char[][] grid, String[] words) {

		Set<String> set = new HashSet<String>();
		for (String string : words) {
			if (helper(grid, string))
				set.add(string);
		}
		return new ArrayList<String>(set);
	}

	public static boolean helper(char[][] grid, String word) {

		boolean[][] visited = new boolean[grid.length][grid[0].length];

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++)
				if (recur(grid, i, j, 0, word, visited))
					return true;
		}
		return false;
	}

	public static boolean isValid(char[][] grid, int startrow, int startcol) {

		int row = grid.length;
		int col = grid[0].length;

		if ((startcol >= 0 && startcol <= col - 1) && (startrow <= row - 1 && startrow >= 0)) {
			return true;
		}

		return false;
	}

	public static boolean recur(char[][] grid, int row, int col, int level, String str, boolean[][] visited) {

		if (level == str.length())
			return true;

		if (isValid(grid, row, col)) {

			if (!visited[row][col] && str.charAt(level) == grid[row][col]) {
				visited[row][col] = true;
				if (recur(grid, row + 1, col, level + 1, str, visited))
					return true;
				else if (recur(grid, row - 1, col, level + 1, str, visited))
					return true;
				else if (recur(grid, row, col + 1, level + 1, str, visited))
					return true;
				else if (recur(grid, row, col - 1, level + 1, str, visited))
					return true;

				visited[row][col] = false;

				return false;

			}

			return false;

		}

		return false;
	}

}
