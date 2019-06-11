package container_with_most_water_11;

public class Main {

	public static void main(String args[]) {
		
		System.out.println(maxArea(new int [] {1,8,6,2,5,4,8,3,7}));
		System.out.println(maxArea(new int [] {4,4}));
		System.out.println(maxArea(new int [] {3,2,1,3}));
		System.out.println(maxArea(new int[] {1,2,3,4,5,6,7,8,9,10}));
		System.out.println(maxArea(new int[] {1,3,2,5,25,24,5}));
		System.out.println(maxArea(new int[] {5,2,12,1,5,3,4,11,9,4}));
	}

	public static int maxArea(int[] height) {
		int temp = 0, local = 0;
		int i = 0, j = height.length;
		int w, l;
		
		while (i < j) {
			w = j - (i + 1);
			l = Math.min(height[j - 1], height[i]);
			
			local = w * l;
			if (temp < local) {
				temp = local;
			}
			
			if (height[i] < height[j-1]) i++;
			else j--;
	
		}
		return temp;
	}

}
