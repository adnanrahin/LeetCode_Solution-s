package house_robber_198;

public class Main {

	public static void main(String args[]) {
		
	}

	public static int rob(int []nums) {
		
		int arr[] = new int [nums.length];
		
		if(nums.length == 1)
			return nums[0];
		
		if(nums.length == 0)
			return 0;
		
		arr[0] = nums[0];
		
		arr[1] = Math.max(nums[0], nums[1]);
		
		for(int i = 2; i < nums.length; i++) {
			arr[i] = Math.max(arr[i-2] + nums[i], arr[i-1]);
		}
		
		return arr[nums.length - 1];
	}
	
}
