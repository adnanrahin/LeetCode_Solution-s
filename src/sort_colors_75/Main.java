package sort_colors_75;

public class Main {
	
	public static void main(String args[]) {
		
	}
	
	public static void sortColors(int []nums) {
		
		int zeros = 0, once = 0, twos = 0;
		
		for(int i=0; i<nums.length; i++) {
			if(nums[i] == 0)
				zeros++;
			if(nums[i] == 1)
				once++;
			if(nums[i] == 2)
				twos++;
		}
		
		for(int i=0; i<zeros; i++)
			nums[i] = 0;
		for(int i=zeros; i<zeros + once; i++)
			nums[i] = 1;
		for(int i = zeros + once; i<zeros + once + twos; i++)
			nums[i] = 2;
	}
	
}
