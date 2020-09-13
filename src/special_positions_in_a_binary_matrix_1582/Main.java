package special_positions_in_a_binary_matrix_1582;

public class Main {

    public static void main(String[] args) {
        System.out.println(numSpecial(new int[][]{{1, 0, 0}, {0, 0, 1}, {1, 0, 0}}));
    }

    public static int numSpecial(int[][] mat) {
        int answer = 0;
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1 && !visited[i][j] && isOnlyOne(mat, i, j, visited)) {
                    answer++;
                }
            }
        }
        return answer;
    }

    public static boolean isOnlyOne(int[][] mat, int row, int col, boolean[][] visited) {
        int counter = 0;
        for (int i = 0; i < mat[0].length; i++) {
            if (mat[row][i] == 1) {
                counter++;
                visited[row][i] = true;
            }
        }
        for (int i = 0; i < mat.length; i++) {
            if (mat[i][col] == 1) {
                counter++;
                visited[i][col] = true;
            }
        }
        return counter == 2;
    }

}
