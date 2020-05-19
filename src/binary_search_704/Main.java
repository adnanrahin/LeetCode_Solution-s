package binary_search_704;

public class Main {
	
	public static void main(String args[]) {
		
	}
	
	public static int search(int nums[], int target) {
		
		int left = 0;
		int right = nums.length - 1;
		
		while(left <= right) {
			int pivot = (left + right) / 2;
			
			if(nums [pivot] == target)
				return pivot;
			else if(target > nums[pivot]) {
				left = pivot + 1;
			}
			else if(target < nums[pivot]) {
				right = pivot - 1;
			}
		}
		
		return -1;
	}
	
}
