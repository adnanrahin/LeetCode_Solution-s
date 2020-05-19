package find_pivot_index_724;

public class Main {

	public static void main(String args[]) {

		System.out.println(pivotIndex(new int[] { 1, 7, 3, 6, 5, 6 }));
		System.out.println(pivotIndex(new int[] { 1, 2, 3 }));
		System.out.println(pivotIndex(new int[] { 1, 7, 3, 6, 5, 6 }));
		System.out.println(pivotIndex(new int[] { 1, 2, 1 }));
		System.out.println(pivotIndex(new int[] { 2, 2, 1, 1 }));
		System.out.println(pivotIndex(new int[] { 2, 1, 2, 3 }));
		System.out.println(pivotIndex(new int[] { -1, -1, -1, -1, -1, -1 }));
	}

	public static int pivotIndex(int[] nums) {

		if (nums.length == 0)
			return -1;
		if (nums.length == 1)
			return 0;
		if (nums.length == 2)
			return -1;
		
		int totalsum = 0;
		int leftsum = 0;
		
		for(int i = 0; i < nums.length; i++) {
			totalsum += nums[i];
		}
		
		for(int i = 0 ; i < nums.length; i++) {
			totalsum -= nums[i];
			
			if(totalsum == leftsum)
				return i;
			leftsum+=nums[i];
		}
		
		return -1;
	}

}
