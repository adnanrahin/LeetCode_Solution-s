package rectangle_area_223;

public class Main {

	public static void main(String args[]) {
		System.out.println(computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
		System.out.println(computeArea(-2, -2, 2, 2, 3, 3, 4, 4));
	}

	public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {

		int area_1 = area(A, C, B, D);
		int area_2 = area(E, G, F, H);

		int x1 = Math.max(A, E); // left
		int y1 = Math.max(B, F); // bottom
		int x2 = Math.min(C, G); // right
		int y2 = Math.min(D, H); // top

		if (C < E || G < A || B > H || D < F)
			return area_1 + area_2;

		return (area_1 + area_2) - area(x1, x2, y1, y2);
	}

	private static int area(int x1, int x2, int y1, int y2) {

		int area = (x1 - x2) * (y1 - y2);

		return Math.abs(area);
	}

}
