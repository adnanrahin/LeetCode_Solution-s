package transpose_matrix_867;

public class Main {
	
	public static void main(String args[]) {
		
	}
	
	public static int[][] transpose(int mat[][]) {
		int row = mat.length;
		int col = mat[0].length;

		int mat_2[][] = new int[col][row];
		
		for(int i = 0 ; i < col; i++) {
			for ( int j = 0; j < row; j++) {
				
				mat_2[i][j] = mat[j][i];
				
			}
		}
		return mat_2;
	}
}
